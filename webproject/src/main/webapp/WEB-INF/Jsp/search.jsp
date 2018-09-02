<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form onsubmit="get_action(this);">
		Enter Employee Id: <input type="number" name="employeeId" ></input>
							<input type="submit">
	</form>
</body>
<script type="text/javascript">
	function get_action(form) {
		form.action = 'http://' + document.getElementById("address").value;
	}
</script>
</body>
</html>