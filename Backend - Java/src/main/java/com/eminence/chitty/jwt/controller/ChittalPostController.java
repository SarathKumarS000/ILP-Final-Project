package com.eminence.chitty.jwt.controller;

import com.eminence.chitty.jwt.dto.ChittalPost;
import com.eminence.chitty.jwt.dto.ChittalPostResponse;
import com.eminence.chitty.jwt.service.ChittalService;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/chittal")

public class ChittalPostController {

    @Autowired
    private ChittalService chittalService;

    @PostMapping("/add")
    public ChittalPostResponse addChittal(@RequestBody ChittalPost request){
        return chittalService.addChittal(request);
    }




}
