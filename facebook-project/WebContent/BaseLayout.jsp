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
    height: 10%;
    
	
  
}

.second{
    float: left;
    width: 100%;
    
   
}


}

</style>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>

<div class="container">
<div class="first" style="background:#4e69a2;position:fixed"><tiles:insertAttribute name="header" /></div>
<div class="second"><tiles:insertAttribute name="body" /></div>


</div>


</body>
</html>