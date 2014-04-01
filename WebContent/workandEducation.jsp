<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script>


function hideTextBoxes(){
	
	document.getElementById('work').style.visibility='hidden';
	document.getElementById('edu').style.visibility='hidden';
}
function showTextBoxes(){
	
	document.getElementById('work').style.visibility='visible';
	document.getElementById('edu').style.visibility='visible';

	
	}
</script>

</head>
<body onload="hideTextBoxes()">
<b>Work and Education</b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="submit" value="Edit" id="Edit" onclick="showTextBoxes()"/>

<br/>
<INPUT TYPE="text" NAME="work" value="where have you worked?" id="work"><br/><br/>
<INPUT TYPE="text" NAME="education" value="where did you go to College?" id="edu">

</body>
</html>