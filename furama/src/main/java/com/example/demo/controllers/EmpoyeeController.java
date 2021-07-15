package com.example.demo.controllers;

import com.example.demo.model.*;
import com.example.demo.service.division.IDivisionService;
import com.example.demo.service.educationDegree.IEducationDegreeService;
import com.example.demo.service.employee.IEmployeeService;
import com.example.demo.service.position.IPositionService;
import com.example.demo.service.security.RoleService;
import com.example.demo.service.security.UserService;
import com.example.demo.ultil.EncrypPasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.*;

@Controller
@RequestMapping("/employee")
@SessionAttributes("cart")
public class EmpoyeeController {
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IDivisionService divisionService;
    @Autowired
    private IPositionService positionService;
    @Autowired
    IEducationDegreeService educationDegreeService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;

    @ModelAttribute("cart")
    public Cart getCart(){
        return new Cart();
    }

    @GetMapping
    public String homepage(Model model, Pageable pageable,
                           @RequestParam(required = false) String name,
                           @RequestParam(required = false) String address,
                           @RequestParam(required = false) Position position,
                           @RequestParam(required = false) Division division,
                           @SessionAttribute("cart") Cart cart){
        Object principal= SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email=((UserDetails)principal).getUsername();
        User user=userService.findByEmail(email);
        cart.setUser(user);
        Pageable pageable1= PageRequest.of(pageable.getPageNumber(),5);
        if((name!=null||address!=null)&&position!=null&&division!=null){
            model.addAttribute("name",name);
            model.addAttribute("address",address);
            model.addAttribute("position",position.getPositionId());
            model.addAttribute("division",division.getDivisionId());
            model.addAttribute("positions",positionService.findAll());
            model.addAttribute("divisions",divisionService.findAll());
            model.addAttribute("list",employeeService.findByFourField(name, address, position, division, pageable));
        }else if ((name!=null||address!=null)&&division==null&&position!=null){
            model.addAttribute("name",name);
            model.addAttribute("address",address);
            model.addAttribute("position",position.getPositionId());
            model.addAttribute("positions",positionService.findAll());
            model.addAttribute("divisions",divisionService.findAll());
            model.addAttribute("list",employeeService.findByThreeFieldP(name, address, position, pageable));
        }else if ((name!=null||address!=null)&&division!=null&&position==null){
            model.addAttribute("name",name);
            model.addAttribute("address",address);
            model.addAttribute("division",division.getDivisionId());
            model.addAttribute("positions",positionService.findAll());
            model.addAttribute("divisions",divisionService.findAll());
            model.addAttribute("list",employeeService.findByThreeFieldD(name, address,division, pageable));
        }else if((name!=null||address!=null)&&division==null&&position==null){
            model.addAttribute("name",name);
            model.addAttribute("address",address);
            model.addAttribute("positions",positionService.findAll());
            model.addAttribute("divisions",divisionService.findAll());
            model.addAttribute("list",employeeService.findByTwoField(name, address, pageable));
        }else {
            model.addAttribute("positions",positionService.findAll());
            model.addAttribute("divisions",divisionService.findAll());
            model.addAttribute("list",employeeService.findAll(pageable1));
        }
        return "/homepage/employee/homePage";
    }
    @GetMapping("/create")
    public String getCreate(Model model){
        model.addAttribute("employee",new Employee());
        model.addAttribute("division",divisionService.findAll());
        model.addAttribute("position",positionService.findAll());
        model.addAttribute("educationDegree",educationDegreeService.findAll());
        return "/homepage/employee/create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("employee") Employee employee,@RequestParam String image, BindingResult bindingResult, Model model){
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("division",divisionService.findAll());
            model.addAttribute("position",positionService.findAll());
            model.addAttribute("educationDegree",educationDegreeService.findAll());
            return "/homepage/employee/create";
        }else {
            List<String> listRole =new ArrayList<>();
            if("Quản lý".equals(employee.getPosition().getPositionName())||"Giám đốc".equals(employee.getPosition().getPositionName())){
                listRole.add("ROLE_ADMIN");
                listRole.add("ROLE_MEMBER");
            }else {
                listRole.add("ROLE_MEMBER");
            }
            User user=new User();
            user.setImageAvatarOfUser(image);
            user.setEmail(employee.getEmployeeEmail());
            user.setPassword(EncrypPasswordUtils.EncrypPasswordUtils("123456"));
            Set<Role> roles=new HashSet<>();
            for (int i = 0; i <listRole.size() ; i++) {
                roles.add(roleService.findByName(listRole.get(i)));
            }
            user.setRoles(roles);
            userService.save(user);
            employee.setUser(user);
            employeeService.save(employee);
            model.addAttribute("employee",new Employee());
            model.addAttribute("division",divisionService.findAll());
            model.addAttribute("position",positionService.findAll());
            model.addAttribute("educationDegree",educationDegreeService.findAll());
            return "/homepage/employee/create";
        }
    }

    @GetMapping("/view/{id}")
    public String detail(@PathVariable Integer id,Model model){
        model.addAttribute("object",employeeService.findById(id).get());
        return "/homepage/employee/view";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        Optional<Employee> customer=employeeService.findById(id);
        if(customer.isPresent()){
            employeeService.delete(customer.get());
            return "redirect:/employee";
        }
        return "redirect:/employee";
    }

    @GetMapping("/update/{id}")
    public String getUpdate(@PathVariable Integer id,Model model){
        model.addAttribute("employee",employeeService.findById(id).get());
        model.addAttribute("division",divisionService.findAll());
        model.addAttribute("position",positionService.findAll());
        model.addAttribute("educationDegree",educationDegreeService.findAll());
        return "/homepage/employee/update";
    }

    @PostMapping ("/update")
    public String update(Model model,
                         @Valid @ModelAttribute("employee") Employee employee,BindingResult bindingResult,
                         @RequestParam String image,
                         RedirectAttributes redirectAttributes){
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("division",divisionService.findAll());
            model.addAttribute("position",positionService.findAll());
            model.addAttribute("educationDegree",educationDegreeService.findAll());
            return "/homepage/employee/update";
        }
        List<String> listRole =new ArrayList<>();
        if("Quản lý".equals(employee.getPosition().getPositionName())||"Giám đốc".equals(employee.getPosition().getPositionName())){
            listRole.add("ROLE_ADMIN");
            listRole.add("ROLE_MEMBER");
        }else {
            listRole.add("ROLE_MEMBER");
        }
        User user=employee.getUser();
        user.setImageAvatarOfUser(image);
        user.setEmail(employee.getEmployeeEmail());
        user.setPassword(EncrypPasswordUtils.EncrypPasswordUtils("123456"));
        Set<Role> roles=new HashSet<>();
        for (int i = 0; i <listRole.size() ; i++) {
            roles.add(roleService.findByName(listRole.get(i)));
        }
        user.setRoles(roles);
        userService.save(user);
        employee.setUser(user);
        employeeService.save(employee);
        return "redirect:/employee";
    }
}
