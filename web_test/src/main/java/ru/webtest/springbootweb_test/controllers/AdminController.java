package ru.webtest.springbootweb_test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.webtest.springbootweb_test.entitys.User;
import ru.webtest.springbootweb_test.security.details.UserDetailsServiceImpl;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/adminka")
public class AdminController {
    public String login;
    @Autowired
    private UserDetailsServiceImpl usersService;

    @Secured("ROLE_ADMIN")
    @GetMapping("/statistic")
    public String getStatictic(Model model) {
        //получаем имя текущего пользователя
        login = usersService.getCurrentUsername();
        model.addAttribute("name", login);
        return "statistic";
    }

    @GetMapping("/change_password/{iduser}")
    public String changePassword(@PathVariable("iduser") long iduser, Model model) {
        System.out.println("change_password");
        String fio = usersService.getUserName(iduser);
        model.addAttribute("name", login);
        model.addAttribute("iduser", iduser);
        model.addAttribute("fio", fio);
        return "changepassword";
    }

    @PostMapping("/savepassword/{iduser}")
    public String savePassword(@PathVariable("iduser") long iduser, String password) {
        System.out.println("savepassword");
        System.out.println(password);
        boolean changePass = usersService.savePasswordBD(password, iduser);
        if (!changePass) {
            System.out.println("пароль не изменен");
            return "/savepassword/{iduser}";
        }
        System.out.println("Пользователь добавлен");
        return "redirect:/users";


    }


    @GetMapping("/edit_user/{iduser}")
    public String changeuser(@PathVariable("iduser") long iduser, Model model) {
        System.out.println("change_user");
        User user = usersService.getUser(iduser);
        model.addAttribute("iduser", iduser);
        model.addAttribute("name", login);
        model.addAttribute("nameuser",user.getName());
        model.addAttribute("login",user.getLogin());
        model.addAttribute("fio", user.getName());
        model.addAttribute("hashpassword", user.getHashPassword());

       /* List<String> roles =new ArrayList<>();
        roles.add("ROLE_ADMIN");
        roles.add("ROLE_EDITOR");
        roles.add("ROLE_USER");
        model.addAttribute("roles",roles);*/
        model.addAttribute(user);
        return "redactoruser";
    }

    @PostMapping("/updateuser/{iduser}")
    public String saveuser(@ModelAttribute("userch") User user, BindingResult theBindingResult,@PathVariable("iduser") long iduser) {
        System.out.println("savereduser");
        System.out.println(user.getName());
        System.out.println("hashpassword1 "+user.getHashPassword());

        if (theBindingResult.hasErrors()) {
            return "redactoruser/{iduser}";
        }
        boolean changeUser=usersService.saveUserBD(user);
        if (!changeUser) {
            System.out.println("Данные не обновлены");
            return "redactoruser/{iduser}";
        }
        System.out.println("Данные обновлены");
        return "redirect:/users";


    }
    @PostMapping("/delete_user/{iduser}")
    public String deleteUser(@PathVariable("iduser") long iduser){
        usersService.deleteUser(iduser);
        return "redirect:/users";
    }

}