package hr.algebra.servlet;

import hr.algebra.model.User;
import hr.algebra.model.UserHistory;
import hr.algebra.model.UserType;
import hr.algebra.repository.auth.AuthenticationRepository;
import hr.algebra.repository.auth.AuthenticationRepositoryFactory;
import hr.algebra.repository.history.UserHistoryRepository;
import hr.algebra.repository.history.UserHistoryRepositoryFactory;
import hr.algebra.util.DateUtils;
import hr.algebra.util.NetworkUtils;
import hr.algebra.util.Strings;
import java.io.IOException;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author efurkev
 */
public class RegisterServlet extends HttpServlet {

    private final AuthenticationRepository authRepository = AuthenticationRepositoryFactory.getRepository();
    private final UserHistoryRepository userHistoryRepository = UserHistoryRepositoryFactory.getRepository();

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect(Strings.REGISTER_ENDPOINT);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter(Strings.EMAIL);
        String firstName = request.getParameter(Strings.FIRST_NAME);
        String lastName = request.getParameter(Strings.LAST_NAME);
        String password = request.getParameter(Strings.PASSWORD);
        String passwordRepeat = request.getParameter(Strings.PASSWORD_REPEAT);
        UserType userType = new UserType(2, "User");

        if (
            email.isEmpty()
            || firstName.isEmpty()
            || lastName.isEmpty()
            || password.isEmpty()
            || passwordRepeat.isEmpty()
        ) {
            request.setAttribute(Strings.ERROR_MESSAGE_KEY, Strings.FIELDS_CANT_BE_EMPTY);
            request.getRequestDispatcher(Strings.REGISTER_ENDPOINT).forward(request, response);
        } else if (!password.equals(passwordRepeat)) {
            request.setAttribute(Strings.ERROR_MESSAGE_KEY, Strings.NON_MATCHING_PASSWORDS);
            request.getRequestDispatcher(Strings.REGISTER_ENDPOINT).forward(request, response);
        } else {
            User user = new User();
            user.setEmail(email);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setPassword(password);
            user.setUserType(userType);
            Optional<User> dbUser = authRepository.registerUser(user);
            
            if (dbUser.isPresent()) {
                userHistoryRepository.saveUserHistory(
                    new UserHistory(
                        dbUser.get(),
                        DateUtils.getCurrentDate(Strings.DATE_PATTERN),
                        NetworkUtils.getIpAddress()
                    )
                );
                
                HttpSession session = request.getSession();
                session.setAttribute(Strings.USER_KEY, dbUser.get());
                response.sendRedirect(Strings.HOME_ENDPOINT);
            } else {
                request.setAttribute(Strings.ERROR_MESSAGE_KEY, Strings.ERROR_WHILE_REGISTERING);
                request.getRequestDispatcher(Strings.REGISTER_ENDPOINT).forward(request, response);
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
