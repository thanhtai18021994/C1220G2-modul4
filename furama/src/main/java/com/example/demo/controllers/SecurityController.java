package com.example.demo.controllers;

import com.example.demo.dto.UserDto;
import com.example.demo.model.Cart;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.service.security.RoleService;
import com.example.demo.service.security.UserService;
import com.example.demo.ultil.EncrypPasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.HashSet;
import java.util.Set;


@Controller
@SessionAttributes("cart")
public class SecurityController {
    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @ModelAttribute("cart")
    public Cart getCart(){
        return new Cart();
    }

    @GetMapping("/login")
    public String getLoginPage(Model model){

        return "authentication/login";
    }

  
    @GetMapping("/register")
    public ModelAndView getRegisterPage(){
        return new ModelAndView("authentication/register","registerUser",new UserDto());
    }

    @PostMapping("/register")
    public String registerUser(@Validated @ModelAttribute("registerUser") UserDto registerUser, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "authentication/register";
        }else {
            User user = new User();
            user.setEmail(registerUser.getEmail());
            user.setPassword(EncrypPasswordUtils.EncrypPasswordUtils(registerUser.getPassword()));
            Role roleEntity = roleService.findByName("ROLE_MEMBER");
            Set<Role> listRoles = new HashSet<>();
            listRoles.add(roleEntity);
            user.setRoles(listRoles);
            userService.save(user);

            return "redirect:/login";
        }
    }

    @GetMapping("/403")
    public String getPage403(){
        return "authentication/403";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
            Cookie cookie = new Cookie("remember-me", "");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
        return "redirect:/";
    }

    public String saveCart(@SessionAttribute("cart") Cart cart,Model model){
        Object principal= SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email=((UserDetails)principal).getUsername();
        User user=userService.findByEmail(email);
        cart.setUser(user);
        return "/homepage/customer/homePage";
    }
}
