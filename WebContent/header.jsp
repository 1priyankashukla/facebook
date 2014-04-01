<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
.icon {
	
    background:#FFFFFF url(images/searchIcon.jpg) no-repeat 480px 1px;
    height:18px;
    width:500px
}
</style>


<script language="JavaScript" type="text/JavaScript" >

function callProfileAction(){
	document.myForm.action = "profileTempAction";
	document.getElementById("myForm").submit();
}

function inputFocus(i){
    if(i.value==i.defaultValue){ i.value=""; i.style.color="#000"; }
}
function inputBlur(i){
    if(i.value==""){ i.value=i.defaultValue; i.style.color="#888"; }
}

window.onload = function() {
    document.getElementById("Button6").onmouseover = function()
    {
        this.style.backgroundColor = "#355088";
    }

    document.getElementById("Button6").onmouseout = function()
    {
        this.style.backgroundColor = "#4e69a2";
    }

    document.getElementById("Button7").onmouseover = function()
    {
        this.style.backgroundColor = "#355088";
    }

    document.getElementById("Button7").onmouseout = function()
    {
        this.style.backgroundColor = "#4e69a2";
    }
}
 	
</script>
<title>Insert title here</title>

</head>
<body >
<br/>
<form  action="Search" id="myForm">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<img src="images/fb_icon.jpg" alt="Facebook Icon" style="position:relative;top:-4px" height="25" width="25"/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<input type="text" name="searchText" class="icon"  title="Search" style="color:#888;position:relative;top:-12px;left:-23px;" value="Search for people" onfocus="inputFocus(this)" onblur="inputBlur(this)"
onkeypress="submitOnEnter(this, event)" />


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<a href="<s:url action='profileTempAction'/>"><img src="images/aps.jpg" alt="profile_pic" height="35" width="35"/>&nbsp;&nbsp;<font color="white" face="Lucida Grande" size="3" style="position:relative;top:-12px"><b>Apurva</b></font></a>

<button id="Button7" type="submit"   style="background:#4e69a2;border:0;height:35px; width:100px;position:relative;top:-12px"><font color="white" face="Lucida Grande" size="3" ><b>Home</b></font></button>


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;


<a href="www.google.com"><img src="images/friend_icon.jpg" alt="Friend Request" 
height="25" width="30" onmouseover="this.src='images/friend_icon2.jpg'"
 onmouseout="this.src='images/friend_icon.jpg'" style="border:0"/></a>

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;


<a href="<s:url action='displayFullConversation'/>"><img src="images/message_icon.jpg" alt="Messages" 
height="25" width="30" onmouseover="this.src='images/message_icon2.jpg'"
 onmouseout="this.src='images/message_icon.jpg'" style="border:0"/></a>

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;


<a href="<s:url action='birthday'/>"><img src="images/notification_icon.jpg" alt="Notification" 
height="25" width="30"  style="border:0"/></a>


</form>





</body>
</html>