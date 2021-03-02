<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<html>
<head>
<title>List Employee</title>
</head>
<body>
	List of employee
	<div></div>

	<div align="center"></div>
	 <table border="1" cellpadding="5">
            <caption><h2>List of users</h2></caption>
            <tr>
                <th>ID</th>
                <th>EmployeeName</th>
                <th>Employee ID</th>
                <th>Training</th>
            </tr>
            <c:forEach var="user" items="${emp}">
                <tr>
                    <td><c:out value="${user.getId()}" /></td>
                    <td><c:out value="${user.getEmployeeName()}" /></td>
                    <td><c:out value="${user.getEmployeeID()}" /></td>
                    <td><c:out value="${user.getTrainingDTO().getTrainingName()}" /></td>
                </tr>
            </c:forEach>
        </table>





</body>
</html>