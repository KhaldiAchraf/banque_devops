package com.example.demo.entity;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.rest.core.annotation.RestResource;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="codeEmploye")
@Entity
@RequiredArgsConstructor

public class Employes {
	@Id

	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@NonNull
	private Long codeEmploye;
	@NonNull
	private String nomEmploye;

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="Code_emp_sup")
	
	 private Employes EmployesSup;
	
	@Column(name = "Enabled", length = 1, nullable = false)
    private boolean enabled;
	
	   @Column(name = "Encryted_Password", length = 128, nullable = false)
	    private String encrytedPassword;
	

	@RestResource(exported = true)
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name="Emp_Gr", joinColumns=@JoinColumn(name="Num_EMP"), inverseJoinColumns=
	@JoinColumn (name="Num_Groupe"))
    
	private Collection<Groupe> groupes;


	@Override
	public String toString() {
		return "Employes [codeEmploye=" + codeEmploye + ", nomEmploye=" + nomEmploye + ",  enabled=" + enabled + ", encrytedPassword=" + encrytedPassword + "]";
	}
	

	
}
