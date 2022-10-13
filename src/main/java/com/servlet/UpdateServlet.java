package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.DBConnect;
import com.dao.StudentDAO;
import com.entity.Student;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		String name = request.getParameter("name");
		String dob = request.getParameter("dob");
		String address = request.getParameter("address");
		String qualification = request.getParameter("qualification");
		String email = request.getParameter("email");
		int id = Integer.parseInt(request.getParameter("id"));

		Student student = new Student(id, name, dob, address, qualification, email);

		StudentDAO dao = new StudentDAO(DBConnect.getConn());
		HttpSession session = request.getSession();
		boolean f = dao.updateStudent(student);

		if (f) {
			session.setAttribute("succMsg", "student Details update successfully..");
			response.sendRedirect("index.jsp");
		} else {
			session.setAttribute("errorMsg", "Something Wrong on server..");
			response.sendRedirect("index.jsp");

		}

	}

}
