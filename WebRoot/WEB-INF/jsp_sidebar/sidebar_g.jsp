<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
&nbsp;&nbsp;&nbsp;&nbsp;欢迎！初来乍到？<br>&nbsp;&nbsp;&nbsp;&nbsp;注册一个帐号吧！<br>
<ul><li><a href="">首页</a></li>
<li><a href="announcement/">查看公告</a></li>
<li><a href="meeting/">查看会议</a></li><br>
<li><a href="userlogin/">登陆</a></li>
<li><a href="userlogin/register">注册新用户</a></li>
<li><a href="userlogin/forget">找回密码</a></li>
</ul></td></tr>
<tr>
<td background="images/side_bottom.jpg" height="24"><br></td></tr>
</tbody></table></body>
</html>
