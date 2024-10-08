package com.jcompany.task_management_system.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long idUsuario;
	
	private String username;
	
}
