<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>


<table width="1000" cellpadding="0" cellspacing="0" border="0" style="margin-left:10px;margin-top:10px;">
	<tr>
	<td class="createForm">
		<h2>Funds Listing</h2>
		
<% int count=0; %>
  
  <div class="grid">
     <table width="900" cellpadding="0" cellspacing="0" border="0">
     <tr>
           <td width="5" height="18" background="<%=request.getContextPath() %>/images/searchHeaderBk.png" class="searchFieldHeader"></td>
           <td width="90" height="18" background="<%=request.getContextPath() %>/images/searchHeaderBk.png" class="searchFieldHeader">FUND ID</td>
           <td width="1" height="18" background="<%=request.getContextPath() %>/images/searchHeaderSpacer.png"></td>
           <td width="650" height="18" background="<%=request.getContextPath() %>/images/searchHeaderBk.png" class="searchFieldHeader">NAME</td>
           <td width="1" height="18" background="<%=request.getContextPath() %>/images/searchHeaderSpacer.png"></td>
           <td width="50" height="18" background="<%=request.getContextPath() %>/images/searchHeaderBk.png" class="searchFieldHeader">ENABLED</td>
     </tr>
    <logic:notEmpty name="fundsForm" property="fundList">
    
	    <logic:iterate id="loop" name="fundsForm" property="fundList">
	    <% count++; 
	    String style="Odd";
	    if (count%2==0) style="Even"; %>
	    <tr>
	       <td colspan="2" class="searchFieldResult<%=style%>" align="center"> <a href="<%=request.getContextPath()%>/Intake.do?action=Edit&key=<bean:write name="loop" property="fundId"/>" style="text-decoration:none;font-size:.95em;"><bean:write name="loop" property="fundId"/></a></td>
	       <td colspan="2" class="searchFieldResult<%=style%>"><bean:write name="loop" property="name"/></td>
	       <td colspan="2" class="searchFieldResult<%=style%>"><bean:write name="loop" property="enabled"/></td>
	    </tr>
	   </logic:iterate>
	    
		<tr><td height="3" colspan="16" bgcolor="#b2b3b5"></td></tr>
	</logic:notEmpty>
	<logic:empty name="fundsForm" property="fundList">
		 <td colspan="16" class="searchFieldResultEven" align="left">No Funds</td>
	</logic:empty>
	</table>
	</div>
	</br>
	</td>
	</tr>
	</table>
	