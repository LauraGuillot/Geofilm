/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Managers.ConnectManager;
import Managers.ConnectManagerImpl;
import Managers.MultimediaManager;
import Managers.MultimediaManagerImpl;
import Managers.PersonManager;
import Managers.PersonManagerImpl;
import Objects.Multimedia;
import Objects.Person;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UploadMultimedia", urlPatterns = {"/UploadMultimedia"})
public class UploadMultimedia extends HttpServlet {
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

        //On récupère les paramètres
        String idco = request.getParameter("idco");
        String multiid = request.getParameter("id");
        String type = request.getParameter("type");
        
        //Mise à jour des connexions
        ConnectManager cm = ConnectManagerImpl.getInstance();
        cm.updateConnection(cm.getByConnectId(idco));
        cm.checkConnection();

        
        //Envoi de la réponse
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().write("done");
    }
}





