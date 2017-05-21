<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Designation List</title>
    </head>
    <body>
    	<div align="center">
	        <h1>Designation List</h1>
	        <h3><a href="/designation/show">New Designation</a></h3>
	        <table border="1">
	        	<th>No</th>
	        	<th>Designation Code</th>
	        	<th>Designation Name</th>

	        	<th>Action</th>
	        	
				<c:forEach var="test" items="${designationList}" varStatus="status">
	        	<tr>
	        		<td>${status.index + 1}</td>
					<td>${test.code}</td>
					<td>${test.name}</td>

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
