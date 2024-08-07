package com.jcompany.task_management_system.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jcompany.task_management_system.dtos.TaskDTO;
import com.jcompany.task_management_system.entities.Task;
import com.jcompany.task_management_system.services.TaskService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@CrossOrigin
@Transactional
@RestController
@RequestMapping("/task")
public class TaskController {

	TaskService taskService;
	
	@CrossOrigin
	@PostMapping("/add")
	public void add(@Valid @RequestBody TaskDTO taskDTO)  {
		taskService.add(taskDTO);
	}	
	
	@CrossOrigin
	@GetMapping("/all")
	public List<Task> getAll()  {
		return taskService.findAll();
	}
	
    @CrossOrigin
    @GetMapping("/byuser")
    public List<Task> getTasksByUserId(@RequestParam Long idUsuario) {
        return taskService.getTasksByUser(idUsuario);
    }
    
    @CrossOrigin
    @PutMapping("/{id}/done")
    public void markAsDone(@PathVariable Long id) {
        taskService.markAsDone(id);
    }

    @CrossOrigin
    @PutMapping("/{id}/uncheck")
    public void uncheckTask(@PathVariable Long id) {
        taskService.uncheckTask(id);
    }
    
    @CrossOrigin
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

	
	@Autowired
	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}
	
}
