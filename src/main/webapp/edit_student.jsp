<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.conn.*, com.dao.*,com.entity.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="all_css.jsp"%>
</head>
<body class="bg-light">
	<%@include file="navbar.jsp"%>
	<div class="container p-4">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<p class="fs-3 text-center">Edit Student</p>


						<%
						int id = Integer.parseInt(request.getParameter("id"));
						StudentDAO dao = new StudentDAO(DBConnect.getConn());
						Student s = dao.getStudentById(id);
						%>



						<form action="UpdateServlet" method="post">

							<div class="mb-3">
								<label class="form-label">Full Name</label> <input name="name"
									type="text" value="<%=s.getFullName()%>" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Date Of Birth</label> <input
									name="dob" type="date" value="<%=s.getDob()%>"
									class="form-control">
							</div>


							<div class="mb-3">
								<label class="form-label">Address</label> <input name="address"
									type="text" value="<%=s.getAddress()%>" class="form-control">
							</div>



							<div class="mb-3">
								<label class="form-label">Qualification</label> <input
									name="qualification" type="text"
									value="<%=s.getQualificatio()%>" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Email </label> <input name="email"
									type="email" value="<%=s.getEmail()%>" class="form-control">
							</div>



							<input type="hidden" name="id" value="<%=s.getId()%>">

							<button type="submit" class="btn btn-primary col-md-12">Update</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>