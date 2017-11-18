<%@ page language="java" pageEncoding="UTF-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>创建或修改公告 - Windows 小游戏研究学会</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
  </head>
  
  <body><table id="pagetable" align="center">
<tbody><tr>
<td id="top" colspan="2" align="center"><jsp:include page="../jsp_public/head.jsp"></jsp:include><br></td>
			</tr>
<tr>
<td id="sidebar"><s:action name="sidebar" namespace="/" executeResult="true"><s:param name="redirect"><s:url includeParams="get" includeContext="false"/></s:param></s:action></td>
<td id="context">创建或修改公告<br><s:if test="result != null">
<s:set name="title" scope="action" value="%{result.annTitle}" />
<s:set name="mid" scope="action" value="%{result.TMeeting.MId}" />
<s:set name="text" scope="action" value="%{result.annText}" />
</s:if><s:set name="id" scope="session" value="%{#parameters['id']}" id="id" />
<s:form action="changeAnnounce" namespace="/announcement">
<p>公告标题：<s:textfield size="40" name="title" value="%{title}" /></p>
<p>关联会议：<s:select list="meetingList" listKey="id.MId" listValue="id.MTitle" headerKey="%{mid}" name="mid"/>
<br></p><p>公告内容：<br></p><p><s:textarea wrap="virtual" cols="40" rows="10" name="context" value="%{text}" /></p>
<p><s:submit value="确认" />&nbsp;&nbsp;&nbsp;
<s:reset value="清空" onclick="return confirm('确定要清空吗？');" />&nbsp;&nbsp;&nbsp;
<input type="button" value="返回" onclick="window.history.back()"></p></s:form><br></td></tr>
<tr>
<td colspan="2"><jsp:include page="../jsp_public/foot.jsp"></jsp:include></td>
</tr>
</tbody></table>
  </body>
</html>