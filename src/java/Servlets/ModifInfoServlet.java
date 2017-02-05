/*
 * Servlet pour mettre à jour les informations d'un utilisateur 
 */
package Servlets;

import Managers.PersonManager;
import Managers.PersonManagerImpl;
import Objects.Person;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Laura
 */
@WebServlet(name = "ModifInfoServlet", urlPatterns = {"/ModifInfoServlet"})
public class ModifInfoServlet extends HttpServlet {
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
        String idco = request.getParameter("idco");
        String name = request.getParameter("name");
        String firstname = request.getParameter("firstname");

        PersonManager pm = PersonManagerImpl.getInstance();
        Person p = pm.findPersonByEmail(email);
        Person p1=pm.findPerson(idco);

        //On teste si le nouveau email est déjà utilisé par un autre utilisateur ou non 
        Boolean b = (p == null)||(p.equals(p1));

        //Update
        if (b) {
            pm.updateInfos(p1,email,name,firstname);
        }

        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().write(b + "");
    }
}
