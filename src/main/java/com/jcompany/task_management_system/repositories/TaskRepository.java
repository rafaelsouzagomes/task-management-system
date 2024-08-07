package com.jcompany.task_management_system.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jcompany.task_management_system.entities.Task;
import com.jcompany.task_management_system.entities.Usuario;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>  {

	List<Task> findByUsuario(Usuario usuario);

}
