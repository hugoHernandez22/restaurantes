package net.restaurante.springboot.controller;
/*
import  net.restaurante.springboot.security.TokenAuthentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@CrossOrigin(origins = "http://127.0.0.1:4200")
@SuppressWarnings("unused")
@Controller
public class HomeController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/", method = RequestMethod.GET)
    protected String home(final Model model, final Authentication authentication) {
        logger.info("Home page");

        if (authentication instanceof TokenAuthentication) {
            TokenAuthentication tokenAuthentication = (TokenAuthentication) authentication;
            model.addAttribute("profile", tokenAuthentication.getClaims());
        }

        // If not authenticated, still show home page.
        // View will render appropriate login/menu based on authentication status
        return "index";
    }
}*/