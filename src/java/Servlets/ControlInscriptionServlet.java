/*
 * Servlet pour tester si l'adresse email saisie lors de l'inscription est déjà dans la base de données ou non.
 * Si l'adresse email n'est pas déjà utilisée, on inscrit l'utilisateur.
 */
package Servlets;

import Managers.PersonManager;
import Managers.PersonManagerImpl;
import Objects.Person;
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
@WebServlet(name = "ControlInscriptionServlet", urlPatterns = {"/ControlInscriptionServlet"})
public class ControlInscriptionServlet extends HttpServlet {

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

        String email = request.getParameter("email");
        String mdp = request.getParameter("mdp");
        String name = request.getParameter("name");
        String firstname = request.getParameter("firstname");

        PersonManager pm = PersonManagerImpl.getInstance();
        Person p = pm.findPersonByEmail(email);

        Boolean b = (p == null);

        //Inscription
        if (b) {
            pm.insert(email, mdp, name, firstname);
        }

        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().write(b + "");
    }
}
