package com.first.first.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.first.first.entities.Courses;
@Service
public class courseService implements courseServices{
	List<Courses> list;
	public courseService(){
		list=new ArrayList<>();
		list.add(new Courses(110,"Theory OF EveryThing","Mazidaar Book hai"));
		list.add(new Courses(111,"Think and Grow Rich","Ameer Banne ke liye padhe"));
		
		
	}
	@Override
	public List<Courses> getCourses() {
		
		return list;
	}
	
	public Courses getCourse(long CourseID) {
		Courses c = null;
		for(Courses  x:list) {
			if(x.getId()==CourseID) {
				c=x;
				break;
			}
			
		}
		return c;
		
	}
	@Override
	public Courses addCourse(Courses course) {
		list.add(course);		
		return course;
	}
	@Override
	public Courses updateCourse(Courses course) {
		list.forEach(e ->{
			if(e.getId()==course.getId()) {
				e.setTitle(course.getTitle());
				e.setDiscription(course.getDiscription());
				
			}
		});
		// TODO Auto-generated method stub
		return course;
	}
	@Override
	public void deleteCourse(long course) {
		list=this.list.stream().filter(e->e.getId()!=course).collect(Collectors.toList());
		// TODO Auto-generated method stub
		
	}
	

}
