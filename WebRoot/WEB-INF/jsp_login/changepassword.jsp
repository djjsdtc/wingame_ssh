<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<base href=<%=basePath%> >
    <title>修改密码 - Windows 小游戏研究学会</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
  </head>
  <body>
   <table id="pagetable" align="center">
<tbody><tr>
<td id="top" colspan="2" align="center"><jsp:include page="../jsp_public/head.jsp"></jsp:include><br></td>
			</tr>
<tr>
<td id="sidebar"><s:action name="sidebar" namespace="/" executeResult="true"><s:param name="redirect"><s:url includeParams="get" includeContext="false"/></s:param></s:action></td>
<td id="context">
    修改密码<br><s:form action="changePasswordAction" namespace="/userlogin"><p>
    原密码：<s:password size="20" name="origin" /><s:fielderror cssClass="errorinfo" fieldName="origin"></s:fielderror></p><p>
    新密码：<s:password size="20" name="new1" /><s:fielderror cssClass="errorinfo" fieldName="new1"></s:fielderror></p><p>
    确认新密码：<s:password size="20" name="new2" /><s:fielderror cssClass="errorinfo" fieldName="new2"></s:fielderror></p><p>
    <s:submit value="提交" /><br></p></s:form>注：密码长度至少为6<br>
  </td></tr>
<tr>
<td colspan="2"><jsp:include page="../jsp_public/foot.jsp"></jsp:include></td>
</tr>
</tbody></table></body>
</html>
