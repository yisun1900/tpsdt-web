package com.sh.tpsdt.controller;

import com.sh.tpsdt.service.ValidateCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/tpsdt")
public class TpsdtController {

    @Autowired
    private ValidateCommandService validateCommandService;

    @GetMapping("/index")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @PostMapping("/algorithm")
    public List<String> getTpsdtResult(@RequestParam String pwd) {
        return validateCommandService.validateCommand(pwd);
    }
}
