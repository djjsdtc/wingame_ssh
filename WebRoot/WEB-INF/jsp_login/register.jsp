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
<title>注册 - Windows 小游戏研究学会</title>
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
				<table border="1" width="439" height="240" bgColor="#ffffff">
<tbody><tr>
<td colspan="2" bgColor="#0080ff"><font color="#ffffff"><strong>用户注册</strong></font><a href="login.jsp"><font color="#ffffff"><strong></strong></font></a><br></td>
</tr>
<tr>
<td valign="top">
<s:form action="registerAction" namespace="/userlogin" validate="true">
用户名：<s:textfield maxlength="20" size="20" name="name"/><br>
<s:fielderror fieldName="name" cssClass="errorinfo"></s:fielderror>
密码：<s:password size="20" name="pswd1"/><br>
<s:fielderror fieldName="pswd1" cssClass="errorinfo"></s:fielderror>
确认密码：<s:password size="20" name="pswd2" /><br>
<s:fielderror fieldName="pswd2" cssClass="errorinfo"></s:fielderror>
电子邮箱：<s:textfield name="email" /><br>
<s:fielderror fieldName="email" cssClass="errorinfo"></s:fielderror>
真实姓名：<s:textfield name="realname" /><br>
<s:fielderror fieldName="realname" cssClass="errorinfo"></s:fielderror>
单位：<s:textfield name="company" size="40"/><br>
<s:fielderror fieldName="company" cssClass="errorinfo"></s:fielderror>
<s:submit value="注册" />&nbsp;&nbsp;&nbsp;<s:reset value="重新填写" />&nbsp;&nbsp;&nbsp;
<input type="button" value="返回" onclick="window.location='home.do'"></s:form></td>
<td valign="top" width="40%">填表说明：<br>1、所有选项均为必填项<br>2、密码长度至少为6<br>3、电子邮箱请认真填写，此为找回密码时的惟一依据<br></td></tr>

</tbody></table></td>
			</tr>
			<tr>
				<td colspan="2"><jsp:include page="../jsp_public/foot.jsp"></jsp:include></td>
			</tr>
		</tbody>
	</table>
	<br>
</body>
</html>
