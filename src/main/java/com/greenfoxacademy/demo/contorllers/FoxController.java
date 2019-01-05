package com.greenfoxacademy.demo.contorllers;

import com.greenfoxacademy.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
public class FoxController {

    private final UserService userService;

    @Autowired
    public FoxController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getStartPage(Model model, @RequestParam(required = false) Integer age,
                               @RequestParam(required = false) String name) {
        HashMap<String, Object> params = new HashMap<>();
        StringBuilder errorMessages = new StringBuilder();
        if (age == null) {
            errorMessages.append("please add the age field").append("\n");
        } else if (name == null) {
            errorMessages.append("please add the name field").append("\n");
        } else {
            params.put("user", userService.getUserByName(name));
            model.addAllAttributes(params);
            return "detail";
        }
        params.put("error", errorMessages.toString());
        model.addAllAttributes(params);
        return "error";
    }

    @GetMapping("/user/{username}")
    public String loadUser(Model model, @PathVariable String username) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("user", userService.getUserByName(username));
        model.addAllAttributes(params);
        return "detail";
    }

    @PostMapping("/")
    public String postBodyOnPage(Model model, @RequestBody Object object) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("age", 18);
        params.put("name", "Mark");
        System.out.println(object);
        model.addAllAttributes(params);
        return "index";
    }

}
