package com.rt.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rt.DTO.ResponseLoginDTO;
import com.rt.entity.User;
@Repository
public interface LoginRepository extends JpaRepository<User, Integer> {
	
	 @Query("SELECT u.id AS id, u.fullname AS fullname, u.email AS email, u.role AS role FROM User u WHERE u.email = :email AND u.password = :password")
	    Optional<ResponseLoginDTO> loginUser(@Param("email") String email, @Param("password") String password);
	  
}
