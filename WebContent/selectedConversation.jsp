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
<table>
				<s:iterator value="fullConversation">
					<tr>
						<td><font color="blue"><s:property value="senderName" /></font></td>
					</tr>
					<tr>
						<td><s:property value="text" /></td>
					</tr>
				</s:iterator>
			</table>
</body>
</html>