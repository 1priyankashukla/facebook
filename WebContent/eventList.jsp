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
			<td width="93%">Events</td>
			<td>
				<form action="">
					<input type="submit" value="+ Create event"
						onclick="javascript:window.open('createEvent.action','CreateEvent');" />
				</form>
			</td>
		</tr>
	</table>
	<hr>
	<br>
	<br> Upcoming Events
	<br>
	<br>


	<s:iterator var="parent" value="eventD">

		<table>
			<tr>
				<td bgcolor="#E3E4FA"><s:property value="dt" /></td>
			</tr>

		</table>

		<%!int var1 = 0;%>


		<s:iterator var="child1" value="#parent.birthday">


			<s:if test="%{#child1!=null}">
				<%
					var1 = var1 + 1;
				%>

				<%
					if (var1 == 1) {
				%>
				<p>Birthdays</p>
				<%
					}
				%>

				<s:if test="%{var1  == '1'}">Birthdays</s:if>

				<s:if test="%{dt=='Today' }">
					<table>
						<tr>
							<td><s:property value="#child1.profilePicAlbumId" /></td>


							<td><a
								href="<s:url action="profilePage" >  
    <s:param name="profileId"> <s:property value="#child1.profileId"/> </s:param>
    </s:url>"
								target="dynamic"> <s:property value="#child1.firstName" />
									<s:property value="#child1.lastName" />
							</a></td>

						</tr>
						<tr>
							<td width="20%"></td>
							<td><s:if test="%{#child1.flagB==false }">

									<form action="postWishEvent">
										<input type="hidden" name="profileId"
											value="<s:property value="#child1.profileId"/>" />
										<input type="hidden" name="flagEventWished" value="true"/> 
										<s:if
											test="%{#child1.gender=='Male' || #child1.gender=='male' || #child1.gender=='MALE'}">

											<input type="text" name="wish" style="width: 150%;"
												placeholder="Write a birthday wish on his timeline..."
												onkeypress="handle" />
										</s:if>
										<s:elseif
											test="%{#child1.gender=='Female' || #child1.gender=='female' || #child1.gender=='FEMALE'}">

											<input type="text" name="wish" style="width: 150%;"
												placeholder="Write a birthday wish on her timeline..."
												onkeypress="handle" />
										</s:elseif>

									</form>

								</s:if> <s:else>
					You wrote on <s:property value="#child1.firstName " />'s timeline.
					
					</s:else></td>
						</tr>


					</table>
				</s:if>
				<s:else>
					<a
						href="<s:url action="profilePage" ><s:param name="profileId"> <s:property value="#child1.profileId"/> </s:param>
    </s:url>"
						target="dynamic"
						title="<s:property value="#child1.firstName" /> <s:property
									value="#child1.lastName" /> 's birthday"><s:property
							value="#child1.profilePicAlbumId" /></a>

				</s:else>

			</s:if>
		</s:iterator>

		<s:iterator var="child2" value="#parent.event">
			<s:if test="%{#child2!=null}">

				<table>
					<tr>
						<td><s:property value="#child2.startT" /></td>
						<td><a
							href=" <s:url action="eventPage">
		  <s:param name="profileEventID"><s:property value="#child2.profileEventID"/> 
		  </s:param>
    	  </s:url>"
							target="dynamic"> <s:property
									value="#child2.eventPicId" /></a></td>
						<td><a
							href=" <s:url action="eventPage">
		  <s:param name="profileEventID"><s:property value="#child2.profileEventID"/> 
		  </s:param>
    	  </s:url>"
							target="dynamic"> <s:property value="#child2.eventName" /></a>
							 <br>
							<s:property value="#child2.location" /> <br> <s:property
								value="#child2.host" /> invited you. <br>

							<form action="eventRsvp">
								<input type="submit" value="Join" name="type" /> <input
									type="submit" value="Maybe" name="type" /> <input
									type="submit" value="Decline" name="type" /> <input
									type="hidden" value="<s:property value="sessionId"/>"
									name="sessionId" /> <input type="hidden"
									value="<s:property value="#child2.profileEventID"/>"
									name="eventId" />
							</form></td>
					</tr>
				</table>
				

			</s:if>
		</s:iterator>


	</s:iterator>



</body>
</html>