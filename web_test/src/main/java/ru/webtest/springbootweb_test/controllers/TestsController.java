package ru.webtest.springbootweb_test.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.webtest.springbootweb_test.entitys.Test;
import ru.webtest.springbootweb_test.repositories.TestsRepository;

import java.util.List;

@Controller
public class TestsController {

    @Autowired
    private TestsRepository testsRepository;
    @GetMapping("/tests")
    public String getTestsPage(Model model){
        List<Test> tests =testsRepository.findAll();
        model.addAttribute("tests",tests);
        return "tests_page";

    }
}
