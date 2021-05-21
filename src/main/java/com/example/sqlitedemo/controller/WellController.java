package com.example.sqlitedemo.controller;

import com.example.sqlitedemo.repository.WellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WellController {
    @Autowired
    private final WellRepository wellRepository;

    public WellController(WellRepository wellRepository) {
        this.wellRepository = wellRepository;
    }
    @GetMapping("/wells")
    public  String  getWells(Model model) {


        model.addAttribute("wells", wellRepository.findAll());

        return "index";
    }
    @RequestMapping("/")
    public String getPage() {
        return "redirect:/wells";
    }
}
