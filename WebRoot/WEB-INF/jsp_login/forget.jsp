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
<title>找回密码 - Windows 小游戏研究学会</title>
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
				<s:form action="resetPasswordAction" namespace="/userlogin"><table border="1" width="516" height="227" background="resetbg.jpg">
<tbody><tr>
<td bgColor="#0080ff"><strong><font color="#ffffff">找回密码</font></strong></td></tr>
<tr>
<td valign="top"><p>如果想重置您的密码，请输入您的用户名和注册时所留的邮箱：</p><p>
用户名：<s:textfield maxlength="20" size="20" name="name" /><s:fielderror cssClass="errorinfo" fieldName="name"></s:fielderror></p><p>
邮箱：<s:textfield size="30" name="mail" /><s:fielderror cssClass="errorinfo" fieldName="mail"></s:fielderror></p><p>
系统将会验证您的用户名与邮箱是否匹配，如匹配则会发送一封含有随机密码的电子邮件到您的邮箱。</p></td></tr>
<tr>
<td><s:submit value="发送重置邮件" />&nbsp;&nbsp;&nbsp; <s:reset value="重填" />&nbsp;&nbsp; <input type="button" onclick='window.location="login.jsp"' value="返回"></td></tr>
</tbody></table></s:form>
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
