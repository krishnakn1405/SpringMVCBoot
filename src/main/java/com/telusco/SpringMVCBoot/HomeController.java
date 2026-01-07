package com.telusco.SpringMVCBoot;

import com.telusco.SpringMVCBoot.model.Alien;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

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

        List<Alien> aliens = Arrays.asList(new Alien(101, "Navin"), new Alien(101, "Rose"));
        m.addAttribute("result", aliens);

        return "showAliens";
    }

    @PostMapping(value="addAlien")
    public String addAlien(@ModelAttribute Alien a) {
        return "result";
    }
}
