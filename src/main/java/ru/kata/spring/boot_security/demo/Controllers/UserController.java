package ru.kata.spring.boot_security.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import ru.kata.spring.boot_security.demo.Models.User;
import ru.kata.spring.boot_security.demo.Service.UserService;


import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }




    @GetMapping("/user")
    public String showUser(Principal principal, Model model) {
        User authenticatedUser = userService.findByEmail(principal.getName());
        model.addAttribute("authenticatedUserRoles", authenticatedUser.getRoles());



        return "user";

    }


    @GetMapping("/admin")
    public String admin(ModelMap model, @ModelAttribute("newUser") User newUser, Principal principal) {
        User authenticatedUser = userService.findByEmail(principal.getName());
        model.addAttribute("authenticatedUserRoles", authenticatedUser.getRoles());
        return "admin_profile";
    }


    @GetMapping("/")
    public String redirect() {
        return "redirect:/login";
    }

    @GetMapping("/user/logout")
    public String logout(HttpServletRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            request.getSession().invalidate();
        }
        return "redirect:/login";
    }









}
