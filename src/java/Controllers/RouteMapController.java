
package Controllers;

import Managers.LocationManager;
import Managers.LocationManagerImpl;
import Managers.MultimediaManager;
import Managers.MultimediaManagerImpl;
import Managers.PersonManager;
import Managers.PersonManagerImpl;
import Objects.Location;
import Objects.Multimedia;
import Objects.Person;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Laura
 */
@Controller
public class RouteMapController {
     @RequestMapping(method = RequestMethod.GET)
    public ModelAndView get(HttpServletRequest request, HttpServletResponse response, @RequestParam("idco") String idco) {
        ModelAndView result = new ModelAndView("routeMap");

        //Récupération de l'utilisateur
        PersonManager pm = PersonManagerImpl.getInstance();
        Person p = pm.findPerson(idco);
        result.addObject("email", p.getPersonEmail());
        result.addObject("nom", p.getPersonName());
        result.addObject("prenom", p.getPersonFirstname());
         result.addObject("id", p.getPersonId());

        //Connexion de l'utilisateur 
        result.addObject("idco", idco);

        //Récupération des multimédias
        //TODO

        return result;
    }
}
