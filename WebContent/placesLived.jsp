<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style> 
 
.scroll1
{

width:640px;
height:130px;
overflow:scroll;

}
 </style> 
</head>
<body onload="place.close()">
<div class="scroll1">
<h3>Places Lived</h3>
<s:iterator value="placesList">
	<br/>
	 <s:property value="whereto" />
	  <!-- ********************************Shubham Code Start ***************************************-->
	   <a href="<s:url action='editLocation1'><s:param name="location"><s:property value="whereto" /></s:param> 
	   <s:param name="citytype"><s:property value="address" /></s:param></s:url>">edit</a><br/>
	  <!--   <a href="javascript:window.open('editPlace.jsp',EPLACE);">EDIT</a>-->
	 
	  	<!-- ********************************Shubham Code End ***************************************--> 
	
	 </s:iterator>
<br/>
<a href="javascript:window.open('newPlace.jsp', 'place', 'width=1000,height=500');">Add Place</a>


</div>

</body>
</html>