package com.lti.service;

import com.lti.bean.Admin;
import com.lti.bean.Professor;
import com.lti.bean.Student;
import com.lti.bean.User;
import com.lti.exception.InvalidLoginException;
import com.lti.exception.UserNotFoundException;

public interface UserServiceInterface {

	public User validateUser(String username, String password) throws InvalidLoginException;

	public Student fetchStudent(int studentId);

	public Professor fetchProfessor(int professorId);
	public Admin fetchAdmin(int adminId);
	 public void createUser(User user);
	 public void createStudent(Student student) ;
	 public void createProfessor(Professor professor);
	 public void createAdmin(Admin admin);
	 public void updateUser(int userId,User user);
	  public void updateStudent(int sudentId,Student student);
	  public void updateProfessor(int professsorId,Professor professor) ;
	  public void updateAdmin(int adminId,Admin admin) ;
	  public void deleteUser(int userId,String query) throws UserNotFoundException;
	 public void displayStudents();
	 public void displayProfessors();
	 public void displayAdmins() ;

}
