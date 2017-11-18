<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>" target="_self" />
  </head>
  <body><s:set id="page" name="page" scope="action" value="%{page}" />
   <table border="1" width="100%" cellpadding="0" cellspacing="0">
   <tr>
<td style="vertical-align: middle;">文件名</td>
<td style="vertical-align: middle;">上传用户</td>
<td style="vertical-align: middle;" width="100px">文档状态</td>
<td width="200px">操作</td></tr>
<s:iterator id="document" value="list">
<tr>
<td style="vertical-align: middle;"><s:a href="upload/%{#document.filename}"><s:property value="#document.filename" /></s:a></td>
<td style="vertical-align: middle;"><s:property value="#document.username" /></td>
<td style="vertical-align: middle;" width="100px"><s:property value="#document.status" /></td>
<td width="200px"><s:if test='#document.status=="待审核"'>
<s:form method="post" action="verify" namespace="/filemgmt"><s:hidden name="mid" value="%{#document.mid}" />
<s:hidden name="username" value="%{#document.username}" /><s:radio list="#{'p':'通过','f':'不通过'}" value="'p'" name="status"/>
<s:submit value="提交" onclick="return confirm('确认你的选择？此操作不能撤销。');"/></s:form></s:if></td>
</tr>
</s:iterator>
</table><s:if test="page != 1"><s:a href="filemgmt/filelist?meetingId=%{meetingId}&page=%{page-1}">上一页</s:a>&nbsp;&nbsp;&nbsp;</s:if>
	第<s:property value="page"/>页/共<s:property value="totalPage"/>页&nbsp;&nbsp;&nbsp;
	<s:if test="page < totalpage"><s:a href="filemgmt/filelist?meetingId=%{meetingId}&page=%{page+1}">下一页</s:a></s:if>
  </body>
</html>
