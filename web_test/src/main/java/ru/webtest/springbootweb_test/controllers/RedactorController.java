package ru.webtest.springbootweb_test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.webtest.springbootweb_test.entitys.Test;
import ru.webtest.springbootweb_test.repositories.TestsRepository;

@Controller
public class RedactorController {

    @Autowired
    private TestsRepository testsRepository;

    @GetMapping("/newtest")
    public String getNewTestPage(Model model){
        Test test = new Test();
        model.addAttribute("test", test);
        return "newtest";
    }

    @PostMapping("/newtest")
    public String create (Test test){
        testsRepository.save(test);
    return testsRepository.toString();
    }
}
