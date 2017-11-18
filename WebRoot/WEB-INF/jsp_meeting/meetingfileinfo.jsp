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
    <title>My JSP 'meetingfileinfo.jsp' starting page</title>
  </head>
  
  <body>
<s:if test='actualPerm=="u"'><a href="fileupload/">现在就去上传材料</a><br>
<s:if test="attended" >您已经报名参加了本次会议，参会费支付方式是到场支付。</s:if>
<s:else>您还没有报名参加本次会议。</s:else><br></s:if>
  </body>
</html>
