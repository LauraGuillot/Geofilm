/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

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
public class InscriptionController {
    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView post(@RequestParam("email") String email, @RequestParam("mdp") String mdp) {
        ModelAndView r = new ModelAndView("redirect:globalMap.htm");
        
      
        
        return r;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView get(HttpServletRequest request, HttpServletResponse response, @RequestParam("idco") String idco) {
        ModelAndView result = new ModelAndView("globalMap");

      
        return result;
    }
}
