<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'permissionTool2' starting page</title>
  </head>
  <body>
<s:if test="actualPerm==requiredPerm">
<s:set id="id" name="id" scope="session" value="%{id}" />
<table border="0"><tr><td><s:form action="edit" namespace="/%{type}" method="get">
<s:submit value="修改" /></s:form></td>
<td><s:form action="delete" namespace="/%{type}">
<s:submit onclick="return confirm('确实要删除此项吗？');" value="删除" /></s:form></td></tr></table>
</s:if>
  </body>
</html>
