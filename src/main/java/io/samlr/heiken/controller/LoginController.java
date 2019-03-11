package io.samlr.heiken.controller;

import io.samlr.heiken.entity.Role;
import io.samlr.heiken.entity.User;
import io.samlr.heiken.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Collections;

@Controller
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("registration")
    public String newUser(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("edit", false);
        return "registrationUser";
    }

    @PostMapping("registration")
    public String saveUser(@Valid User user, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "registrationEquipment";
        }
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.ROLE_USER));
        userService.addUser(user);

        model.addAttribute("success", "Пользователь: " + user.getFirstName()+" " +user.getLastName() + " успешно зарегистрирован!");
        return "redirect:login";
    }

    @RequestMapping(value = {"/login"})
    public ModelAndView getLoginPage(@RequestParam(value = "error", required = false) String error) {
        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username or password!");
        }
        model.setViewName("login");
        return model;
    }

}
