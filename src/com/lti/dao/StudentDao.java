package com.lti.dao;

import java.util.List;

import com.lti.bean.Course;
import com.lti.bean.Student;


public interface StudentDao{
	
	public void addCourse(int courseId ,Student student) ;
	public void dropCourse(int courseId, Student student);
	public List<Course> displaySelectedCourses(Student student);

}
