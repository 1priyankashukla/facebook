<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
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

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>

</head>
<body>

<div class="left">
	<!-- write all user and the last message of their conversation . -->
    <tiles:insertAttribute name="recentConversations" />
</div>


<div class="right">
		<div class="messages">
		<tiles:insertAttribute name="selectedConversation" />
		</div>

		<div class="reply">
		<tiles:insertAttribute name="replyToConversation" />
		</div>
</div>

</body>
</html>