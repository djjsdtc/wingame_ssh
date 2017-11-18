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
&nbsp;&nbsp;&nbsp;&nbsp;您可以尝试一下：<br>
<ul><li><a href="javascript:history.back();">返回上一页</a></li>
<li><a href="">返回首页</a></li>
<li><a href="announcement/">查看公告</a></li>
<li><a href="meeting/">查看会议</a></li>
</ul></td></tr>
<tr>
<td background="images/side_bottom.jpg" height="24"><br></td></tr>
</tbody></table></body>
</html>
