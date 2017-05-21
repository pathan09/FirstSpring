<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Department List</title>
    </head>
    <body>
    	<div align="center">
	        <h1>Department List</h1>
	        <h3><a href="/department/show">New Department</a></h3>
	        <table border="1">
	        	<th>No</th>
	        	<th>Dept. Code</th>
	        	<th>Dept. Name</th>

	        	<th>Action</th>
	        	
				<c:forEach var="test" items="${departmentList}" varStatus="status">
	        	<tr>
	        		<td>${status.index + 1}</td>
					<td>${test.departmentCode}</td>
					<td>${test.departmentName}</td>

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
