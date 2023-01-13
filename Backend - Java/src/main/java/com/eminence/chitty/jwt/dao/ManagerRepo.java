package com.eminence.chitty.jwt.dao;

import com.eminence.chitty.jwt.entity.Manager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "manager",path = "managers")
@Controller
@ResponseBody
public interface ManagerRepo extends JpaRepository<Manager,Long> {
    @Override
    Optional<Manager> findById(Long aLong);

    Page<Manager> findByfirstNameContaining(@Param("name") String firstName, Pageable pageable);
}
