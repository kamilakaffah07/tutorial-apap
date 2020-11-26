package apap.tutorial.traveloke.controller;

import apap.tutorial.traveloke.model.UserModel;
import apap.tutorial.traveloke.repository.UserDb;
import apap.tutorial.traveloke.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.ArrayUtils;

import java.util.ArrayList;

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

        boolean composition = false;
        boolean huruf = false;
        boolean angka = false;
        String[] listAngka = {"1","2","3","4","5","6","7","8","9","0"};
        String[] listHuruf = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x",
                "y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};


        for (int i = 0; i<newPassword.length();i++){
            if (ArrayUtils.contains(listAngka,newPassword.substring(i,i+1))){
                angka = true;
                break;
            }
        }

        for (int i = 0; i<newPassword.length();i++){
            if (ArrayUtils.contains(listHuruf,newPassword.substring(i,i+1))){
                huruf = true;
                break;
            }
        }

        System.out.println(newPassword.substring(0,1));
        System.out.println(newPassword.substring(1,2));
        System.out.println(newPassword.substring(2,3));

        if(angka==true&&huruf==true){
            composition=true;
        }

        if (oldPasswordMatch==true&&confimedPassword==true&&size==true&&composition==true){

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
