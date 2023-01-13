package com.eminence.chitty.jwt.dao;

import com.eminence.chitty.jwt.entity.Auction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "auction", path = "auction")
public interface AuctionRepo extends JpaRepository<Auction,Long> {
}
