<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Work</title>
</head>
<body>

<form action="editWork2">

<input type="hidden" name="workPlaceId" value="<s:property value="workDetail.workPlaceId"/>"/>
<table border="0" cellpadding="5" width="300">
<tr>
	<td><label for="companynamelabel">Company Name</label>&nbsp;</td>
	<td><INPUT TYPE="text" NAME="companyName"  value="<s:property value="workDetail.companyName"/>"/></td>
</tr>
<tr>
	<td><label for="jobprofilelabel">Job Profile</label>&nbsp;</td>
	<td><INPUT TYPE="text" NAME="jobProfile" value="<s:property value="workDetail.jobProfile"/>"/></td>
</tr>
<tr>
	<td><label for="sdatelabel">Start DATE</label>&nbsp;</td>
	<td><INPUT TYPE="text" NAME="startDate" value="<s:property value="workDetail.startDate"/>"/></td>
</tr>
<tr>
	<td><label for="edatelabel">End DATE</label>&nbsp;</td>
	<td><INPUT TYPE="text" NAME="endDate" value="<s:property value="workDetail.endDate"/>"/></td>
</tr>
</table>
<input type="submit" value="Save" id="save"/>&nbsp;&nbsp;

</form></body>
</html>