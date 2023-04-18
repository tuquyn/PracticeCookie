<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/31/2023
  Time: 9:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Example 3</title>
</head>
<body style="background-color: hotpink;">
	<h1>Print out the cookies</h1>
	<hr>
	<form method="post" action="CookieExample">
		<table>
			<tbody>
			<tr>
				<td>Input cookie name:</td>
				<td><input type="text" name="cName"></td>
			</tr>
			<tr>
				<td>Input cookie value:</td>
				<td><input type="text" name="cValue"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Submit"></td>
			</tr>
			</tbody>
		</table>
	</form>
</body>
</html>
