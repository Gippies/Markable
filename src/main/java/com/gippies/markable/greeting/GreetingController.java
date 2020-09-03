package com.gippies.markable.greeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class GreetingController {

    @Autowired
    private GreetingService service;

    @GetMapping("/greetings")
    public String greetings(Model model) {
        List<Greeting> greetingList = service.listAll();
        model.addAttribute("greetingList", greetingList);
        return "greeting_list";
    }

    @GetMapping("/greeting")
    public String greeting(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
        model.addAttribute("greeting", greeting);
        service.save(greeting);
        return "result";
    }
}
