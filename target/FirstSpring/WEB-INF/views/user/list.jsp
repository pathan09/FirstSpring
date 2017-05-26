<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User List</title>
    </head>
    <body>
    	<div align="center">
	        <h1>User List</h1>
	        <h3><a href="/user/show">New User</a></h3>
	        <table border="1">
	        	<th>No</th>
	        	<th>User Id</th>
	        	<th>Password</th>
	        	<th>isActive</th>
	        	<th>Employee Name</th>

	        	<th>Action</th>
	        	
				<c:forEach var="test" items="${userList}" varStatus="status">
	        	<tr>
	        		<td>${status.index + 1}</td>
					<td>${test.userName}</td>
					<td>${test.password}</td>
					<td>${test.active}</td>

					<td>
						<c:url value = "/user/getEmployee" var = "myURL">
							<c:param name = "employeeId" value = "${test.employeeId}"/>
						</c:url>
						<c:import var = "data" url = "${myURL}"/>
						<c:out value = "${data}"/>
					</td>

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
