package com.example.demo.Services;

import java.util.List;

import com.example.demo.entity.Employes;
import com.example.demo.entity.Groupe;
import com.example.demo.entity.UserRole;

public interface EmployesService {
	Employes saveEmployes(Employes emp);
	List<Employes> getAllEmployes();
	void deleteEmployeé(Employes e);
	void deleteemptById(Long id);
	Employes getEmp(Long id);
	UserRole saveuserrole(UserRole userrole);
	//void delterolebyuserid(Employes  id);



}
