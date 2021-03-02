<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"> </script>



<html>
<head>
<title>Updating Employee Details</title>
</head>
<body>
	<form:form method="POST" action="/updateEmployee" modelAttribute="emp">
	
	
		
		
	
		<table>
			<tr>
				<td>Employee Name:</td>
				<td><input name="ename" type=text
					value="${emp.getEmployeeName()}" /></td>
					<td><input type = "hidden" name="id" value = "${emp.getId()}" /></td>
			</tr>
			<tr>
				<td>Emp-ID :</td>
				<td><input name="eID" type=text value="${emp.getEmployeeID()}" /></td>
			</tr>
			<tr>
				<td>Training :</td>
				<td><input name="eTrainingname" type=text
					value="${emp.getTrainingDTO().getTrainingName()}" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="CONFIRM"></td>
			</tr>




		</table>
	</form:form>



</body>
</html>