package ru.kata.spring.boot_security.demo.Service;

import ru.kata.spring.boot_security.demo.Models.Role;
import ru.kata.spring.boot_security.demo.Models.User;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;


public interface UserService extends UserDetailsService {

    @Override
    UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;

    User getUser(Long id);

    List<User> getUsers();

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);

    List<Role> listRoles();

    User findByEmail(String email);


}
