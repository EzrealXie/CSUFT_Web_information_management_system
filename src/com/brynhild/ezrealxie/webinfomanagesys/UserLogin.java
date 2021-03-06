package com.brynhild.ezrealxie.webinfomanagesys;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		String inputUserNameString = request.getParameter("inputUserName");
		String inputPasswordString = request.getParameter("inputPassword");
		Connection dbConnection = null;
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		
		//Acquire database driver
		

		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			System.out.println("Driver acquired.");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Driver missing.");
		}
		
		//Establish database connection.
		
		try {
			dbConnection = DriverManager.getConnection("jdbc:mysql://rm-uf6t232h92unv3jwgto.mysql.rds.aliyuncs.com:3306/default_schema", "webuser_login", "login");
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
			
			String sqlString = "SELECT * FROM default_schema.user_group WHERE username = "+inputUserNameString+" and password = "+inputPasswordString+" ";
			System.out.println(inputUserNameString);
			System.out.println(inputPasswordString);
			System.out.println(sqlString);
//			String sqlString = "SELECT * FROM default_schema.user_group WHERE username = ? + and password = ?";
			pStatement = dbConnection.prepareStatement(sqlString);
//			pStatement.setString(1, inputUserNameString);
//			pStatement.setString(2, inputPasswordString);
			rSet = pStatement.executeQuery(sqlString);
			System.out.println(rSet.getString("uid"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("username", inputUserNameString);

		try {
			
			if (rSet.next()) {
				
				session.setAttribute("uid", rSet.getString("uid"));
				session.setAttribute("username", rSet.getString("username"));
				response.sendRedirect("loginsuccess.jsp");
				System.out.println("suc");
				
			} else {

				session.setAttribute("message", "Credentials Error.");
				response.sendRedirect("login.jsp");
				return;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

}
