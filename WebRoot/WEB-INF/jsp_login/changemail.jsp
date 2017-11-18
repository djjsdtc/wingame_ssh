<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>修改邮箱 - Windows 小游戏研究学会</title>
    <base href=<%=basePath%> >
    <link rel="stylesheet" type="text/css" href="css/styles.css">
  </head>
  
  <body> <table id="pagetable" align="center">
<tbody><tr>
<td id="top" colspan="2" align="center"><jsp:include page="../jsp_public/head.jsp"></jsp:include><br></td>
			</tr>
<tr>
<td id="sidebar"><s:action name="sidebar" namespace="/" executeResult="true"><s:param name="redirect"><s:url includeParams="get" includeContext="false"/></s:param></s:action></td>
<td id="context">
    修改邮箱地址<br><s:form action="changeMailAction" namespace="/userlogin"><p>
    密码：&nbsp; <s:password size="30" name="password"/><s:fielderror cssClass="errorinfo" fieldName="password"></s:fielderror></p><p>
    原邮箱：<s:textfield size="30" name="originmail"/><s:fielderror cssClass="errorinfo" fieldName="originmail"></s:fielderror></p><p>
    新邮箱：<s:textfield size="30" name="newmail"/><s:fielderror cssClass="errorinfo" fieldName="newmail"></s:fielderror></p><p><s:submit value="修改邮箱"/></p></s:form><br>
  </td></tr>
<tr>
<td colspan="2"><jsp:include page="../jsp_public/foot.jsp"></jsp:include></td>
</tr>
</tbody></table></body>
</html>
