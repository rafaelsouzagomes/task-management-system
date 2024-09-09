package com.jcompany.task_management_system.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;

@CrossOrigin
@Transactional
@RestController
@RequestMapping("/users")
public class UserController {

	@GetMapping("/all")
	@Cacheable("users")
	public List<Object> getAll() {
		return new ArrayList();
	}
}
