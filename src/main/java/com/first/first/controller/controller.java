package com.first.first.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.first.first.entities.Courses;
import com.first.first.services.courseServices;

@RestController
public class controller {
	 @Autowired
	courseServices courseService;
	
	@GetMapping("/home")
	public String home() {
		return "This is home page";
	}
	
	//list all the couses
	@GetMapping("/courses")
	public List<Courses> getCourses(){
		return this.courseService.getCourses();
		
	}
	//Get a particular course
	@GetMapping("/course/{courseID}")
	public Courses getCourse(@PathVariable String courseID) {
		return this.courseService.getCourse(Long.parseLong(courseID));
	}
	
	//add course
	@PostMapping("/course")
	public Courses addCourse(@RequestBody Courses course) {
		return this.courseService.addCourse(course);
		
	}
	
	//update a course using put method
	@PutMapping("/course")
	public Courses updateCoarse(@RequestBody Courses course) {
		return this.courseService.updateCourse(course);
		
		
	}
	
	//Delete a course 
	@DeleteMapping("/course/{courseID}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseID){
		try {
			this.courseService.deleteCourse(Long.parseLong(courseID));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
