package ru.webtest.springbootweb_test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.webtest.springbootweb_test.repositories.entitys.Test;
import ru.webtest.springbootweb_test.repositories.TestsRepository;

import java.util.List;

@Controller
public class PassTestsController {

    @Autowired
    private TestsRepository testsRepository;
    @GetMapping("/lich_page_pass")
    public String getPassedTestsPage(Model model){
        List<Test> tests1 =testsRepository.findAll();
        model.addAttribute("tests1",tests1);
        return "tests_pass";

    }
}
