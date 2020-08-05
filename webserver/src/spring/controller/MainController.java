package spring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String Root(ModelMap map){
        return "home";
    }

    @RequestMapping(value = "/**", method = RequestMethod.GET)
    public String Error(ModelMap map){
        return "error";
    }

}