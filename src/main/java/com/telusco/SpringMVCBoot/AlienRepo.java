package com.telusco.SpringMVCBoot;

import com.telusco.SpringMVCBoot.model.Alien;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlienRepo extends JpaRepository<Alien, Integer> {

    List<Alien> findByAnameOrderByAidDesc(String aname); // Query DSL
}
