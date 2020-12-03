package apap.tutorial.traveloke.controller;

import apap.tutorial.traveloke.security.UserDetailsServiceImpl;
import apap.tutorial.traveloke.service.RoleService;
import apap.tutorial.traveloke.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class PageController {

    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String home(Model model){

        String role = userService.authRole();
        model.addAttribute("role",role);
        model.addAttribute("listRole", roleService.findAll());
        return "home";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
