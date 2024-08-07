package com.jcompany.task_management_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jcompany.task_management_system.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>  {

}


