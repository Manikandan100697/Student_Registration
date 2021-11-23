package com.lti.dao;

import java.util.List;

import com.lti.bean.Course;
import com.lti.bean.Student;


public interface GradeDao {
	public List<Course> displayGrades(Student student);
	public void uploadGrades(int studentId, int courseId, String grade);
}
