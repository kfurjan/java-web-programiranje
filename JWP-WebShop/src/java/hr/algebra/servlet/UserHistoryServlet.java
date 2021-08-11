package hr.algebra.servlet;

import hr.algebra.model.User;
import hr.algebra.repository.history.UserHistoryRepository;
import hr.algebra.repository.history.UserHistoryRepositoryFactory;
import hr.algebra.util.Strings;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Kevin
 */
public class UserHistoryServlet extends HttpServlet {

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
        processUserHistoryData(request, response);
    }
    
    /**
     * Data UserHistory data and send them back to view.
     * Only 'Admin' user taype can access user history data. In case another user type
     * tries to access it, redirect to home page.
     * 
     * @param request
     * @param response
     * @throws IOException 
     */
    private void processUserHistoryData(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        try {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute(Strings.USER_KEY);

            if (user.getUserType().getType().equals(Strings.ADMIN)) {
                request.setAttribute(
                        Strings.USER_HISTORY_KEY,
                        userHistoryRepository.getAllUserHistory()
                );
                request
                        .getRequestDispatcher(Strings.USER_HISTORY_ENDPOINT)
                        .forward(request, response);   
            } else {
                response.sendRedirect(Strings.HOME_ENDPOINT);
            }
        } catch (Exception e) {
            response.sendRedirect(Strings.HOME_ENDPOINT);
        }
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
        processUserHistoryData(request, response);
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
