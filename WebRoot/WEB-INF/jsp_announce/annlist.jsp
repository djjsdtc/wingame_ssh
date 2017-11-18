<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>" target="_top" />
  </head>
  <body>
<ul><s:iterator id="announcement" value="list">
<li><s:a href="announcement/detail?id=%{#announcement.annId}"><s:property value="#announcement.annTitle" /></s:a></li>
</s:iterator></ul>
<s:if test="page != 1"><s:a href="announcement/annlist?meetingId=%{meetingId}&page=%{page-1}">上一页</s:a>&nbsp;&nbsp;&nbsp;</s:if>
	第<s:property value="page"/>页/共<s:property value="totalPage"/>页&nbsp;&nbsp;&nbsp;
	<s:if test="page < totalpage"><s:a href="announcement/annlist?meetingId=%{meetingId}&page=%{page+1}">下一页</s:a></s:if>
  </body>
</html>
