<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="css/addFriendButton.css" rel="stylesheet"/>
<style>


</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


</head>
<body>
<br/><br/><br/><br/><br/>
<s:iterator value="searchResult">
<br/>
<div ><a href="www.google.com"><img src="<s:property value="profileImage"/>" alt="Friend Request" 
height="150" width="150"/></a>
&nbsp; &nbsp; &nbsp;<a href="<s:url action='profilePage' > <s:param name="profileId"><s:property value="profileId" /></s:param></s:url>" style="position:relative;top:-130px" >
<b><s:property value="firstName" /> &nbsp;<s:property value="lastName" /></b></a><br/>
<a href="#" class="addFriendButton"/>Add Friend</a>

</div>
</s:iterator>

</body>
</html>