package com.brynhild.ezrealxie.webinfomanagesys;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.mail.handlers.text_html;

public class UserLogin extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6373168450250335169L;

	public UserLogin(){
		super();
	}
	public void destroy(){
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter pWOut = response.getWriter();
		
		String inputUserNameString = request.getParameter("inputUserName");
		String inputPasswordString = request.getParameter("inputPassword");
		Connection dbConnection = null;
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		
		//Acquire database driver
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver acquired.");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Driver missing.");
		}
		
		//Establish database connection.
		
		try {
			dbConnection = DriverManager.getConnection("jdbc:mysql://rm-uf6t232h92unv3jwgto.mysql.rds.aliyuncs.com/default_schema", "webuser_login", "login");
			if (dbConnection != null) {
				System.out.println("Connection established.");
			} else {
				System.out.println("Database connection error.");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		//Validate credential
		
		try {
			String sqlString = "SELECT * FROM user_group WHERE username = " + inputUserNameString + "and password = " + inputPasswordString;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
