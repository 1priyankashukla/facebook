<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
.icon {
	
    background:#FFFFFF url(Images/searchIcon.jpg) no-repeat 375px 1px;
    height:18px;
    width:400px
}
.clearfix:after {
   content: " "; 
   visibility: hidden;
   display: block;
   height: 0;
   clear: both;
}

a.fill-div {
    display: block;
    height: 100%;
    width: 100%;
    text-decoration: none;
}
</style>


<script language="JavaScript" type="text/JavaScript" >
function inputFocus(i){
    if(i.value==i.defaultValue){ i.value=""; i.style.color="#000"; }
}
function inputBlur(i){
    if(i.value==""){ i.value=i.defaultValue; i.style.color="#888"; }
}
</script>
<title>Insert title here</title>

</head>
<body >
<form>
</br>

<div style="float: left;" class="clearfix">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<img src="Images/fb_icon.jpg" alt="Facebook Icon" height="25" width="25"/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<input type="text" name="sample" class="icon"  title="Search" style="color:#888;position:relative;top:-12px;left:-20px;" value="Search for people" onfocus="inputFocus(this)" onblur="inputBlur(this)" />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="www.google.com"><img src="Images/profile_pic.jpg" alt="profile_pic" height="35" width="35"/></a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<b><a href="www.google.co.in"  style="text-decoration: none;color:white">Priyanka</a></b> 
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;


<b><a href="www.google.co.in" style="text-decoration: none;color:white"> Home</a></b>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="www.google.com"><img src="Images/friend_icon.jpg" alt="Friend Request" 
height="25" width="30" onmouseover="this.src='Images/friend_icon2.jpg'"
 onmouseout="this.src='Images/friend_icon.jpg'" style="border:0"/></a>

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="www.google.com"><img src="Images/message_icon.jpg" alt="Friend Request" 
height="25" width="30" onmouseover="this.src='Images/message_icon2.jpg'"
 onmouseout="this.src='Images/message_icon.jpg'" style="border:0"/></a>

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="www.google.com"><img src="Images/notification_icon.jpg" alt="Friend Request" 
height="25" width="30"  style="border:0"/></a>
</div>
<div style="float: left;" class="clearfix" height="40px" widht="100px" style="position:absolute;top:10px;left:500px"><img src="Images/profile_pic.jpg" alt="profile_pic" height="25" width="25"/><a href="#" class="fill-div" style="text-decoration: none;color:white">Priyanka</a></div>


</form>

</body>
</html>