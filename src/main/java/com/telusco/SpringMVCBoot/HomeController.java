package com.telusco.SpringMVCBoot;

import com.telusco.SpringMVCBoot.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    AlienRepo repo;

    @ModelAttribute
    public void modelData(Model m) {
        m.addAttribute("name", "Aliens");
    }

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("getAliens")
    public String getAliens(Model m) {

        m.addAttribute("result", repo.findAll());

        return "showAliens";
    }

    @GetMapping("getAlien")
    public String getAlien(@RequestParam int aid, Model m) {

        m.addAttribute("result", repo.getOne(aid));

        return "showAliens";
    }

    @PostMapping(value="addAlien")
    public String addAlien(@ModelAttribute Alien a) {
        return "result";
    }
}
