<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href=<%=basePath%>>
<title>会议一览 - Windows 小游戏研究学会</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>

<body>
	<table id="pagetable" align="center">
		<tbody>
			<tr>
				<td id="top" colspan="2" align="center"><jsp:include
						page="../jsp_public/head.jsp"></jsp:include><br>
				</td>
			</tr>
			<tr>
				<td id="sidebar"><s:action name="sidebar" namespace="/" executeResult="true"><s:param name="redirect"><s:url includeParams="get" includeContext="false"/></s:param></s:action></td>
				<td id="context">
				<s:if test="message!=null"><table border="1" bgcolor="yellow"><tr><td>
	<s:property value="message"/></td></tr></table></s:if>
				会议一览<br>
				<s:action name="permissionLink" namespace="/" executeResult="true">
					<s:param name="requiredPerm">a</s:param>
					<s:param name="href">meeting/edit</s:param>
					<s:param name="text">添加新会议</s:param>
				</s:action><hr><ul>
			<s:iterator id="meeting" value="list">
			<li><s:a href="meeting/detail?id=%{#meeting.id.MId}"><s:property value="#meeting.id.MTitle" /></s:a></li>
			</s:iterator></ul>
			<s:if test="page != 1"><s:a href="meeting/?page=%{page-1}">上一页</s:a>&nbsp;&nbsp;&nbsp;</s:if>
	第<s:property value="page"/>页/共<s:property value="totalPage"/>页&nbsp;&nbsp;&nbsp;
	<s:if test="page < totalpage"><s:a href="meeting/?page=%{page+1}">下一页</s:a></s:if>
			</td>
			</tr>
			<tr>
				<td colspan="2"><jsp:include page="../jsp_public/foot.jsp"></jsp:include><br></td>
			</tr>
		</tbody>
	</table>
	<br>
</body>
</html>
