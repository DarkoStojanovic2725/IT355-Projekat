package com.it355.projekat.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "logout", required = false) String logout,
                        Model model) {

        if (error != null) {
            model.addAttribute("error", "Pogresno korisnicko ime ili lozinka");
        }

        if (logout != null) {
            model.addAttribute("msg", "Uspesno odjavljivanje");
        }

        return "login";
    }

    @RequestMapping("/noaccess")
    public String errorPg(){
        return "noaccess";
    }
}
