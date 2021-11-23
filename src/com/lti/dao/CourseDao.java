package com.lti.dao;

import java.util.List;

import com.lti.bean.Course;
import com.lti.bean.Student;
import com.lti.exception.CourseNotFoundException;

/** 
 * @desc this interface is implemented by courseDaoImplementation class
 * @author Manikandan 
 */

public interface CourseDao {
	public List<Course> displayCourses(Student student);
	public void insertCourse(Course course) ;
	public void deleteCourse(int courseId) throws CourseNotFoundException;
	public List<Course> displayCoursesProfessor();

}
