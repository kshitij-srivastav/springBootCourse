package com.first.first.services;
import java.util.*;

import com.first.first.entities.Courses;
public interface courseServices {
	public List<Courses> getCourses();
	public Courses getCourse(long courseID);
	public Courses addCourse(Courses course);
	public Courses updateCourse(Courses course);
	public void  deleteCourse(long course);
}
