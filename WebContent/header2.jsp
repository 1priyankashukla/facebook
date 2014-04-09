<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script language="JavaScript" type="text/JavaScript" >



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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<a href="<s:url action='profileTempAction'/>"><button id="Button6" style="background:#4e69a2;border:0;height:35px;width:150px;position:relative;top:15px"><img width="40" height="40" src="image?photoId=<s:property value="%{user.profilePicId}" />" />&nbsp;&nbsp;<font color="white" face="Lucida Grande" size="3" style="position:relative;top:0px"><b><s:property value="%{user.firstName}"/> </b></font></button></a>

<a href="<s:url action='temp'/>"><button id="Button7" type="submit"   style="background:#4e69a2;border:0;height:35px; width:100px;position:relative;top:15px"><font color="white" face="Lucida Grande" size="3" ><b>Home</b></font></button></a>


<a href="www.google.com"><img src="Images/friend_icon.jpg" alt="Friend Request" 
height="25" width="30" onmouseover="this.src='Images/friend_icon2.jpg'"
 onmouseout="this.src='Images/friend_icon.jpg'" style="border:0;position:relative;top:15px"/></a>

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;


<a href="<s:url action='basicMessages'/>"><img src="Images/message_icon.jpg" alt="Messages" 
height="25" width="30" onmouseover="this.src='Images/message_icon2.jpg'"
 onmouseout="this.src='Images/message_icon.jpg'" style="border:0;position:relative;top:15px"/></a>

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;


<a href="<s:url action='birthday'/>"><img src="Images/notification_icon.jpg" alt="Notification" 
height="25" width="30"  style="border:0;position:relative;top:15px"/></a>


</body>
</html>