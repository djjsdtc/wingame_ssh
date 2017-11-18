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
  </head>
  
  <body><table border="0" width="230" cellspacing="0px">
<tbody><tr>
<td background="images/side_top.jpg" height="29"><br></td></tr>
<tr>
<td background="images/side_main.jpg">
&nbsp;&nbsp;&nbsp;&nbsp;欢迎您回来！<br>&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="#session.username" /><br>
<ul><li><a href="">首页</a></li>
<li><a href="announcement/">查看公告</a></li>
<li><a href="meeting/">查看会议</a></li><br>
<li><a href="fileupload/">文档上传</a></li><br>
<li>帐号维护<ul>
<li><a href="userlogin/changemail">修改邮箱</a></li>
<li><a href="userlogin/changepassword">修改密码</a></li>
<li><a href="userlogin/logout">注销登陆</a></li></ul>
</ul></td></tr>
<tr>
<td background="images/side_bottom.jpg" height="24"><br></td></tr>
</tbody></table></body>
</html>
