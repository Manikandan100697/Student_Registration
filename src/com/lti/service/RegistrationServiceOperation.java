package com.lti.service;

import java.util.List;

import com.lti.bean.Student;
import com.lti.dao.RegistrationDao;
import com.lti.dao.RegistrationDaoImpl;


/** 
 * @desc this class will hold functions for Registration service operation
 * examples include submitRegistration (Student student),displayRegisteredStudentsInCourse(int courseId)
 * @author Manikandan 
 */
public class RegistrationServiceOperation implements RegistrationServiceInterface{



		RegistrationDao registrationDao= new RegistrationDaoImpl();

		// checks if student has selected exactly  4 courses or not
		public boolean checkCourseSelectionStatus(Student student) {
			return registrationDao.numberOfCoursesSelected(student);
		}

		// submit registration for student
		public void submitRegistration (Student student) {
			registrationDao.submitRegistration (student);
		}

		// generate student registration details and store them in database
		public void generateRegistrationReciept(Student student, double payableAmount, int payModeId){
			registrationDao.generateRegistrationReciept(student, payableAmount, payModeId);
		}

		// display studentID of students enrolled in a course
		public void displayRegisteredStudentsInCourse(int courseId){
			System.out.println("*********************STUDENTS ENROLLED******************************");	
			System.out.println("STUDENT ID");
			List<Integer> students = registrationDao.displayRegisteredStudentsInCourse(courseId);
			students.forEach(student -> System.out.println(student));

		}
}
