<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Education</title>
</head>
<body>

<form action="editEducation2">									

<input type="hidden" name="schoolId" value="<s:property value="educationDetail.schoolId"/>"/>
<table border="0" cellpadding="5" width="300">
<tr>
	<td><label for="schoolnamelabel">School Name</label>&nbsp;</td>
	<td><INPUT TYPE="text" NAME="schoolName"  value="<s:property value="educationDetail.schoolName"/>"/></td>
</tr>
<tr>
	<td><label for="gyearlabel">Graduation Year</label>&nbsp;</td>
	<td><INPUT TYPE="text" NAME="graduationYear" value="<s:property value="educationDetail.graduationYear"/>"/></td>
</tr>
<tr>
	<td><label for="concentrationlabel">Concentration</label>&nbsp;</td>
	<td><INPUT TYPE="text" NAME="concentration" value="<s:property value="educationDetail.concentration"/>"/></td>
</tr>
</table>
<input type="submit" value="Save" id="save"/>&nbsp;&nbsp;

</form></body>
</html>