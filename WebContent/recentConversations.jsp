<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<!--  write all user and the last message of their conversation .-->
	<br/>
			<table>
				<s:iterator value="recentConversationWithAll">
					<tr>
						<td>	
						<a href="<s:url action='showConversationWithSelectedUser' ><s:param name="selectedUser"><s:property value="user2Id"/></s:param></s:url>" ><s:property value="user2Name" /></a>					   
					    </td>
					</tr>
					
					<tr>
						<td><s:property value="lastMessageText" /></td>
					</tr>
				</s:iterator>
			</table>
	
	
</body>
</html>