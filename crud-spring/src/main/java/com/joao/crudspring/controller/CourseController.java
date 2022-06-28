package com.joao.crudspring.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.joao.crudspring.model.Course;
import com.joao.crudspring.repository.CourseRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor //Irá criar todos os construtores
public class CourseController {
	
	private CourseRepository courseRepository;
	

	public CourseController(CourseRepository courseRepository) {
		super();
		this.courseRepository = courseRepository;
	}


	@GetMapping
	public @ResponseBody List<Course>list() {
		return courseRepository.findAll();
	}

}
