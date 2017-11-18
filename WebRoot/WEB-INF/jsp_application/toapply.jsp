<%@ page language="java" pageEncoding="UTF-8" %>
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
<title>会议预报名系统 - Windows 小游戏研究学会</title>
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
				<td id="context">会议预报名系统<hr>
	您正在预报名会议：<s:property value="meeting.MTitle" />。<br>请再次确认以下信息以确保您有时间参会：<br>
	会议地点：<s:property value="meeting.MAddress" /><br>会议时间：<s:date name="meeting.MDatetime" /><br>
	会议费用：<s:property value="meeting.MFee" />元<br><br>如果您确认参加此会议，请选择您的参会费用支付方式：<br>
	<s:form method="post" action="apply" namespace="/application">
	<input type="button" value="在线支付" disabled="disabled">
	&nbsp;&nbsp;&nbsp;&nbsp;<s:submit value="到场支付" /></s:form></td>
			</tr>
			<tr>
				<td colspan="2"><jsp:include page="../jsp_public/foot.jsp"></jsp:include><br></td>
			</tr>
		</tbody>
	</table>
	<br>
</body>
</html>
