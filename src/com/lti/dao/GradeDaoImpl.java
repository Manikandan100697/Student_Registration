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

/** 
 * @desc this class will hold functions for Grade Dao implementation
 * examples include displayGrades(Student student), uploadGrades(int studentId, int courseId, String grade)
 * @author Manikandan 
 */

public class GradeDaoImpl implements GradeDao, CloseConnection{

	// fetch grades of students against courseId and studentId
	public List<Course> displayGrades(Student student) {

		//Establishing the connection
		Connection connection= DBUtil.getConnection();
		PreparedStatement stmt= null;

		try {

			//Declaring prepared statement and executing query
			stmt= connection.prepareStatement(SQLConstantQueries.VIEW_GRADES);
			stmt.setInt(1, student.getStudentId());

			ResultSet rs = stmt.executeQuery();
			List<Course> list= new ArrayList<Course>();

			//Creating ArrayList of course
			while(rs.next())
			{
				Course course = new Course();

				course.setCourseId(rs.getInt("CourseID"));
				course.setCourseTitle(rs.getString("CourseTitle"));
				course.setGrade(rs.getString("Grade"));

				list.add(course);
			}
			//returning list of courses
			return list;
		}
		catch(SQLException ex) {

		}
		
		return null;
	}

	// upload grades against a studentId and courseId
	public void uploadGrades(int studentId, int courseId, String grade) {
		//Establishing the connection
		Connection connection = DBUtil.getConnection();
		PreparedStatement stmt=null;

		try {
			//Declaring prepared statement and executing query
			 stmt = connection.prepareStatement(SQLConstantQueries.UPLOAD_GRADES);

			stmt.setInt(1, studentId);
			stmt.setInt(2, courseId);
			stmt.setString(3, grade);

			//Executing query
			stmt.executeUpdate();


		} catch (SQLException ex) {

		}
		

	}

}

