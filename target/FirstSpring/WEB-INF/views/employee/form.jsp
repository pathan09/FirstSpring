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
<title>New/Edit Employee</title>
</head>
<body>
	<div align="center">
		<h1>New/Edit Employee</h1>
		<form:form action="show" method="post" modelAttribute="employee">
		<table>
			<form:hidden path="id"/>
			<tr>
				<td>Employee Id:</td>
				<td><form:input path="employeeId" /></td>
			</tr>
			<tr>
				<td>First Name:</td>
				<td><form:input path="firstName" /></td>
			</tr>

			<tr>
				<td>Last Name:</td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td>Contact No:</td>
				<td><form:input path="phone" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>Designation:</td>
				<td><form:select path="designationId">
					<c:forEach items="${designationList}" var="designation">
						<option value="${designation.id}">${designation.name}</option>
					</c:forEach>
				</form:select></td>
			</tr>

			<tr>
				<td>Department:</td>
				<td><form:select path="departmentId">
					<c:forEach items="${departmentList}" var="department">
						<option value="${department.id}">${department.departmentName}</option>
					</c:forEach>
				</form:select></td>
			</tr>

			<tr>
				<td>Company:</td>
				<td><form:select path="companyId">
					<c:forEach items="${companyList}" var="company">
						<option value="${company.id}">${company.name}</option>
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