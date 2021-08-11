package hr.algebra.servlet;

import hr.algebra.model.User;
import hr.algebra.model.UserHistory;
import hr.algebra.repository.auth.AuthenticationRepositoryFactory;
import hr.algebra.util.Strings;
import java.io.IOException;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import hr.algebra.repository.auth.AuthenticationRepository;
import hr.algebra.repository.history.UserHistoryRepository;
import hr.algebra.repository.history.UserHistoryRepositoryFactory;
import hr.algebra.util.DateUtils;
import hr.algebra.util.NetworkUtils;
import javax.servlet.http.HttpSession;

/**
 *
 * @author efurkev
 */
public class LoginServlet extends HttpServlet {
    
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
        response.sendRedirect(Strings.LOGIN_ENDPOINT);
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
        String password = request.getParameter(Strings.PASSWORD);
        Optional<User> user = authRepository.loginUser(email, password);
        
        if (user.isPresent()) {
            userHistoryRepository.saveUserHistory(
                new UserHistory(
                    user.get(),
                    DateUtils.getCurrentDate(Strings.DATE_PATTERN),
                    NetworkUtils.getIpAddress()
                )
            );
            
            HttpSession session = request.getSession();
            session.setAttribute(Strings.USER_KEY, user.get());
            response.sendRedirect(Strings.HOME_ENDPOINT);
        } else {
            request.setAttribute(Strings.ERROR_MESSAGE_KEY, Strings.INVALID_EMAIL_PASSWORD);
            request.getRequestDispatcher(Strings.LOGIN_ENDPOINT).forward(request, response);
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
