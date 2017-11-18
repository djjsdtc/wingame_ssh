<%@ page language="java" pageEncoding="UTF-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title><s:property value="result.annTitle" /> - Windows 小游戏研究学会</title>
    <base href=<%=basePath%> >
    <link rel="stylesheet" type="text/css" href="css/styles.css">
  </head>
  <body> <table id="pagetable" align="center">
<tbody><tr>
<td id="top" colspan="2" align="center"><jsp:include page="../jsp_public/head.jsp"></jsp:include><br></td>
			</tr>
<tr>
<td id="sidebar"><s:action name="sidebar" namespace="/" executeResult="true"><s:param name="redirect"><s:url includeParams="get" includeContext="false"/></s:param></s:action></td>
<td id="context"><s:if test="message!=null"><table border="1" bgcolor="yellow"><tr><td>
	<s:property value="message"/></td></tr></table></s:if><s:property value="result.annTitle" />
<br>关联会议：<s:a href="meeting/detail?id=%{result.TMeeting.MId}"><s:property value="result.TMeeting.MTitle" /></s:a><br>
<s:action name="permissionButton" namespace="/" executeResult="true">
	<s:param name="requiredPerm">a</s:param>
	<s:param name="id"><s:property value="result.annId"/></s:param>
	<s:param name="type">announcement</s:param>
</s:action>
<hr><s:generator separator="
" val='result.annText' var="mytext" />
<s:iterator id="text" value="mytext"><s:property escapeHtml="true" value="text"/><br></s:iterator>
</td></tr>
<tr>
<td colspan="2"><br><jsp:include page="../jsp_public/foot.jsp"></jsp:include><br></td>
</tr>
</tbody></table></body>
</html>
