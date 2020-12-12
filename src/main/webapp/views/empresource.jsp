<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<h1>Resource Allocation</h1>
</head>
<body>
<table>
		<form:form action="saveresource" modelAttribute="empresource" method="post">
		
		
			<tr>
				<td>designationId:</td>
				<td><form:select path="designationId">
				<form:option value="">-Select-</form:option>
				<form:options items="${designation}"/>
					</form:select></td>
			</tr>
			<tr>
				<td>Employee ID:</td>
				<td><form:select path="empName">
				<form:option value="">-Select-</form:option>
				<form:options items="${allEmployees}"/>
					</form:select></td>
			</tr>
			<tr>
				<td>Resource INFO:</td>
				<td><form:select path="sysId">
				<form:option value="">-Select-</form:option>
				<form:options items="${allSystemType}"/>
					</form:select></td>
			</tr>
<!-- 			<tr> -->
<!-- 				<td>empId:</td> -->
<%-- 				<td><form:input path="empName" /></td> --%>
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>mouse:</td> -->
<%-- 				<td><form:input path="mouse" /></td> --%>
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>keyBoard:</td> -->
<%-- 				<td><form:input path="keyBoard" /></td> --%>
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>lanCable:</td> -->
<%-- 				<td><form:input path="lanCable" />  	  --%>
<!-- 				 </td> -->
<!-- 			</tr> -->

			  mouse:<form:checkbox path="mouse" value="true" /><br>
			keyboard:<form:checkbox path="keyBoard" value="true" /><br>
			lancable:<form:checkbox path="lanCable" value="lancable" /><br>
<!-- 			 <td>ResourceInfo :</td> -->
<!-- 				    <td> -->
<%--                                        mouse:<form:checkbox path="resourceInfo" value="mouse" /><br> --%>
<%--                                       keyboard:<form:checkbox path="resourceInfo" value="keyboard" /><br> --%>
<%--                                        lancable:<form:checkbox path="resourceInfo" value="lancable" /><br> --%>
<!--                                 </td> -->
			 <tr>
				<td><input type="submit" value="register" id="submit"></td>
			</tr>
		</form:form>
	</table>
</body>
</html>