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
	您已经预报名了会议<s:property value="meeting.MTitle" />
	，请按如下时间地点准时参加。<br>由于您选择了到场支付会费，届时请携带足够的现金。
	<br><br>会议地点：<s:property value="meeting.MAddress" /><br>会议时间：<s:date name="meeting.MDatetime" /><br>
	会议费用：<s:property value="meeting.MFee" />元</td>
			</tr>
			<tr>
				<td colspan="2"><jsp:include page="../jsp_public/foot.jsp"></jsp:include><br></td>
			</tr>
		</tbody>
	</table>
	<br>
</body>
</html>
