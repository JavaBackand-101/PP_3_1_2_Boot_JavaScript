package ru.kata.spring.boot_security.demo.Initializer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.Models.Role;
import ru.kata.spring.boot_security.demo.Models.User;
import ru.kata.spring.boot_security.demo.Service.UserService;

import javax.annotation.PostConstruct;

import java.util.ArrayList;


import java.util.List;


@Component
public class InitializerDataBase{


    private final UserService userService;


    @Autowired
    public InitializerDataBase(UserService userService) {
        this.userService = userService;

    }


    @PostConstruct
    public void init(){

        User user = userService.findByEmail("islam999.osago@gmail.com");

        if(user == null){

            Role userRole = new Role("ROLE_USER");
            Role adminRole = new Role("ROLE_ADMIN");

            List<Role> adminRoles = new ArrayList<>();
            adminRoles.add(adminRole);
            adminRoles.add(userRole);

            User admin = new User(adminRoles, "Islam", "Makhauri", 22L, "islam999.osago@gmail.com", "islam2002");

            userService.saveUser(admin);





        }




    }

}






