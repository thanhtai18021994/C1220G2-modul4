package com.example.demo.controller;

import com.example.demo.Service.UserService;
import com.example.demo.Service.blog.IBlogService;
import com.example.demo.Service.category.ICategoryService;
import com.example.demo.Service.impl.UserServiceImpl;
import com.example.demo.dto.UserDto;
import com.example.demo.model.Blog;
import com.example.demo.model.User;
import com.example.demo.util.EncrypPasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    IBlogService blogService;
    @Autowired
    ICategoryService categoryService;
    @Autowired
    UserService userService;

    @GetMapping
    public String getIndex(Model model){
        Pageable pageable= PageRequest.of(0,4);
        model.addAttribute("blogs",blogService.findAll(pageable).getContent());
        return "/blog/index";
    }

    @GetMapping("/{num}")
    public String getIndex(Model model,@PathVariable Integer num){
        Pageable pageable= PageRequest.of(num,4);
        model.addAttribute("blogs",blogService.findAll(pageable).getContent());
        return "/blog/search";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Blog blog,Model model){
        blogService.save(blog);
        return "redirect:/";
    }

    @GetMapping("/create")
    public ModelAndView getCreate(){
       ModelAndView modelAndView= new ModelAndView("/blog/create2");
       modelAndView.addObject("blog",new Blog());
       modelAndView.addObject("categories",categoryService.findAll());
        return modelAndView;
    }

//    @RequestMapping(value = "/api/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody

    @GetMapping("/search/{text}")
    public String search(@PathVariable String text,Model model){
        model.addAttribute("blogs",blogService.filter(text));
        return "/blog/search";
    }

    @GetMapping("/view/{id}")
    public String view(Model model, @PathVariable Integer id){
        Optional<Blog> blog=blogService.findById(id);
        model.addAttribute("blog",blog.get());
        return "/blog/view2";
    }

    @GetMapping("/register")
    public String getRegister(Model model){
        model.addAttribute("register",new UserDto());
        return "/blog/register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("register") UserDto register, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/blog/register";
        }else {
            User user=new User();
            user.setUserName(register.getFullName());
            user.setEmail(register.getEmail());
            user.setPassword(EncrypPasswordUtils.EncrypPasswordUtils(register.getPassword()));
            userService.save(user);
            return "redirect:/";
        }
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "/blog/login";
    }
}
