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
    <title>用户管理 - Windows 小游戏研究学会</title>
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
	<s:if test="message!=null"><table border="1" bgcolor="yellow"><tr><td>
	<s:property value="message"/></td></tr></table></s:if>
    用户管理<br><br>
    <table border="1"><tbody>
		<tr>
			<td width="150px">用户名</td>
			<td width="300px">邮箱</td>
			<td width="150px">真实姓名</td>
			<td width="300px">单位</td>
			<td width="50px">操作</td>
		</tr>
	<s:iterator id="userrecord" value="list"><s:form action="userRemoveAction" namespace="/usermgmt">
 	<tr>
		<td><s:hidden name="username" value="%{#userrecord.username}" /><s:property value="#userrecord.username"/></td>
		<td><s:a href="mailto:%{#userrecord.email}"><s:property value="#userrecord.email" /></s:a></td>
		<td><s:property value="#userrecord.realname" /></td>
		<td><s:property value="#userrecord.company" /></td>
		<td>
		<s:if test='#userrecord.role!="a"'><s:submit value="删除" onclick="return confirm('确定要删除此用户的信息吗？此操作不可恢复！');" /></s:if>
		</td></tr></s:form></s:iterator>
	</tbody></table><br>
	<s:if test="page != 1"><s:a href="usermgmt/?page=%{page-1}">上一页</s:a>&nbsp;&nbsp;&nbsp;</s:if>
	第<s:property value="page"/>页/共<s:property value="totalPage"/>页&nbsp;&nbsp;&nbsp;
	<s:if test="page < totalpage"><s:a href="usermgmt/?page=%{page+1}">下一页</s:a></s:if>
	</td></tr>
<tr>
<td colspan="2"><jsp:include page="../jsp_public/foot.jsp"></jsp:include></td>
</tr>
</tbody></table>
  </body>
</html>
