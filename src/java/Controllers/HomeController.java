/**
 * ********************************************************************
 * Controller Home page (index)
 * --------------------------------------------------------------------
 * Last update : 29/01/2017
 *********************************************************************
 */
package Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleHome(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView result = new ModelAndView("index");
        return result;
    }
}