<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee List</title>
    </head>
    <body>
    	<div align="center">
	        <h1>Employee List</h1>
	        <h3><a href="/employee/show">New Employee</a></h3>
	        <table border="1">
	        	<th>No</th>
	        	<th>Employee ID</th>
	        	<th>First Name</th>
	        	<th>Last Name</th>
	        	<th>Designatio</th>
	        	<th>Department</th>
	        	<th>Company</th>
	        	<th>Phone</th>
	        	<th>Email</th>

	        	<th>Action</th>
	        	
				<c:forEach var="test" items="${employeeList}" varStatus="status">
	        	<tr>
	        		<td>${status.index + 1}</td>
					<td>${test.employeeId}</td>
					<td>${test.firstName}</td>
					<td>${test.lastName}</td>
					<td>
						<c:url value = "/employee/getDesignation" var = "myURL">
							<c:param name = "designationId" value = "${test.designationId}"/>
						</c:url>
						<c:import var = "data" url = "${myURL}"/>
						<c:out value = "${data}"/>
					</td>
					<td>
						<c:url value = "/employee/getDepartment" var = "myURL">
							<c:param name = "departmentId" value = "${test.departmentId}"/>
						</c:url>
						<c:import var = "data" url = "${myURL}"/>
						<c:out value = "${data}"/>
					</td>
					<%--<td>
						<c:url value = "/employee/getCompany" var = "myURL">
							<c:param name = "companyId" value = "${test.companyId}"/>
						</c:url>
						<c:import var = "data" url = "${myURL}"/>
						<c:out value = "${data}"/>
					</td>--%>
					<td>${test.phone}</td>
					<td>${test.email}</td>


					<td>
						<a href="edit?id=${test.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="delete?id=${test.id}">Delete</a>
					</td>
							
	        	</tr>
				</c:forEach>	        	
			</table>
    	</div>
    </body>
</html>