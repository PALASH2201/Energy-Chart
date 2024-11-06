package com.palash.energysaving.Service;

import com.palash.energysaving.Entity.Energy;
import com.palash.energysaving.Repository.EnergyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnergyService {
    @Autowired
    private EnergyRepository energyRepository;

    public List<Energy> getAllData(){
        return energyRepository.findAll();
    }
}
