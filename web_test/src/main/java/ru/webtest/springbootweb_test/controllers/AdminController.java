package ru.webtest.springbootweb_test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.webtest.springbootweb_test.entitys.*;
import ru.webtest.springbootweb_test.security.details.UserDetailsServiceImpl;
import org.springframework.validation.BindingResult;
import ru.webtest.springbootweb_test.service.AttemptService;
import ru.webtest.springbootweb_test.service.TestService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/adminka")
public class AdminController {
    public String login;
    @Autowired
    private UserDetailsServiceImpl usersService;
    @Autowired
    private AttemptService attemptService;
    @Autowired
    private TestService testService;

    @Secured("ROLE_ADMIN")
    @GetMapping("/statistic")
    public String getStatictic(Model model) {
        //получаем имя текущего пользователя
        login = usersService.getCurrentUsername();
        model.addAttribute("name", login);
        List<AttemptView> attemptViews=attemptService.getAttemptAll();
        model.addAttribute("attempts", attemptViews);


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
        model.addAttribute("nameuser", user.getName());
        model.addAttribute("login", user.getLogin());
        model.addAttribute("fio", user.getName());
        model.addAttribute("hashpassword", user.getHashPassword());
        model.addAttribute(user);
        return "redactoruser";
    }

    @PostMapping("/updateuser/{iduser}")
    public String saveuser(@ModelAttribute("userch") User user, BindingResult theBindingResult, @PathVariable("iduser") long iduser, String namerole, String hashpassword) {
        System.out.println("savereduser");
        System.out.println(user.getName());
        //System.out.println("hashpassword1 " + hashpassword);
        //System.out.println("namerole " + namerole);

        if (theBindingResult.hasErrors()) {
            return "redactoruser/{iduser}";
        }
        boolean changeUser = usersService.saveUserBD(user, namerole, hashpassword);
        if (!changeUser) {
            System.out.println("Данные не обновлены");
            return "redactoruser/{iduser}";
        }
        System.out.println("Данные обновлены");
        return "redirect:/users";


    }

    @PostMapping("/delete_user/{iduser}")
    public String deleteUser(@PathVariable("iduser") long iduser) {

        usersService.deleteUser(iduser);
        List<PrescTests> prescTests=testService.findPrescTestAll(iduser);
        for (PrescTests ps:prescTests) {
            testService.deletePrescTests(ps);
        }
        List<PassedTests> passedTests=testService.findPassedTestAll(iduser);
        for (PassedTests p:passedTests) {
            testService.deletePassedTests(p);
        }

        List<Attempt> attempt=attemptService.getAttemptByIdUser(iduser);
        for (Attempt a: attempt) {
            attemptService.deleteAttemptByIdUser(a);
        }

        return "redirect:/users";
    }

}
