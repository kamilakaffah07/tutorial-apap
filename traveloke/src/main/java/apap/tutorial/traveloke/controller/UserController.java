package apap.tutorial.traveloke.controller;

import apap.tutorial.traveloke.model.UserModel;
import apap.tutorial.traveloke.repository.UserDb;
import apap.tutorial.traveloke.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserDb userDb;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUserSubmit(@ModelAttribute UserModel user, Model model){
        userService.addUser(user);
        model.addAttribute("user", user);
        return "redirect:/";
    }

    @GetMapping("/changePassword")
    public String changePasswordFormPage(Model model){
        return "form-update-password";
    }

    @PostMapping("/changePassword")
    public String passwordSubmit(
            @RequestParam(value = "oldPassword") String oldPassword,
            @RequestParam(value = "newPassword") String newPassword,
            @RequestParam(value = "confirmPassword") String confirmPassword,
            Model model){

        UserModel user = userService.getUserByUsername(userService.stringUsername());

        boolean oldPasswordMatch = userService.passwordMatch(oldPassword, user);

        boolean confimedPassword = false;
        if (newPassword.equals(confirmPassword)){
            confimedPassword = true;
        }
        System.out.println(confimedPassword);
        boolean size = false;
        if(newPassword.length()>7){
            size = true;
        }

        if (oldPasswordMatch==true&&confimedPassword==true&&size==true){

            user.setPassword(newPassword);
            userService.addUser(user);
            boolean success = true;
            model.addAttribute("success",success);
            return "update-password";
        }else {
            boolean success = false;
            model.addAttribute("success",success);
            return "update-password";
        }
    }

}
