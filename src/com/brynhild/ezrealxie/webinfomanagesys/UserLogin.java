package com.brynhild.ezrealxie.webinfomanagesys;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    public boolean validateCredential(String inputUserNameString, String inputPasswordString) {
		
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
		
		try {
			String sqlString = "SELECT * FROM user_group WHERE username = ? + and password = ?";
			pStatement = dbConnection.prepareStatement(sqlString);
			pStatement.setString(1, inputUserNameString);
			pStatement.setString(2, inputPasswordString);
			rSet = pStatement.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		if (rSet != null) {
			return true;
		} else {
			return false;
		}
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
			String sqlString = "SELECT uid FROM user_group WHERE username = ? + and password = ?";
			pStatement = dbConnection.prepareStatement(sqlString);
			pStatement.setString(1, inputUserNameString);
			pStatement.setString(2, inputPasswordString);
			rSet = pStatement.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		if (rSet != null) {
			pWOut.println("Log In.");
		} else {
			pWOut.println("Failed.");
		}
		
		pWOut.flush();
		pWOut.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
