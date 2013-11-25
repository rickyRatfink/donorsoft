<%@page import="org.faithfarm.domain.SystemUser"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>  
<% 
   SystemUser user = (SystemUser)session.getAttribute("system_user");
   if (user==null)
	   user=new SystemUser();
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/menu.css" media="screen">
<link href="<%=request.getContextPath()%>/css/tcal.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/script/tcal.js"></script>
<script src="<%=request.getContextPath()%>/script/accounting.js"></script>
  
<title>Donorsoft</title>

<script type="text/javascript">


function isNumberKey(evt)
{
   var charCode = (evt.which) ? evt.which : event.keyCode
   if (charCode > 31 && (charCode < 48 || charCode > 57))
      return false;

   return true;
}


function submitForm(action, key) {
	document.getElementById("action").value=action;
	document.getElementById("key").value=key;
	document.forms[0].submit();
}
</script>

</head>

<body>

<div id="footer">

	<table width="100%" cellpadding="0" cellspacing="0" border="0">
	<tr>
	<td width="100%" background="<%=request.getContextPath() %>/images/footer_bg.png">
		<div id="item">Organization:&nbsp;&nbsp;&nbsp;</div><div id="itemValue">Faith Farm Ministries</div>
		<div id="item">User Name:&nbsp;&nbsp;&nbsp;</div><div id="itemValue">
			<%=user.getUsername() %>
		</div>
		<div id="item">System Date:&nbsp;&nbsp;&nbsp;</div><div id="itemValue"><%= new java.util.Date() %></div>
		
	</td>
	<td align="right" background="<%=request.getContextPath() %>/images/footer_bg.png"><a href="<%=request.getContextPath() %>/Login.do?action=logout" style="font: .70em bold 'Arial';'">[logout]</a>&nbsp;</td>
	<td alight="right"  background="<%=request.getContextPath() %>/images/footer_bg.png"><img src="<%=request.getContextPath() %>/images/flags.png"/></td>
	</tr>
	</table>
	
</div>

<!-- 
<div id="preheader" align="right" style="padding-top:5px;">
	<img src="<%=request.getContextPath() %>/images/flags.png"/>
</div>
 -->

<div id="header">
	<div id="logo" align="right"><img src="<%=request.getContextPath() %>/images/globe.png" /></div>
</div>


<table width="100%" cellpadding="0" cellspacing="0" border="0">
<tr>
<td width="800">
<ul class="menu">
	<li id="FO"><a href="#" >Accounts</a></li>
	<li><a href="<%=request.getContextPath()%>/Funds.do?action=">Funds</a></li>
	<li><a href="<%=request.getContextPath()%>/Campaigns.do?action=">Campaigns</a></li> 
	<li><a href="#">Approaches</a></li> 
	<li><a href="<%=request.getContextPath()%>/Gifts.do?action=">Gifts/Pledges</a></li> 
	<li><a href="#">Communications</a></li>
	<li><a href="#">Reports</a></li> 
</ul> 
</td>
<td bgcolor="#ffffff" width="100%" style="border-left: 1px solid #6f9dd9;"></td>
</tr>
</table>


<table width="100%" cellpadding="0" cellspacing="0" border="0">
<tr>
	<td width="100%" bgcolor="6f9dd9" height="1"></td>
</tr>

</table>


