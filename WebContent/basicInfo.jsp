<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script >
function onClickofGender(){
	alert("gender");
	
	       window.location = '/addGender.jsp';
	  


}

function onLoadHide(){
	
	document.getElementById('genderOptions').style.visibility='hidden';
}
</script>
<style> 
 
.scroll
{

width:640px;
height:130px;
overflow:scroll;

}
 </style> 

</head>
<body onload="onLoadHide()">
<div class="scroll">
<h3>Basic Info</h3>
<label for="bwholeDateLabel" style="color:#888;">Birth  whole Date :</label>&nbsp;<s:property value="basicInfo.birthDate"/><br/>
<!-- <label for="bDateLabel" style="color:#888;">Birth Date :</label>&nbsp;<s:property value="basicInfo.bDate"/><br/> -->
<!-- <label for="bYearLabel" style="color:#888;">Birth Year :</label>&nbsp;<label for="bYear"><s:property value="basicInfo.bYear"/></label> -->


 <s:if test="basicInfo.gender!=null">  
 <label for="genderLabel" style="color:#888;">Gender : </label>&nbsp;<label for="gender"><s:property value="basicInfo.gender"/></label>
                    
 </s:if>  
 <s:else>
 	 <a href="<s:url action='gender_temp'><s:param name="editParam">gender</s:param></s:url>">Add Gender</a>
 	
 </s:else>
 <br/>
 
 
 
  <s:if test="basicInfo.interests==null">  
              <a href="<s:url action='gender_temp'><s:param name="editParam">interests</s:param></s:url>">Add Interested In</a>       
 </s:if>  
 <s:else>
 	<label for="interestsLabel" id="interestsLabel" style="color:#888;">Interested in</label>&nbsp;<label for="interests"><s:property value="basicInfo.interests"/></label>
 </s:else>
 <br/>
 
 
 
  <s:if test="basicInfo.relationship==null">  
              <a href="">Add Relationship</a>       
 </s:if>  
 <s:else>
 	<label for="relationshipLabel" style="color:#888;">Relationship</label>&nbsp;<label for="relationship"><s:property value="basicInfo.relationship"/></label>
 </s:else>
 <br/>
 
 
 
  <s:if test="basicInfo.religion==null">  
              <a href="<s:url action='gender_temp'><s:param name="editParam">religion</s:param></s:url>">Add Religion</a>       
 </s:if>  
 <s:else>
 	<label for="religionLabel" style="color:#888;">Religion</label>&nbsp;<label for="religion"><s:property value="basicInfo.religion"/></label>
 </s:else>
 <br/>
 
 
  </div>
</body>
</html>