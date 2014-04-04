<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Place</title>
</head>
<body>
<center>
<h3> MOVED </h3>
<form action="addPlace">
	<label for="wherelabel">WhereTo</label>&nbsp;
<INPUT TYPE="text" NAME="whereto"/><br/><br/>
<label for="addresslabel">Address</label>&nbsp;
<INPUT TYPE="text" NAME="address"/><br/><br/>
<label for="fromlabel">From</label>&nbsp;
<INPUT TYPE="text" NAME="from"/><br/><br/>
<label for="whenlabel">When</label>&nbsp;
<INPUT TYPE="text" NAME="when"/><br/><br/>
<label for="storylabel">Story</label>&nbsp;
<INPUT TYPE="text" NAME="story"/><br/><br/>

<input type="submit" value="Save" id="save"/>&nbsp;&nbsp;
<input type="button"" onclick="place.close()" value="Cancel" id="cancel"/>

</form>
</center>


</body>
</html>