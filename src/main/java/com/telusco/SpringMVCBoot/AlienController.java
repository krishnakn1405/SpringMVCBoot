package com.telusco.SpringMVCBoot;

import com.telusco.SpringMVCBoot.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlienController {

    @Autowired
    AlienRepo repo;

    @GetMapping(path="aliens", produces = {"application/xml"})
    public List<Alien> getAliens() {
        List<Alien> aliens = repo.findAll();
        return aliens;
    }

    @GetMapping("alien/{aid}")
    public Alien getAlien(@PathVariable("aid") int aid) {
        Alien alien = repo.findById(aid).orElse(new Alien(0, ""));
        return alien;
    }

    @PostMapping(path = "alien", consumes = {"application/json"})
    public Alien addAlien(@RequestBody Alien alien) {
        repo.save(alien);
        return alien;
    }
}
