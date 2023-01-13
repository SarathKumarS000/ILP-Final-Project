package com.eminence.chitty.jwt.dto;

import lombok.Data;

@Data
public class AuctionPost {
    private Long Id;
    private String chittyId;
    private Long userId;
    private Long currentBid;
}
