package com.example.demo.Services;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AppRoleDAO;
import com.example.demo.dao.AppUserDAO;
import com.example.demo.entity.Employes;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AppUserDAO appUserDAO;

    @Autowired
    private AppRoleDAO appRoleDAO;

    @Override
    public UserDetails loadUserByUsername(String nomEmploye) throws UsernameNotFoundException {
    	
    	
        Employes employe = this.appUserDAO.findEmployeAccount(nomEmploye);
Employes emp = new Employes() ;
        if (employe == null) {
            System.out.println("User not found! " +nomEmploye);
            throw new UsernameNotFoundException("User " + nomEmploye + " was not found in the database");
        }

        System.out.println("Found User: " + employe);
        employe.setEmployesSup(null);

        // [ROLE_USER, ROLE_ADMIN,..]
        List<String> roleNames = this.appRoleDAO.getRoleNames(employe.getCodeEmploye());

        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (roleNames != null) {
        	System.out.println(employe.toString());
            for (String role : roleNames) {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                grantList.add(authority);
            }
        }

        UserDetails userDetails = (UserDetails) new User(employe.getNomEmploye(), //
                employe.getEncrytedPassword(), grantList);

        return userDetails;
    }

}