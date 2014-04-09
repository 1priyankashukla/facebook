<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="<s:url action='getAllMessagesInDatabase'/>">View Messages</a>
<a href="<s:url action='displayFullConversation'/>">View Conversation</a>
<a href="<s:url action='basicMessages'/>">Messages</a>


<!-- s:form action = "getAllMessagesInDatabase"> -->

 <!--  s:textfield name="user2Id" /> -->
 <!--  s:submit label="Send request"/>-->
       
<!--  /s:form> -->
</body>
</html>