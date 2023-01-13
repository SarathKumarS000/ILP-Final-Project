package com.eminence.chitty.jwt.dao;

//import com.youtube.jwt.entity.Role;
import com.eminence.chitty.jwt.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends JpaRepository<Role, Long> {

}
