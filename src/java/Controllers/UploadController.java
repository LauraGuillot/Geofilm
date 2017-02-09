/**
 * ********************************************************************
 * Controller Uploading page pour uploader un multimédia
 * --------------------------------------------------------------------
 * Last update : 09/02/2017
 *********************************************************************
 */
package Controllers;

import Managers.ConnectManager;
import Managers.ConnectManagerImpl;
import Managers.LocationManager;
import Managers.LocationManagerImpl;
import Managers.PersonManager;
import Managers.PersonManagerImpl;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UploadController {

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView deco(@RequestParam("idco") String idco) {
        ModelAndView r = new ModelAndView("redirect:uploading.htm");
        r.addObject("idco", idco);
        return r;
    }
     @RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleDeco(HttpServletRequest request, HttpServletResponse response, @RequestParam("idco") String idco) {
        ModelAndView r = new ModelAndView("uploading");

        ConnectManager cm = ConnectManagerImpl.getInstance();
        PersonManager pm = PersonManagerImpl.getInstance();

        //Si il y a une personne à déconnecter
        if (!idco.equals("0")) {
            cm.deconnect(pm.findPerson(idco));
        }

        //Mise à jour des connexions dans la base de données
        cm.checkConnection();

        return r;
    }

}
