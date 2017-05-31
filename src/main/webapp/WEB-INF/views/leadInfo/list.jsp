<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lead Info List</title>
    </head>
    <body>
    	<div align="center">
	        <h1>Lead Info List</h1>
	        <h3><a href="/leadInfo/show">New Lead Info</a></h3>
	        <table border="1">
	        	<th>No</th>
	        	<th>Lead Name</th>
	        	<th>Lead Description</th>
	        	<th>Initiate Date</th>
	        	<th>Initiate By Employee</th>

	        	<th>Action</th>
	        	
				<c:forEach var="test" items="${leadInfoList}" varStatus="status">
	        	<tr>
	        		<td>${status.index + 1}</td>
					<td>${test.leadName}</td>
					<td>${test.leadDescription}</td>
					<td>${test.initiateDate}</td>
					<td>
						<c:url value = "/leadInfo/getEmployee" var = "myURL">
							<c:param name = "employee" value = "${test.initiateEmployeeId}"/>
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