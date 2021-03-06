package com.lti.dao;

import java.util.List;

import com.lti.bean.Course;
import com.lti.bean.Professor;

/** 
 * @desc this interface is implemented by ProfessorDaoImplementation class
 * @author Manikandan 

 */
public interface ProfessorDao {

	public void selectCourse(int courseId ,Professor professor);
	public void deselectCourse(int courseId, Professor professor);
	public List<Course> displaySelectedCoursesProfessor(Professor professor);
}
