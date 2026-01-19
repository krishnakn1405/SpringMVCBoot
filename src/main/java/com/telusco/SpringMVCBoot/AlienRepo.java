package com.telusco.SpringMVCBoot;

import com.telusco.SpringMVCBoot.model.Alien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlienRepo extends JpaRepository<Alien, Integer> {

}
