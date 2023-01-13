package com.eminence.chitty.jwt.controller;

import com.eminence.chitty.jwt.dto.ChittyPost;
import com.eminence.chitty.jwt.entity.Chitty;
import com.eminence.chitty.jwt.service.ChittyService;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/chitty")

public class ChitPostController {

    @Autowired
    private ChittyService chittyService;

    @PostMapping("/add")
    public ChittyPost addChitty(@RequestBody ChittyPost request){
        return chittyService.addChitty(request);
    }


    @GetMapping("/get/{chitNumber}")
    Optional<Chitty> getChitty(@PathVariable String chitNumber){
        return chittyService.findById(chitNumber);
    }

    @PutMapping(value = "/update",produces = "Application/JSON")
    public ChittyPost updateChitty(@RequestBody ChittyPost request){
        return chittyService.updateChitty(request);
    }

}
