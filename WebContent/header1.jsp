<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">

.icon {
	
    background:#FFFFFF url(Images/searchIcon.jpg) no-repeat 480px 1px;
    height:18px;
    width:500px
}

</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="JavaScript" type="text/JavaScript" >

function inputFocus(i){
    if(i.value==i.defaultValue){ i.value=""; i.style.color="#000"; }
}
function inputBlur(i){
    if(i.value==""){ i.value=i.defaultValue; i.style.color="#888"; }
}
</script>

</head>
</head>
<body>
<br/>
<form  action="Search" id="myForm1"  >
<img src="Images/fb_icon.jpg" alt="Facebook Icon" style="position:relative;top:-6px;left:20px" height="30" width="30"/>
&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="searchText" class="icon" title="Search" style="color:#888;position:relative;top:0px;left:10px;height:20px" value="Search for people" onfocus="inputFocus(this)" onblur="inputBlur(this)"
onkeypress="submitOnEnter(this, event)" /> 
</form>





</body>
</html>