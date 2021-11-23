package com.lti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lti.bean.Course;
import com.lti.bean.Professor;
import com.lti.constant.SQLConstantQueries;
import com.lti.utils.CloseConnection;
import com.lti.utils.DBUtil;
/** 
 * @desc this class will hold functions for Professor Dao implementation
 * examples include selectCourse(int courseId ,Professor professor), deselectCourse(int courseId, Professor professor)
 * @author Manikandan 
 */
public class ProfessorDaoImpl implements ProfessorDao, CloseConnection{

	// select a course by professor to teach
	public void selectCourse(int courseId ,Professor professor)  {

		//Establishing the connection
		Connection connection = DBUtil.getConnection();
		PreparedStatement stmt= null;

		try {
			//Declaring prepared statement and executing query
			stmt = connection.prepareStatement(SQLConstantQueries.SELECT_COURSE);

			int professorId= professor.getProfessorId();

			stmt.setInt(1, professorId);
			stmt.setInt(2, courseId);


			//Executing query
			stmt.executeUpdate();
			System.out.println("Course with courseId="+courseId+" selected to teach!");

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		

	}

	// deselect a selected course by professor gainst courseId
	public void deselectCourse(int courseId, Professor professor) {

		//Establishing the connection
		Connection connection = DBUtil.getConnection();
		PreparedStatement stmt= null;
		try {

			stmt=connection.prepareStatement(SQLConstantQueries.DESELECT_COURSE);

			stmt.setInt(1, courseId);
			//Executing query
			int rs = stmt.executeUpdate();
			if(rs>0)
			{
				System.out.println("Course deselected !");
				return;

			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		System.out.println("Course not found !");

	}

	// display the list of courses selected by professor
	public List<Course> displaySelectedCoursesProfessor(Professor professor) {

		//Establishing the connection
		Connection connection= DBUtil.getConnection();
		PreparedStatement stmt= null;

		try {

			stmt= connection.prepareStatement(SQLConstantQueries.DISPLAY_PROFESSOR_SELECTED_COURSES);
			stmt.setInt(1, professor.getProfessorId());

			ResultSet rs = stmt.executeQuery();

			List<Course> list= new ArrayList<Course>();

			//Creating ArrayList of course
			while(rs.next())
			{
				Course course = new Course();
				course.setCourseId(rs.getInt("CourseID"));
				course.setCourseTitle(rs.getString("CourseTitle"));
				course.setStudentsEnrolled(rs.getInt("NumberOfStudentsEnrolled"));

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

