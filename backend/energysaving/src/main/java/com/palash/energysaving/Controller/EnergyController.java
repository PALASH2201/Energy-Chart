package com.palash.energysaving.Controller;

import com.palash.energysaving.Entity.Energy;
import com.palash.energysaving.Service.EnergyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/energy")
@CrossOrigin("*")
public class EnergyController {
    @Autowired
    private EnergyService energyService;

    @GetMapping
    public ResponseEntity<List<Energy>> getAllEntries(){
        try{
            List<Energy> list = energyService.getAllData();
            if(list.isEmpty()){
                throw new RuntimeException("No Entries Found");
            }else{
                return new ResponseEntity<>(list,HttpStatus.OK);
            }
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
