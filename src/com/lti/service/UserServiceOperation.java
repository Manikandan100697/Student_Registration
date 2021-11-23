package com.lti.service;

import java.util.List;

import com.lti.bean.Admin;
import com.lti.bean.Professor;
import com.lti.bean.Student;
import com.lti.bean.User;
import com.lti.dao.UserDao;
import com.lti.dao.UserDaoImpl;
import com.lti.exception.InvalidLoginException;
import com.lti.exception.UserNotFoundException;

public class UserServiceOperation implements UserServiceInterface {

	// initializing logger

	UserDao userDao = new UserDaoImpl();

	// validating users by checking their credentials
	public User validateUser(String username, String password) throws InvalidLoginException {
		User user = userDao.validateUser(username, password);
		if (user == null)
			throw new InvalidLoginException();
		return user;

	}

	// fetching student details from student databse against studentId
	public Student fetchStudent(int studentId) {
		Student stu= userDao.fetchStudent(studentId);

		return stu;
	}
	

	//fetching professor details from professor databse against professortId
	public Professor fetchProfessor(int professorId){
		return userDao.fetchProfessor(professorId);
	}
	//fetching admin details from admin databse against adminId
	public Admin fetchAdmin(int adminId){
		return userDao.fetchAdmin(adminId);
	}


	//create new user
	public void createUser(User user){
		userDao.createUser(user);
	}

	//create new student
	public void createStudent(Student student) {
		userDao.createStudent(student);
	}

	//create new professor
	public void createProfessor(Professor professor){
		userDao.createProfessor(professor);
	}

	//create new admin
	public void createAdmin(Admin admin){
		userDao.createAdmin(admin);
	}

	// update user against userId
	public void updateUser(int userId,User user){
		userDao.updateUser(userId,user);
	}

	//update student against studentId
	public void updateStudent(int studentId,Student student){
		userDao.updateStudent(studentId,student);
	}

	//update professor against professorId
	public void updateProfessor(int professorId, Professor professor){
		userDao.updateProfessor(professorId,professor);
	}

	//update admin against adminId
	public void updateAdmin(int adminId,Admin admin){
		userDao.updateAdmin(adminId,admin);
	}

	//delete user against userId
	public void deleteUser(int userId, String query) throws UserNotFoundException {
		userDao.deleteUser(userId, query);
	}

	// display details of all students
	public void displayStudents() {
		

		List<Student> students = userDao.displayStudents();

		students.stream().forEach(student -> {
			if(student.getGender().equals("female"))
				student.setName("Ms "+ student.getName() );
			else
				student.setName("Mr "+ student.getName() );
		});
		
		for(Student student: students) {
			System.out.println(student.getStudentId()+"         "+student.getName()+"          "+student.getPhoneNumber()+"        "+student.getBranch()+"        "+student.getSemester()+"                "+student.isRegistrationStatus()+"                      "+student.getScholarshipPercentage());
		}
		
	}

	// display details of all professors
	public void displayProfessors() {
		System.out.println("****************************LIST OF PROFESSORS************************************");

		List<Professor> professors = userDao.displayProfessors();

		professors.stream().forEach(professor -> {
			if(professor.getGender().equals("female"))
				professor.setName("Ms "+ professor.getName() );
			else
				professor.setName("Mr "+ professor.getName() );
		});

		System.out.println("PROFESSOR ID      NAME            PHONE NUMBER      DESIGNATION   ");
		for(Professor professor: professors) {
			System.out.println(professor.getProfessorId()+"         "+professor.getName()+"          "+professor.getPhoneNumber()+"        "+professor.getDesignation());

		}
		System.out.println("*******************************************************************************************");
	}

	// display details of all admins
	public void displayAdmins() {
		System.out.println("**************LIST OF ADMINS****************");

		List<Admin> admins = userDao.displayAdmins();

		admins.stream().forEach(user -> {
			if(user.getGender().equals("female"))
				user.setName("Ms "+ user.getName() );
			else
				user.setName("Mr "+ user.getName() );
		});
		System.out.println("USER ID      NAME           PHONE NUMBER      ");
		for(Admin admin: admins) {
			System.out.println(admin.getAdminId()+"         "+admin.getName()+"          "+admin.getPhoneNumber());

		}
		System.out.println("***********************************************");

	}


}
