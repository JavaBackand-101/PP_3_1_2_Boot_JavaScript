package ru.kata.spring.boot_security.demo.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.Models.User;
import ru.kata.spring.boot_security.demo.Service.UserService;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin_profile")
public class AdminController {

    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public String getUsers(ModelMap model, @AuthenticationPrincipal User user) {
        model.addAttribute("users", userService.getUsers());
        model.addAttribute("user", user);
        return "admin_profile";


    }


    @GetMapping("/save")
    public String saveAllUser(ModelMap model, @AuthenticationPrincipal User user) {
        User newUser = new User();
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("user", newUser);
        modelMap.put("Roles", userService.listRoles());
        modelMap.put("CurrentUser", user);
        model.addAllAttributes(modelMap);
        return "saveUser";





    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/admin_profile";

    }

    @GetMapping("/{id}/update")
    public String updateUser(@PathVariable("id") Long id, ModelMap modelMap, @AuthenticationPrincipal User user) {
        Map<String, Object> model = new HashMap<>();
        model.put("user", userService.getUser(id));
        model.put("listRoles", userService.listRoles());
        model.put("currentUser", user);
        modelMap.addAllAttributes(model);
        return "update";

    }


    @PatchMapping("/update")
    public String saveUpdateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/admin_profile";

    }





    @DeleteMapping("/{id}/delete")
    public String deleteUser(@PathVariable(name = "id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin_profile";

    }




    }




