package com.jcompany.task_management_system.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcompany.task_management_system.dtos.TaskDTO;
import com.jcompany.task_management_system.entities.Task;
import com.jcompany.task_management_system.entities.Usuario;
import com.jcompany.task_management_system.repositories.TaskRepository;
import com.jcompany.task_management_system.repositories.UsuarioRepository;

import jakarta.validation.Valid;

@Service
public class TaskService {

	private TaskRepository taskRepository;
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	public void setTaskRepository(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	
	@Autowired
	public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	public void add(@Valid TaskDTO taskDTO) {
		Long idUsuario = taskDTO.getIdUsuario();
		String description = taskDTO.getDescription();
		
		Optional<Usuario> usuarioOpt = usuarioRepository.findById(idUsuario);
		Usuario usuario = usuarioOpt.get();
		
		Task newTask = new Task();
		newTask.setDateCreated(new Date());
		newTask.setDateDone(null);
		newTask.setDescription(description);
		newTask.setUsuario(usuario);
		
		taskRepository.save(newTask);		
	}
	
	public List<Task> findAll() {
		return taskRepository.findAll();
	}

	public List<Task> getTasksByUser(Long idUsuario) {
		Optional<Usuario> usuarioOpt = usuarioRepository.findById(idUsuario);
		Usuario usuario = usuarioOpt.get();
		
		return taskRepository.findByUsuario(usuario);
	}
	
	public void markAsDone(Long id) {
		Optional<Task> taskOpt = taskRepository.findById(id);
		Task task = taskOpt.get();
		task.markDone();
		
		taskRepository.save(task);
	}

	public void uncheckTask(Long id) {
		Optional<Task> taskOpt = taskRepository.findById(id);
		Task task = taskOpt.get();
		task.uncheck();
		
		taskRepository.save(task);
		
	}

	public void deleteTask(Long id) {
		Optional<Task> taskOpt = taskRepository.findById(id);
		Task task = taskOpt.get();
		
		taskRepository.delete(task);
	}
	
	






}
