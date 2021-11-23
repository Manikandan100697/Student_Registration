package com.lti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lti.bean.Course;
import com.lti.bean.Student;
import com.lti.constant.SQLConstantQueries;
import com.lti.utils.CloseConnection;
import com.lti.utils.DBUtil;



public class StudentDaoImpl implements StudentDao,CloseConnection{

	//Initializing the logger

	// add a course by student
	public void addCourse(int courseId ,Student student)  {

		//Establishing the connection
		Connection connection = DBUtil.getConnection();
		PreparedStatement stmt= null;

		try {
			//Declaring prepared statement and executing query
			stmt = connection.prepareStatement(SQLConstantQueries.ADD_COURSES);

			int studentId= student.getStudentId();

			stmt.setInt(1, studentId);
			stmt.setInt(2, courseId);

			//Executing query
			stmt.executeUpdate();
			System.out.println("Course with courseId= "+"'"+courseId+"' has been added to Student= "+ "'"+student.getName()+"'");

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		

	}

	// drop a course by student against a courseID
	public void dropCourse(int courseId, Student student) {

		//Establishing the connection
		Connection connection = DBUtil.getConnection();
		PreparedStatement stmt= null;
		try {

			//Establishing the connection
			stmt=connection.prepareStatement(SQLConstantQueries.DROP_COURSE);
			int studentId= student.getStudentId();

			stmt.setInt(1, studentId);
			stmt.setInt(2, courseId);
			//Executing query
			int rs = stmt.executeUpdate();
			if(rs>0)
			{
				System.out.println("Course dropped !");
				return;

			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		System.out.println("Course not found !");

	}

	// display list of courses selected by student
	public List<Course> displaySelectedCourses(Student student) {

		Connection connection= DBUtil.getConnection();
		PreparedStatement stmt= null;

		try {

			stmt= connection.prepareStatement(SQLConstantQueries.VIEW_SELECTED_COURSES);
			stmt.setInt(1, student.getStudentId());


			ResultSet rs = stmt.executeQuery();

			List<Course> list= new ArrayList<Course>();

			//Creating ArrayList of courses
			while(rs.next())
			{
				Course course = new Course();
				course.setCourseId(rs.getInt("CourseID"));
				course.setCourseTitle(rs.getString("CourseTitle"));
				course.setCredits(rs.getInt("Credits"));
				list.add(course);

			}

			//returning list of courses
			return list;
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return null;
	}


}
