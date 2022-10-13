package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.DBConnect;
import com.dao.StudentDAO;
import com.entity.Student;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String dob = request.getParameter("dob");
		String address = request.getParameter("address");
		String qualification = request.getParameter("qualification");
		String email = request.getParameter("email");

		Student student = new Student(name, dob, address, qualification, email);

		StudentDAO dao = new StudentDAO(DBConnect.getConn());
		HttpSession session = request.getSession();

		boolean f = dao.addStudent(student);

		if (f) {
			session.setAttribute("succMsg", "student Details set successfully..");
			response.sendRedirect("add_student.jsp");
		} else {
			session.setAttribute("errorMsg", "Something Wrong on server..");
			response.sendRedirect("add_student.jsp");

		}

	}

}
