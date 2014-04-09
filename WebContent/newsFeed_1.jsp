<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<link rel="stylesheet" type="text/css" href="facebook.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>News Feed</title>
<script type="text/javascript">
function handleKeyPress(e,form){
var key=e.keyCode || e.which;
if (key==13){
/* 	document.myForm.action = "submitComment";
 */	document.getElementById("myForm").submit();
}
}
</script>
</head>
<body>
	<form id="myForm" action="submitComment">
		<table>
			<tbody>
				<tr>
					<td class="scrollit"><s:iterator value="posts" >

							<table border="0" cellspacing="5" bordercolor="#eceff6"
								bgcolor="#eceff6">
	 							<tr>
									<td>
										<table border="0" cellspacing="0" bgcolor="#ffffff"
											width="560">
											<tr>
												<s:iterator value="postOwner">
													<td rowspan="2" width="80"><a href=""><img
															src="image?photoId=<s:property value="photoId" />" height="60" width="60"></a></td>
													<td colspan="2"><a href="" class="nameFont"><span
															class="hover"><s:property value="userName" /></span></a></td>
												</s:iterator>
											</tr>
											<tr>
												<td class="timeFont"><s:property value="postDate"/> at <s:property value="postTime" />.</td>
											</tr>
											<tr>
												<td colspan="3"><s:property value="userStatus" /></td>
											</tr>
											<tr>
												<td colspan="3">
													<table>
														<tr height="20px">
															<td><a
																href="<s:url action='deleteLike' > <s:param name="index"><s:property value="postId" /></s:param></s:url>"
																class="likeCommentFont"><span class="hover"><s:if
																			test="youLiked">Unlike</s:if></span></a><a
																href="<s:url action='insertLike' > <s:param name="index"><s:property value="postId" /></s:param></s:url>"
																class="likeCommentFont"><span class="hover"><s:else>Like</s:else></span></a></td>
															<td class="likeCommentFont">.</td>
															<td><a href="" class="likeCommentFont"><span
																	class="hover">Comment</span></a></td>
														</tr>
													</table>
												</td>
											</tr>

										</table>

									</td>
								</tr>
								<tr>
									<td>
										<table border="0" cellpadding="0" cellspacing="0"
											bgcolor="#f7f7f7">
											<s:if test="likeCount!=0">

												<tr height="30px">
													<td class="fbgreybox" colspan="3" width="530"><a
														href=""><img src="image?photoId=<s:property value="photoId" />" height="20"
															width="20"></a> &nbsp;<s:if test="likeCount<5">
															<s:iterator value="peopleLiked"
																status="peopleLikedStatus">
																<s:if
																	test="%{youLiked && (#peopleLikedStatus.index==0)}">
																	<s:property />
																</s:if>
																<s:else>
																	<a href="" class="likeCommentFont"> <span
																		class="hover"><s:property /></span></a>
																</s:else>
																<s:if test="#peopleLikedStatus.last==false">
																	<s:if test="%{(#peopleLikedStatus.count+1)==likeCount}"> and </s:if>
																	<s:else>,</s:else>
																</s:if>
															</s:iterator>
														</s:if> <s:else>
															<s:iterator value="peopleLiked"
																status="peopleLikedStatus" begin="0" end="3">
																<s:if
																	test="%{youLiked && (#peopleLikedStatus.index==0)}">
																	<s:property />
																</s:if>
																<s:else>
																	<a
																		onclick="window.open('header.jsp','mywindow','width=400,height=200')"
																		class="likeCommentFont"><span class="hover"><s:property /></span></a>
																</s:else>
																<s:if test="#peopleLikedStatus.last==false">
															,
														</s:if>
															</s:iterator>
													
												and <a href=""
																onClick="window.open('<s:url action='showLikes' > <s:param name="index"><s:property value="postId" /></s:param></s:url>','People Who Like This',100,'height=100,scrollbars=yes');"
																class="likeCommentFont"><span class="hover"><s:property
																		value="likeCount-4" /> others</span></a>
														</s:else> like this.
												</tr>
											</s:if>
											<s:if test="commentCount!=0">
												<s:iterator value="comment">
													<tr>
														<td><s:hidden value="commentId" /></td>
													</tr>

													<tr>
														<td colspan="2">
															<table border="0" bordercolor="#f7f7f7">
																<tr>
																	<s:iterator value="commentOwner">

																		<td rowspan="2"><a href=""><img
																				src="image?photoId=<s:property value="photoId" />" height="35" width="35"></a></td>
																		<td><a href="" class="commentNameFont"><span
																				class="hover"><s:property value="userName" /></span></a></td>
																	</s:iterator>

																	<td colspan="2" width="380"><span
																		class="commentFont"> <s:property
																				value="description" /></span></td>
																</tr>

																<tr height="18">
																	<td colspan="3" class="timeFont"><s:property value="date" /> at
																		<s:property value="time" /> . <a
																		href="<s:url action='deleteLikeComment' > <s:param name="commentIndex"><s:property value="commentId" /></s:param></s:url>"
																		class="likeTextCommentFont"><span class="hover"><s:if
																					test="youLiked">Unlike</s:if></span></a><a
																		href="<s:url action='insertLikeComment' > <s:param name="commentIndex"><s:property value="commentId" /></s:param></s:url>"
																		class="likeTextCommentFont"><span class="hover"><s:else>Like</s:else></span></a>
																		. <s:if test="%{likeCount!=0}">
																			<a href=""
																				onclick="window.open('<s:url action='showCommentLikes' > <s:param name="commentIndex"><s:property value="commentId" /></s:param></s:url>','People Who Like This',100,'height=100,scrollbars=yes');"
																				class="likeOnCommentFont"><span class="hover"><img
																					src="Images/like.jpg" height="17" width="17">
																					<s:property value="likeCount" /></span></a>
																		</s:if>
																	</td>
																</tr>
															</table>
														</td>
													</tr>
												</s:iterator>
											</s:if>
											<tr>
											<tr>
												<td><input type="hidden" name="postId1" value="<s:property value="postId"/> " /></td>
												<td><a href=""><img src="image?photoId=<s:property value="photoId" />"
														height="35" width="35"></a></td>
												<td colspan="2">&nbsp;
												<input type="text"
													name="description"
													onkeypress="handleKeyPress(event,this.form)"
													placeholder="Write a comment..." class="resizedCommentBox" />
												</td>
											</tr>
											
			
										</table>
			
									</td>
								</tr>
								
							</table>
						</s:iterator> </td>
				</tr>
			</tbody>
		</table>
		</form>
</body>
</html>