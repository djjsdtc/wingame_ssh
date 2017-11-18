<%@ page language="java" pageEncoding="UTF-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title><s:property value="result.id.MTitle"/> - Windows 小游戏研究学会</title>
    <base href=<%=basePath%> >
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <script>
function showAnnounce(){
	var meetingId = document.getElementById("meetingId").value;
	document.getElementById("annlist").src = "announcement/annlist?meetingId=" + meetingId;
}
    </script>
  </head>
  <body> <table id="pagetable" align="center">
<tbody><tr>
<td id="top" colspan="2" align="center"><jsp:include page="../jsp_public/head.jsp"></jsp:include><br></td>
			</tr>
<tr>
<td id="sidebar"><s:action name="sidebar" namespace="/" executeResult="true"><s:param name="redirect"><s:url includeParams="get" includeContext="false"/></s:param></s:action></td>
<td id="context"><s:if test="message!=null"><table border="1" bgcolor="yellow"><tr><td>
	<s:property value="message"/></td></tr></table></s:if>
会议详情<br><hr>
<s:action name="permissionButton" namespace="/" executeResult="true">
	<s:param name="requiredPerm">a</s:param>
	<s:param name="id"><s:property value="result.id.MId"/></s:param>
	<s:param name="type">meeting</s:param>
</s:action>
会议名称：<s:property value="result.id.MTitle" /><br>
会议地点：<s:property value="result.id.MAddress" /><br>
会议时间：<s:date name="result.id.MDatetime" /><br>
参会费用：<s:property value="result.id.MFee" />元<br>
预报名人数：<s:property value="result.id.MAttend" /><br>
<s:action name="permissionLink" namespace="/" executeResult="true">
	<s:param name="requiredPerm">a</s:param>
	<s:param name="href">meeting/getTable?mid=<s:property value="result.id.MId"/></s:param>
	<s:param name="text">下载已报名用户列表（Excel 2003 文件格式）</s:param>
</s:action><br>
参加本次会议需要您上传本次会议公告中所提到的有关材料，材料上传截止时间为：
<s:date name="result.id.MDeadline" />。<br>材料审核通过后，您可以进行会议预报名。
<s:action name="attended" namespace="/meeting" executeResult="true">
	<s:param name="meetingId"><s:property value="result.id.MId"/></s:param>
</s:action>
<br><br>会议有关公告：<br>
<s:hidden id="meetingId" value="%{result.id.MId}"/>
<iframe id="annlist" frameborder="0" src="" width="100%" height="300px"></iframe>
<script>showAnnounce();</script>
</td></tr>
<tr>
<td colspan="2"><jsp:include page="../jsp_public/foot.jsp"></jsp:include></td>
</tr>
</tbody></table></body>
</html>
