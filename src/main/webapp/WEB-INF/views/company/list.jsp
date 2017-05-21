<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Company List</title>
    </head>
    <body>
    	<div align="center">
	        <h1>Department List</h1>
	        <h3><a href="/company/show">New Company</a></h3>
	        <table border="1">
	        	<th>No</th>
	        	<th>Code</th>
	        	<th>Name</th>
	        	<th>Email</th>
	        	<th>Web Address</th>
	        	<th>Contact No.</th>
	        	<th>Establish Date</th>
	        	<th>Organization Type</th>
	        	<th>Organization Industry</th>

	        	<th>Action</th>
	        	
				<c:forEach var="test" items="${companyList}" varStatus="status">
	        	<tr>
	        		<td>${status.index + 1}</td>
					<td>${test.code}</td>
					<td>${test.name}</td>
					<td>${test.email}</td>
					<td>${test.webAddress}</td>
					<td>${test.phone}</td>
					<td>${test.establishDate.toString()}</td>
					<td>
						<c:url value = "/company/testData" var = "myURL">
							<c:param name = "orgType" value = "${test.organizationType}"/>
						</c:url>
						<c:import var = "data" url = "${myURL}"/>
						<%--<c:import var = "data" url = "/company/testData"/>--%>
						<c:out value = "${data}"/>
					</td>
					<%--<td><%=new com.technobangla.spring.controller.CompanyController().getOrgType(2)%></td>--%>

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