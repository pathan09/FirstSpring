<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Home</title>
</head>
<body>
<div align="center">
    <h1>Menu List</h1>
    &nbsp;&nbsp;&nbsp;&nbsp;
    <h3>
        <a href="/organizationType/list">Organization Type List</a>
        &nbsp;&nbsp;
        <a href="/organizationIndustry/list">Organization Industry List</a>
        &nbsp;&nbsp;
        <a href="/department/list">Department List</a>
        &nbsp;&nbsp;
        <a href="/designation/list">Designation List</a>
    </h3>
    <h3>
        <a href="/leadSteps/list">LeadSteps List</a>
        &nbsp;&nbsp;
        <a href="/company/list">Company List</a>
        &nbsp;&nbsp;
        <a href="/employee/list">Employee List</a>
        &nbsp;&nbsp;
        <a href="/accountInfo/list">Account Info List</a>
        &nbsp;&nbsp;
    </h3>

    <h3>
        <a href="/accountContact/list">Account Contact List</a>
        &nbsp;&nbsp;
        <a href="/user/list">User List</a>
        &nbsp;&nbsp;
    </h3>

    <%-- <h3><a href="newContact">New Contact</a></h3>
     <table border="1">
         <th>No</th>
         <th>Name</th>
         <th>Email</th>
         <th>Address</th>
         <th>Telephone</th>
         <th>Action</th>

         <c:forEach var="contact" items="${listContact}" varStatus="status">
         <tr>
             <td>${status.index + 1}</td>
             <td>${contact.name}</td>
             <td>${contact.email}</td>
             <td>${contact.address}</td>
             <td>${contact.telephone}</td>
             <td>
                 <a href="editContact?id=${contact.id}">Edit</a>
                 &nbsp;&nbsp;&nbsp;&nbsp;
                 <a href="deleteContact?id=${contact.id}">Delete</a>
             </td>

         </tr>
         </c:forEach>
     </table>--%>
</div>
</body>
</html>
