package com.example.demo.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.AppRole;
import com.example.demo.entity.Client;
import com.example.demo.entity.Employes;
import com.example.demo.entity.Operation;
import com.example.demo.entity.UserRole;

@RepositoryRestResource(collectionResourceRel = "UserRole", path="UserRole")

public interface UserRoleRepository extends JpaRepository<UserRole ,Long> {

	

	  /*@Query("delete from UserRole l where l.employe.codeEmploye=: 12")
	  void  deltebyuserid(@Param("x") Employes x);*/
}
