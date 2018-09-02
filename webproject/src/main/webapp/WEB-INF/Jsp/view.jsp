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
	<%-- <div>${emp.empName}</div>
	<div>${emp}</div> --%>
	<div align="center">
	<jstl:if test="${emp != null}">
		<h1>Customer</h1>
		<table border="10">
			<tr>
				<th>Employee Id</th>
				<th>Employee Name</th>
				<th>Employee Salary</th>
			</tr>
			<tr>
				<td>${emp.empId}</td>
				<td>${emp.empName}</td>
				<td>${emp.empSalary}</td>
			</tr>
		</table>
		
	</jstl:if>
	<jstl:if test="${emp == null}">
		<h2>No Employee found!</h2>
	</jstl:if>
	
	</div>

</body>
</html>