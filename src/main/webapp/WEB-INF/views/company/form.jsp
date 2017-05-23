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
<title>New/Edit Company</title>
</head>
<body>
	<div align="center">
		<h1>New/Edit Company</h1>
		<form:form action="show" method="post" modelAttribute="company">
		<table>
			<form:hidden path="id"/>
			<tr>
				<td>Company Code:</td>
				<td><form:input path="code" /></td>
			</tr>
			<tr>
				<td>Company Name:</td>
				<td><form:input path="name" /></td>
			</tr>

			<tr>
				<td>Email:</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>Web Address:</td>
				<td><form:input path="webAddress" /></td>
			</tr>
			<tr>
				<td>Contact No:</td>
				<td><form:input path="phone" /></td>
			</tr>

			<tr>
				<td>Date:</td>
				<td ><form:input id="eDate" path="establishDate" /></td>
			</tr>

			<tr>
				<td>Organization Type:</td>
				<td><form:select path="organizationType">
					<c:forEach items="${orgTypes}" var="org">
						<option value="${org.id}">${org.name}</option>
					</c:forEach>
				</form:select></td>
			</tr>

			<tr>
				<td>Organization Industry:</td>
				<td><form:select path="organizationIndustry">
					<c:forEach items="${orgIndustrys}" var="industry">
						<option value="${industry.id}">${industry.name}</option>
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