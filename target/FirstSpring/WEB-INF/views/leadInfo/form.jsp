<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script>
        $( function() {
            $( "#eDate" ).datepicker();
        } );
	</script>
<title>New/Edit Lead Info</title>
</head>
<body>
	<div align="center">
		<h1>New/Edit Lead Info</h1>
		<form:form action="show" method="post" modelAttribute="leadInfo">
		<table>
			<form:hidden path="id"/>
			<tr>
				<td>Lead Name:</td>
				<td><form:input path="leadName" /></td>
			</tr>
			<tr>
				<td>Lead Description:</td>
				<td><form:input path="leadDescription" /></td>
			</tr>

			<tr>
				<td>Date:</td>
				<td ><form:input id="eDate" path="initiateDate" /></td>
			</tr>

			<tr>
				<td>Initiate By Employee:</td>
				<td><form:select path="initiateEmployeeId">
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