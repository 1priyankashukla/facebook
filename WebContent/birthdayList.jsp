<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
		function handle(e) {
			if (e.keyCode === 13) {
				$(this).submit();
			}

			return false;
		}
	</script>

	<table>
		<tr>
			<td width="93%">Today's Birthdays</td>
			<td><a href="eventList.action">See All</a></td>
		</tr>
	</table>
	<hr>

	<s:iterator value="birthday">
		<table>
			<tr>
				<td><s:property value="profilePicAlbumId" /></td>
				<td><a
					href="<s:url action="profilePage" >  
    <s:param name="profileId"> <s:property value="profileId"/> </s:param>
    </s:url>"
					target="dynamic"> <s:property value="firstName" /> <s:property
							value="lastName" />
				</a>.<s:property value="age" /> years old</td>

			</tr>
			<tr>
				<td width="20%"></td>
				<td><s:if test="%{flagB==false }">

						<form action="postWish">
							<input type="hidden" name="profileId"
								value="<s:property value="profileId"/>" />

							<s:if
								test="%{gender=='Male' || gender=='male' || gender=='MALE'}">

								<input type="text" name="wish" style="width: 150%;"
									placeholder="Write a birthday wish on his timeline..."
									onkeypress="handle" />
							</s:if>
							<s:elseif
								test="%{gender=='Female' || gender=='female' || gender=='FEMALE'}">

								<input type="text" name="wish" style="width: 150%;"
									placeholder="Write a birthday wish on her timeline..."
									onkeypress="handle" />
							</s:elseif>

						</form>

					</s:if> <s:else>
					You wrote on <s:property value="firstName " />'s timeline.
					
					</s:else></td>
			</tr>


		</table>
	</s:iterator>
</body>
</html>