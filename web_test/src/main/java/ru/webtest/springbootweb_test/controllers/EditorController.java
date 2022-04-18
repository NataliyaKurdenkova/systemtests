package ru.webtest.springbootweb_test.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EditorController {
    @GetMapping("/editor")
    public String getEditorPage(){
        return "editor";
    }
}
