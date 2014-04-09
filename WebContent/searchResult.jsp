<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="js/jquery-1.9.1.js"></script>

<style>
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


</head>
<body style= "background-color:#eeeff4;">
	<br/>
	
	<br/>
	<br/>
	<br/>
	<br/>
	
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<s:iterator value="searchResult">
		<br />
		<center>
		<div style="background-color:white;height:150px;width:600px;border:0px;">
			<form action="sendFriendRequest">
				<a href="www.google.com" ><img width="150" height="150"
					src="image?photoId=<s:property value="profilePicId" />" /></a>
					
				 &nbsp;&nbsp; &nbsp;<a href="<s:url action='profilePage' > <s:param name="profileId"><s:property value="profileId" /></s:param></s:url>"
					style="position: relative; top: -130px" style="position:relative;top:500px"> <b><s:property	value="firstName" /> &nbsp;<s:property value="lastName" /></b></a><br />

				<input type="hidden" name="userId1"	value="<s:property value="userId" />" /> 
					<input type="hidden" name="userId2" value="<s:property value="profileId" />" />
					<input type="hidden" name="searchText" value="<s:property value="searchText" />" />

				<s:if test="isFriend==\"Y\"">

					<input type="submit" name="Submit" value="Friends" style="position: relative; left: 180px; top: -110px" />
				</s:if>
				<s:elseif test="isFriend==\"N\"">

					<input type="submit" name="Submit" value="Add Friends" style="position: relative; left: 180px; top: -110px" />
				</s:elseif>
				<s:elseif test="isFriend==\"S\"">
					<input type="submit" name="Submit" value="Friend Request Sent" style="position: relative; left: 180px; top: -110px" disabled="disabled" />
				</s:elseif>
				<s:elseif test="isFriend==\"R\"">

					<input type="submit" name="Submit" value="Respond to Friend Request" style="position: relative; left: 180px; top: -110px" />
				
				</s:elseif>


			</form>

		</div>
		</center>
	</s:iterator>
	
</body>
</html>