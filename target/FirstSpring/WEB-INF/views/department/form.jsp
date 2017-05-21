<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Department</title>
</head>
<body>
	<div align="center">
		<h1>New/Edit Department</h1>
		<form:form action="show" method="post" modelAttribute="department">
		<table>
			<form:hidden path="id"/>
			<tr>
				<td>Dept. Code:</td>
				<td><form:input path="departmentCode" /></td>
			</tr>
			<tr>
				<td>Dept. Name:</td>
				<td><form:input path="departmentName" /></td>
			</tr>

			<tr>
				<td colspan="2" align="center"><input type="submit" value="Save"></td>
			</tr>
		</table>
		</form:form>
	</div>
</body>
</html>