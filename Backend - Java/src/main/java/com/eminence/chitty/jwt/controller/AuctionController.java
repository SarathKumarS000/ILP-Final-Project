package com.eminence.chitty.jwt.controller;

import com.eminence.chitty.jwt.dto.AuctionPost;
import com.eminence.chitty.jwt.service.AuctionService;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/auction")
public class AuctionController {

    @Autowired
    private AuctionService auctionService;

    @PostMapping("/add")
    public AuctionPost add(@RequestBody AuctionPost request){
        return auctionService.add(request);
    }

    @PutMapping(value = "/update",produces = "Application/JSON")
    public AuctionPost update(@RequestBody AuctionPost request){
        return auctionService.update(request);
    }



}
