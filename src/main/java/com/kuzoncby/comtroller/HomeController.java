package com.kuzoncby.comtroller;

import com.kuzoncby.model.Role;
import com.kuzoncby.model.User;
import com.kuzoncby.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Kuzon on 2016/6/23.
 */
@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

//    @Autowired
//    private UserRepository userRepository;

    @RequestMapping(value = {"", "/home"}, method = RequestMethod.GET)
    public String home() {
//        第一次执行请取消注释
//        User admin = new User();
//        admin.setEmail("admin@example.com");
//        admin.setPassword("secret");
//        admin.setRole(Role.ADMIN);
//        userRepository.save(admin);
//
//        User user = new User();
//        user.setEmail("user@example.com");
//        user.setPassword("secret");
//        user.setRole(Role.USER);
//        userRepository.save(user);
        return "home";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole('admin')")
    public String helloAdmin() {
        return "admin";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole('admin', 'user')")
    public String helloUser() {
        return "user";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }
}
