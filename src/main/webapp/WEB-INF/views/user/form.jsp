<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit User</title>
</head>
<body>
	<div align="center">
		<h1>New/Edit User</h1>
		<form:form action="show" method="post" modelAttribute="user">
		<table>
			<form:hidden path="id"/>
			<tr>
				<td>User Id:</td>
				<td><form:input path="userName" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:input path="password" /></td>
			</tr>

			<tr>
				<td>isActive:</td>
				<td><form:checkbox path="active" /></td>
			</tr>
			<tr>
				<td>Employee:</td>
				<td><form:select path="employeeId">
					<c:forEach items="${employeeList}" var="employee">
						<option value="${employee.id}">${employee.firstName}</option>
					</c:forEach>
				</form:select></td>
			</tr>

			<tr>
				<td colspan="2" align="center"><input type="submit" value="Save"></td>
			</tr>
		</table>
		</form:form>
	</div>
</body>
</html>