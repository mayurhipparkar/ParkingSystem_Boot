package com.rt.guardRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rt.userEntity.Users;
@Repository
public interface GuardRepository extends JpaRepository<Users, Integer>{

	boolean existsByEmailIgnoreCase(String email);

}
