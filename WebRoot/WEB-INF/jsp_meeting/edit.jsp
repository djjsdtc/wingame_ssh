<%@ page language="java" pageEncoding="UTF-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>创建或修改会议 - Windows 小游戏研究学会</title>
    <base href=<%=basePath%> >
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <sx:head locale="en"/>
  </head>
  <body> <table id="pagetable" align="center">
<tbody><tr>
<td id="top" colspan="2" align="center"><jsp:include page="../jsp_public/head.jsp"></jsp:include><br></td></tr>
<tr><td id="sidebar"><s:action name="sidebar" namespace="/" executeResult="true"><s:param name="redirect"><s:url includeParams="get" includeContext="false"/></s:param></s:action></td>
<td id="context"><s:if test="result != null">
<s:set name="title" scope="action" value="%{result.MTitle}" />
<s:set name="address" scope="action" value="%{result.MAddress}" />
<s:set name="datetime" scope="action" value="%{result.MDatetime}" />
<s:set name="fee" scope="action" value="%{result.MFee}" />
<s:set name="deadline" scope="action" value="%{result.MDeadline}" />
</s:if><s:else><s:set name="datetime" scope="action" value="%{'today'}" />
<s:set name="deadline" scope="action" value="%{'today'}" /></s:else>
<s:set name="id" scope="session" value="%{#parameters['id']}" id="id" />
创建或修改会议<br><s:form action="changeMeeting" namespace="/meeting"><br>
会议名称：<s:textfield name="title" size="50" value="%{title}" /><br>
会议地址：<s:textfield name="address" size="50" value="%{address}" /><br>
会议时间：<sx:datetimepicker  name="date" displayFormat="yyyy-MM-dd" value="%{datetime}"/>
<sx:datetimepicker name="time" type="time" displayFormat="HH:mm:ss" value="%{datetime}"/><br>
会议费用：<s:textfield name="fee" value="%{fee}" />元<br>
<s:fielderror fieldName="fee" cssClass="errorinfo" />
文档上传截止时间：<sx:datetimepicker name="deadline" displayFormat="yyyy-MM-dd" value="%{deadline}"/>（不含）<br><br>
<s:submit value="确认" />&nbsp;&nbsp;&nbsp;
<s:reset value="清空" onclick="return confirm('确定要清空吗？');" />&nbsp;&nbsp;&nbsp;
<input type="button" value="返回" onclick="window.history.back()">
</s:form><br>
  </td></tr>
<tr>
<td colspan="2"><br><jsp:include page="../jsp_public/foot.jsp"></jsp:include><br></td>
</tr>
</tbody></table></body>
</html>
