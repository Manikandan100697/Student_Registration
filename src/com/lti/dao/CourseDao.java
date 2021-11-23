package com.lti.dao;

import java.util.List;

import com.lti.bean.Course;
import com.lti.bean.Student;
import com.lti.exception.CourseNotFoundException;



public interface CourseDao {
	public List<Course> displayCourses(Student student);
	public void insertCourse(Course course) ;
	public void deleteCourse(int courseId) throws CourseNotFoundException;
	public List<Course> displayCoursesProfessor();

}
