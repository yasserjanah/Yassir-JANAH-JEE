package me.janah.studentmanagement.security;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SecurityController {

    @RequestMapping(value = "/sys/login", method = RequestMethod.GET)
    @PreAuthorize("isAnonymous()")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");
        return "login";
    }

    @RequestMapping(value = "/sys/logout", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated()")
    public String logout(HttpServletRequest request) {
        // manually logout
        request.getSession().invalidate();
        return "redirect:/sys/login";
    }
}
