package com.lti.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface CloseConnection {

	//initializing logger


	//default function to close connections
	default public void closeConnection( Connection conn,PreparedStatement stmt){

		try{
			if(stmt!=null)
				stmt.close();
		}catch(SQLException se2){
		}// nothing we can do
		try{
			if(conn!=null)
				conn.close();
		}catch(SQLException se){

		}


	}

}
