package com.jcompany.task_management_system.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
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

import com.jcompany.task_management_system.controllers.assemblers.TaskModelAssembler;
import com.jcompany.task_management_system.dtos.TaskDTO;
import com.jcompany.task_management_system.entities.Task;
import com.jcompany.task_management_system.services.TaskService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@CrossOrigin
@Transactional
@RestController
@RequestMapping("/tasks")
public class TaskController {

	TaskService taskService;
	TaskModelAssembler taskModelAssembler;

	@CrossOrigin
	@PostMapping("/add")
	public ResponseEntity<EntityModel<Task>> add(@Valid @RequestBody TaskDTO taskDTO) {
		Task createdTask = taskService.add(taskDTO);
		EntityModel<Task> taskModel = taskModelAssembler.toModel(createdTask);

		return ResponseEntity
				.created(linkTo(methodOn(TaskController.class).getTasksByUserId(createdTask.getIdTask())).toUri())
				.body(taskModel);
	}

	@CrossOrigin
	@GetMapping("/all")
	public ResponseEntity<CollectionModel<Task>> getAll() {
		List<Task> tasks = taskService.findAll();
		CollectionModel<Task> taskCollection = taskModelAssembler.toCollectionModel(tasks);
		return new ResponseEntity<>(taskCollection, HttpStatus.OK);
	}

	@CrossOrigin
	@GetMapping()
	public ResponseEntity<CollectionModel<Task>> getTasksByUserId(@RequestParam Long idUsuario) {
		List<Task> tasks = taskService.getTasksByUser(idUsuario);
		CollectionModel<Task> taskCollection = taskModelAssembler.toCollectionModel(tasks);
		return new ResponseEntity<>(taskCollection, HttpStatus.OK);
	}

	@CrossOrigin
	@PutMapping("/{id}/done")
	public ResponseEntity<EntityModel<Task>> markAsDone(@PathVariable Long id) {
		Task updatedTask = taskService.markAsDone(id);
		return ResponseEntity.ok(taskModelAssembler.toModel(updatedTask));
	}

	@CrossOrigin
	@PutMapping("/{id}/uncheck")
	public ResponseEntity<EntityModel<Task>> uncheckTask(@PathVariable Long id) {
		Task updatedTask = taskService.uncheckTask(id);
		return ResponseEntity.ok(taskModelAssembler.toModel(updatedTask));
	}

	@CrossOrigin
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
		taskService.deleteTask(id);
		return ResponseEntity.noContent().location(linkTo(methodOn(TaskController.class).getAll()).toUri()).build();
	}

	@CrossOrigin
	@PutMapping("/done/all")
	public ResponseEntity<CollectionModel<Task>> markAllAsDone() {
		taskService.markAllAsDone();
		List<Task> tasks = taskService.findAll();
		CollectionModel<Task> taskCollection = taskModelAssembler.toCollectionModel(tasks);
		return ResponseEntity.ok(taskCollection);
	}

	@CrossOrigin
	@PutMapping("/uncheck/all")
	public ResponseEntity<CollectionModel<Task>> uncheckAllTasks() {
		taskService.uncheckAllTasks();
		List<Task> tasks = taskService.findAll();
		CollectionModel<Task> taskCollection = taskModelAssembler.toCollectionModel(tasks);
		return ResponseEntity.ok(taskCollection);
	}

	@Autowired
	public void setTaskModelAssembler(TaskModelAssembler taskModelAssembler) {
		this.taskModelAssembler = taskModelAssembler;
	}

	@Autowired
	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}
}
