<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>

div{
  box-sizing:border-box;
  -moz-box-sizing:border-box;
  -webkit-box-sizing:border-box;
  border:1px solid black;
}

html, body, .container
{
    height: 100%; 
    min-height: 100%;
    
}

.first {
    float: left;
    width: 100%;
    height: 20%;
	
background-image:url('Images/images.jpeg')   
}

.second{
    float: left;
    width: 30%;
    height: 60%;
    background-image:url('Images/index2.jpeg')
}


.third{
    float: right;
    width: 70%;
    height: 60%;
   background-image:url('Images/index2.jpeg')
    
}

.fourth {
    float: left;
    width: 50%;
    height: 20%;
   background-image:url('Images/images.jpeg')   
    
}
.fifth {
    float: right;
    width: 50%;
    height: 20%;
   background-image:url('Images/images.jpeg')   
}

a:link {color: whit; text-decoration: underline; }
a:active {color: white; text-decoration: underline; }
a:visited {color: white; text-decoration: underline; }
a:hover {color: white; text-decoration: none; }
</style>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>

<div class="container">
<div class="first"><tiles:insertAttribute name="header" /></div>
<div class="second"><tiles:insertAttribute name="menu" /></div>
<div class="third"><tiles:insertAttribute name="body" /></div>
<div class="fourth" ><tiles:insertAttribute name="announcement"/></div>
<div class="fifth"><tiles:insertAttribute name="news"/></div>

</div>â€‹


</body>
</html>