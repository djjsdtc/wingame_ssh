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
<title>用户登录 - Windows 小游戏研究学会</title>
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
	<s:if test="message!=null"><table border="1" bgcolor="yellow"><tr><td>
	<s:property value="message"/></td></tr></table></s:if>
	<s:else><s:set id="redirect" name="redirect" scope="session" value=""/></s:else>
				<s:form action="loginAction" namespace="/userlogin">
    <table border="0" width="511" height="252" background="images/login_form.png">
<tbody><tr>
<td rowspan="4" width="47"><img border="0" src="images/login_left.png"></td>
<td><br>用户名：<s:textfield maxlength="20" size="30" name="username" /></td>
<td rowspan="4" width="151">
    	<div style="background: url(images/login_right.png);width:151px;height:241px;"><br>
    	<s:fielderror fieldName="username"></s:fielderror>
    	<s:fielderror fieldName="password"></s:fielderror>
    	</div></td></tr>
<tr>
<td><br>密码：<s:password size="30" name="password" /></td>
</tr>
<tr>

<td><br><s:checkbox name="writecookie" />14天内保持登陆（公共场所请勿勾选）</td>
</tr>
<tr>

<td align="center"><s:submit value="登录" />
				<input type="button" onclick="window.location.href='userlogin/register'" value="注册新用户">
				<input type="button" onclick="window.location.href='userlogin/forget'" value="找回密码">
				</td>
				</tr>
				</tbody>
				</table>
				</s:form>
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
