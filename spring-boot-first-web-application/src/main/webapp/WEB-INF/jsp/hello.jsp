<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"> 
  </script>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"> </script>
<html>
<head>
<title>Spring-Boot Training</title>
</head>
<body>
Hello ${loginInUser},<div></div></br>
	Spring Boot Training Welcome to JSP!
	<div></div>
	<form method="post" action="/addEmployee">
		<table>
			<tr>
				<td>Employee Name:</td>
				<td><input name="ename" type=text /></td>
			</tr>
			<tr>
				<td>Emp-ID :</td>
				<td><input name="eID" type=text /></td>
			</tr>
			<tr>
				<td>Training :</td>
				<td><input name="eTrainingname" type=text /></td>
			</tr>
			<tr>
				<td><input type="submit" value="ADD"></td>
			</tr>




		</table>


	</form>

	<table border="1" cellpadding="5">
		<caption>
			<h2>List of Employee</h2>
		</caption>
		<tr>

			<th>EmployeeName</th>
			<th>Employee ID</th>
			<th>Training</th>
			<th>Delete</th>
			<th>Update</th>

		</tr>
		<c:forEach var="user" items="${emp}">
			<tr>

				<td><c:out value="${user.getEmployeeName()}" /></td>
				<td><c:out value="${user.getEmployeeID()}" /></td>
				<td><c:out value="${user.getTrainingDTO().getTrainingName()}" /></td>
				<td><a type="button" class="btn btn-warning"
					href="/deleteEmployee?id=${user.getId()}">Delete</a></td>
				<td><a type="button" class="btn btn-success"
					href="/fetchEmployee?id=${user.getId()}">Update</a></td>

			</tr>
		</c:forEach>
	</table>
<div class="container"> 
        <h1> 
     
    <a type="button" class="btn btn-success"
					href="/logout">logout</a>
    </h1> 
    </div>


</body>
</html>