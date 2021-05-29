package com.example.sqlitedemo.controller;

import com.example.sqlitedemo.entity.Equipment;
import com.example.sqlitedemo.entity.Message;
import com.example.sqlitedemo.entity.Well;
import com.example.sqlitedemo.repository.EquipmentRepository;
import com.example.sqlitedemo.repository.WellRepository;
import com.example.sqlitedemo.service.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Controller
public class WellController {
    @Autowired
    private final WellRepository wellRepository;
    @Autowired
    private final EquipmentRepository equipmentRepository;
    public WellController(WellRepository wellRepository, EquipmentRepository equipmentRepository) {
        this.wellRepository = wellRepository;
        this.equipmentRepository = equipmentRepository;
    }

    @GetMapping("/wells")
    public  String  getWells(Model model) {
        model.addAttribute("list", new String());
            model.addAttribute("wells", wellRepository.findAll());
        return "index";
    }
    @GetMapping("/wells/create")
    public  String  getWellCreate(@ModelAttribute Message message , Model model) {
        return "form";
    }

    @RequestMapping("/")
    public String getPage() {
        return "redirect:/wells";
    }

    @RequestMapping(value="/wells", method= RequestMethod.POST)
    public String saveWell(@ModelAttribute Message message , Model model) {
        Optional<Well> opt = Optional.ofNullable(wellRepository.getWellByWellname(message.getName()));
        Well well;
        if(opt.isPresent()){
           well = opt.get();
        }else{
            well = new Well();
            well.setName(message.getName());
        }
        for(int i = 0 ;i<message.getNumber();i++){
            Equipment eq = new Equipment();
            eq.setName(RandomStringGenerator.generateString());
            equipmentRepository.save(eq);
            well.getEquipments().add(eq);
        }
        wellRepository.save(well);
        return "redirect:/wells";
    }
}
