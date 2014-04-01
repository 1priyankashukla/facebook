<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>

<s:iterator value="ownNewsList">
	<br/>
	<br/>
	
		
		 <s:property value="displayString" /><br/>
	   <s:property value="time" /><br/>
	   <s:property value="status" />
	   
	   
	
</s:iterator>

 <s:if test="hasActionErrors()"> <div class="errors"> <s:actionerror/> </div> </s:if>
<br/><br/>






</body>
</html>