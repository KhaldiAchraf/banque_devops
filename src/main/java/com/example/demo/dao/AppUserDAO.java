package com.example.demo.dao;


import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Employes;

@Repository
@Transactional
public class AppUserDAO {

    @Autowired
    private EntityManager entityManager;

    private Employes E ;
   
    	    public Employes findEmployeAccount(String nomEmploye) {
    	        try {
    	            String sql = "Select e from " + Employes.class.getSimpleName()+ " e " //
    	                    + " Where e.nomEmploye = :nomEmploye  ";

    	            Query query = entityManager.createQuery(sql, Employes.class);
    	            query.setParameter("nomEmploye", nomEmploye);
E = (Employes) query.getSingleResult();
//E.setEmployesSup(null);
System.out.println("111111111111111111111111111111111111111111111111111111111111111111111111111111");
    	            return E;
    	        } catch (NoResultException e) {
    	            return null;
    	        }
    	    }
    	  
    	

}