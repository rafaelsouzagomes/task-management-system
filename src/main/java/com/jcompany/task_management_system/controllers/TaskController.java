package com.jcompany.task_management_system.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jcompany.task_management_system.dtos.TaskDTO;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@CrossOrigin
@Transactional
@RestController
@RequestMapping("/task")
public class TaskController {

	@CrossOrigin
	@PostMapping("/add")
	public void add(@Valid @RequestBody TaskDTO taskDTO)  {
		
	}
	
}
