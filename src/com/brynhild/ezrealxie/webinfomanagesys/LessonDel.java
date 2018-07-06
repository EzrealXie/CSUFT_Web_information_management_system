package com.brynhild.ezrealxie.webinfomanagesys;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LessonDel
 */
@WebServlet("/LessonDel")
public class LessonDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LessonDel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		String inputClassNumString = request.getParameter("inputClassNum");
		Connection dbConnection = null;
		PreparedStatement pStatement = null;
		
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
			
			String sqlString = "DELETE FROM `default_schema`.`lesson` WHERE `ClassNum`="+inputClassNumString+"";
			pStatement = dbConnection.prepareStatement(sqlString);
//			pStatement.setString(1, inputclassnameString);
//			pStatement.setString(2, inputClassNumString);
			pStatement.execute(sqlString);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
		
		response.sendRedirect("del.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
