<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%-- <div>${employee}</div> --%>
	<!-- <h1>Employee</h1> -->
	<div align="center">

		<h1>Employees</h1>
		<jstl:if test="${employee != null }">
			<table border="10">
				<tr>
					<th>Employee ID</th>
					<th>Employee Name</th>
					<th>Employee Salary</th>
				</tr>
				<jstl:forEach items="${employee}" var="employee">
					<tr>
						<td>${employee.empId}</td>
						<td>${employee.empName}</td>
						<td>${employee.empSalary}</td>
					</tr>
				</jstl:forEach>
			</table>
		</jstl:if>
		<jstl:if test="${employee == null}">
			<h2>No Employee found!</h2>
		</jstl:if>
	</div>
</body>
</html>