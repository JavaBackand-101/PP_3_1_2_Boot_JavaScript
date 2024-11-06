package ru.kata.spring.boot_security.demo.Initializer;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.Models.Role;
import ru.kata.spring.boot_security.demo.Models.User;
import ru.kata.spring.boot_security.demo.Repository.RoleRepository;
import ru.kata.spring.boot_security.demo.Service.UserService;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

//@Component
//public class InitializerDataBase {
//
//    private final RoleRepository roleRepository;
//
//    private final UserService userService;
//
//    @Autowired
//    public InitializerDataBase(RoleRepository roleRepository, UserService userService) {
//        this.roleRepository = roleRepository;
//        this.userService = userService;
//
//    }
//
//
//  @PostConstruct
//    @Transactional
//    public void init() {
//
//        Role adminRole = new Role();
//        adminRole.setRoleName("ROLE_ADMIN");
//        roleRepository.save(adminRole);
//
//        Role userRole = new Role();
//        userRole.setRoleName("ROLE_USER");
//        roleRepository.save(userRole);
//
//
//        Set<Role> adminRoles = new HashSet<>();
//        adminRoles.add(adminRole);
//        adminRoles.add(userRole);
//
//
//            User admin = new User();
//            admin.setUsername("Islam");
//            admin.setSurname("Makhauri");
//            admin.setAge(22);
//            admin.setEmail("islam999.osago@gmail.com");
//            admin.setPassword("islam2002");
//            admin.setRoles(adminRoles);
//            userService.saveUser(admin);
//
//            Set<Role> userRoles = new HashSet<>();
//            userRoles.add(userRole);
//
//
//
//                User user = new User();
//                user.setUsername("Ali");
//                user.setSurname("Muradov");
//                user.setAge(21);
//                user.setEmail("ali999.osago@gmail.com");
//                user.setPassword("ali2003");
//                user.setRoles(userRoles);
//                userService.saveUser(user);
//
//
//            }
//        }
//
