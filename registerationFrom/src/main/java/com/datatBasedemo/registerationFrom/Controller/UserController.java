package com.datatBasedemo.registerationFrom.Controller;

import com.datatBasedemo.registerationFrom.Model.UserRegister;
import com.datatBasedemo.registerationFrom.Service.UserSrvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserSrvice userSrvice;
    @GetMapping("home-page")
    public  String home(){
        return "home";
    }
    @GetMapping("register")// create the register view
    public String register(Model model){
        model.addAttribute("user",new UserRegister());
        return "registerUser";
    }
    @PostMapping("/create-user")//in this method user can register
    public String submitForm(@ModelAttribute UserRegister user , RedirectAttributes redirectAttributes){
        userSrvice.registerUser(user);//adding the data to the database
        redirectAttributes.addFlashAttribute("message","user Added successfully");
        return "redirect:register";
    }
    @GetMapping("deleteUser")
    public String deleteUser(){
        return "deleteUser";
    }
    @GetMapping("/search")
    public  String searchUser(@RequestParam(name="search",required = false) Long searchTerm,Model model ){
        List<UserRegister> userlist= userSrvice.getUser(searchTerm);
        if (userlist.isEmpty()){
           model.addAttribute("Empty","the user id is not found ");
            System.out.println("user not found");
        }else {
            model.addAttribute("userList", userlist);
        }
        model.addAttribute("searchTerm",searchTerm);
        return "deleteUser";
    }
    @PostMapping("/delete")
    public String deleteUser(@RequestParam("userId") Long userId ,RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("successMessage","user Deleted successfully");
        userSrvice.deleteAccound(userId);
        return "redirect:deleteUser";
    }
    @GetMapping("listOfUsers")
    public String getAllUsers( Model model){
        List<UserRegister>allUsers=userSrvice.getAllUsers();
        model.addAttribute("allUserList",allUsers);
        return "listOfUsers";
    }
}
