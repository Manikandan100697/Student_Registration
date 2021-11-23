package com.lti.dao;

import java.util.List;

import com.lti.bean.Course;
import com.lti.bean.Student;

/** 
 * @desc this interface is implemented by GradeDaoImplementaion class
 *  @author Manikandan 
 */
public interface GradeDao {
	public List<Course> displayGrades(Student student);
	public void uploadGrades(int studentId, int courseId, String grade);
}
