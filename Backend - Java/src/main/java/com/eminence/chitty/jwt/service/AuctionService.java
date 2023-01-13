package com.eminence.chitty.jwt.service;

import com.eminence.chitty.jwt.dto.AuctionPost;


public interface AuctionService {

    AuctionPost add(AuctionPost request);

    AuctionPost update(AuctionPost request);
}
