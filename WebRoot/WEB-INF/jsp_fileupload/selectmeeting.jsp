<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>" target="_self">
    <link rel="stylesheet" type="text/css" href="css/styles.css">
  </head>
  <body><s:if test="message!=null"><table border="1" bgcolor="yellow"><tr><td>
	<s:property value="message"/></td></tr></table></s:if>
  <s:set id="id" name="id" scope="session" value="%{id}" /><s:if test="filename!=null">
当前文件：<s:a target="_top" href="upload/%{filename}"><s:property value="filename" /></s:a><br>
当前文件的状态：<s:property value="status" /></s:if>
<s:else>您还没有上传本次会议的所需文档。</s:else>
<s:if test='currentTime<deadline && status!="已通过" '>
<s:if test='status!=""'><s:form action="delete" namespace="/fileupload">
<s:submit value="删除文件" /></s:form></s:if>
<s:form action="upload" namespace="/fileupload" enctype="multipart/form-data">
<s:file name="file" /><s:submit value="上传" />
</s:form></s:if>
<s:if test='currentTime<datetime && status=="已通过" '>
<br>您已通过本会议的文档审核，可以<s:a target="_top" href="application/home?id=%{id}">进入预报名系统</s:a>进行会议预报名。
</s:if>
  </body>
</html>
