/*
 * Servlet pour tester si le login et mdp d'un utilisateur sont corrects ou non
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

/**
 *
 * @author Laura
 */
@WebServlet(name = "ControlConnexionServlet", urlPatterns = {"/ControlConnexionServlet"})
public class ControlConnexionServlet extends HttpServlet {

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
        String mdp = request.getParameter("mdp");
        String email = request.getParameter("email");
        ConnectManager m = ConnectManagerImpl.getInstance();
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().write(m.identifierValidation(email, mdp) + "");

    }
}
