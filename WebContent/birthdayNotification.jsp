<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


<style>
a:hover {
	background-color: #E3E4FA;
}

a {
	text-decoration: none;
}
</style>


</head>
<body>

	<s:if test="flag">
		<a href="birthdayList.action" onclick=javascript:window.open(
			"birthdayList.action","birthdayList"); style="color: #00008B"; ><img
			src="images/birthdayIcon.jpg" /> <s:property
				value="displayBirthdayList" /></a>
	</s:if>
	<s:else>


	</s:else>




</body>
</html>