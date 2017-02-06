/**
 * Servlet appelée à chaque fois qu'un utilisateur effectue une action sur le site.
 * Elle met alors à jour sa connexion.
 */
package Servlets;

import Managers.ConnectManager;
import Managers.ConnectManagerImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UpdateConnexionServlet", urlPatterns = {"/UpdateConnexionServlet"})
public class UpdateConnexionServlet extends HttpServlet {

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
        String idco = request.getParameter("idco");
        ConnectManager m = ConnectManagerImpl.getInstance();
        m.updateConnection(m.getByConnectId(idco));
        m.checkConnection();
    }

}
