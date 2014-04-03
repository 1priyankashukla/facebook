<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body onload="place.close()">
<a href="javascript:window.open('newPlace.jsp', 'place', 'width=1000,height=500');">Add Place</a>
<br/>
<h3>Places Lived</h3>
<s:iterator value="placesList">
	
	 <s:property value="whereto" /><br/>
	   <s:property value="address" /><br/>
	   <s:property value="from" />
	   
	   
	
</s:iterator>



</body>
</html>