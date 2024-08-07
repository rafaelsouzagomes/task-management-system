package com.jcompany.task_management_system.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Void> add(@Valid @RequestBody TaskDTO taskDTO)  {
		taskService.add(taskDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}	
	
	@CrossOrigin
	@GetMapping("/all")
	public ResponseEntity<List<Task>> getAll()  {
		List<Task> tasks = taskService.findAll();
		return new ResponseEntity<>(tasks, HttpStatus.OK);
	}
	
    @CrossOrigin
    @GetMapping("/byuser")
    public ResponseEntity<List<Task>> getTasksByUserId(@RequestParam Long idUsuario) {
         List<Task> tasks = taskService.getTasksByUser(idUsuario);
         return new ResponseEntity<>(tasks, HttpStatus.OK);
    }
    
    @CrossOrigin
    @PutMapping("/{id}/done")
    public ResponseEntity<Void> markAsDone(@PathVariable Long id) {
        taskService.markAsDone(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @CrossOrigin
    @PutMapping("/{id}/uncheck")
    public ResponseEntity<Void> uncheckTask(@PathVariable Long id) {
        taskService.uncheckTask(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	
	@Autowired
	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}
	
}
