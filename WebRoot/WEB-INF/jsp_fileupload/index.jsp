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
<title>文档管理 - Windows 小游戏研究学会</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<script>
function ChangeMeeting(){
	var selectBox = document.getElementById("meeting");
	var meetingId = selectBox.options[selectBox.selectedIndex].value;
	document.getElementById("annlist").src = "fileupload/selectmeeting?id=" + meetingId;
}
</script>
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
文档管理<br>按会议筛选：
				<s:select id="meeting" list="list" listKey="id.MId" listValue="id.MTitle" onclick="ChangeMeeting();"/>
				<br><hr>
<iframe id="annlist" src="" width="100%" height="500px" frameborder="0"></iframe>
<script>ChangeMeeting();</script>
				</td>
			</tr>
			<tr>
				<td colspan="2"><jsp:include page="../jsp_public/foot.jsp"></jsp:include></td>
			</tr>
		</tbody>
	</table>
	<br>
</body>
</html>
