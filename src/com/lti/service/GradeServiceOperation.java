package com.lti.service;

import java.util.List;

import com.lti.bean.Course;
import com.lti.bean.Student;
import com.lti.dao.GradeDao;
import com.lti.dao.GradeDaoImpl;


public class GradeServiceOperation implements GradeServiceInterface {
	//initializing logger
	

		GradeDao gradeDao= new GradeDaoImpl();

		// display grades for a student against courseId
		public void displayGrades(Student student ){
			System.out.println("***********************************REPORT CARD******************************");	
			System.out.println("COURSE ID      COURSE TITLE                     GRADE");
			List<Course> courses = gradeDao.displayGrades(student);

			courses.forEach(course -> System.out.println(course.getCourseId()+"               "+course.getCourseTitle()+"                       "+course.getGrade()));

			System.out.println("*****************************************************************************");
		}

		// upload grades against a studentId and courseId by professor
		public void uploadGrades(int studentId, int courseId, String grade) {
			gradeDao.uploadGrades(studentId, courseId, grade);

		}
}
