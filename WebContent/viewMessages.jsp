<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
div {
	box-sizing: border-box;
	-moz-box-sizing: border-box;
	-webkit-box-sizing: border-box;
	border: 1px solid black;
}

html,body,.container {
	height: 100%;
	min-height: 100%;
}

.left {
	float: left;
	width: 30%;
	height: 100%;
}

.right {
	float: right;
	width: 70%;
	height: 100%;
}

.messages {
	float: right;
	width: 100%;
	height: 75%;
}

.reply {
	float: right;
	width: 100%;
	height: 25%;
}
</style>

</head>
<body>
	<div class="left"></div>


	<div class="right">
		<div class="messages">
			<table>
				<s:iterator value="fullConversation">
					<tr>
						<td><s:property value="senderName" />:</td>
					
					
						<td><s:property value="text" /></td>
					</tr>
				</s:iterator>
			</table>
		</div>

		<div class="reply">
		
		</div>
		
	</div>

</body>
</html>