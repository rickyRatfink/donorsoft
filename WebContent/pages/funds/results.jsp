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
           <td width="90" height="18" background="<%=request.getContextPath() %>/images/searchHeaderBk.png" class="searchFieldHeader">RESIDENT ID</td>
           <td width="3" height="18" background="<%=request.getContextPath() %>/images/searchHeaderSpacer.png"></td>
           <td width="150" height="18" background="<%=request.getContextPath() %>/images/searchHeaderBk.png" class="searchFieldHeader">LAST NAME</td>
           <td width="3" height="18" background="<%=request.getContextPath() %>/images/searchHeaderSpacer.png"></td>
           <td width="50" height="18" background="<%=request.getContextPath() %>/images/searchHeaderBk.png" class="searchFieldHeader">MI</td>
           <td width="3" height="18" background="<%=request.getContextPath() %>/images/searchHeaderSpacer.png"></td>
           <td width="150" height="18" background="<%=request.getContextPath() %>/images/searchHeaderBk.png" class="searchFieldHeader">FIRSTNAME</td>
           <td width="3" height="18" background="<%=request.getContextPath() %>/images/searchHeaderSpacer.png"></td>
           <td width="70" height="18" background="<%=request.getContextPath() %>/images/searchHeaderBk.png" class="searchFieldHeader">SSN</td>
           <td width="3" height="18" background="<%=request.getContextPath() %>/images/searchHeaderSpacer.png"></td>
           <td width="70" height="18" background="<%=request.getContextPath() %>/images/searchHeaderBk.png" class="searchFieldHeader">DOB</td>
           <td width="3" height="18" background="<%=request.getContextPath() %>/images/searchHeaderSpacer.png"></td>
           <td width="100" height="18" background="<%=request.getContextPath() %>/images/searchHeaderBk.png" class="searchFieldHeader">ENTRY DATE</td>
           <td width="3" height="18" background="<%=request.getContextPath() %>/images/searchHeaderSpacer.png"></td>
           <td width="130" height="18" background="<%=request.getContextPath() %>/images/searchHeaderBk.png" class="searchFieldHeader">STATUS</td>
     </tr>
    <logic:notEmpty name="fundsForm" property="fundsList">
    <!-- 
	    <logic:iterate id="loop" name="fundsForm" property="intakeList">
	    <% count++; 
	    String style="Odd";
	    if (count%2==0) style="Even"; %>
	    <tr>
	       <td colspan="2" class="searchFieldResult<%=style%>" align="center"> <a href="<%=request.getContextPath()%>/Intake.do?action=Edit&key=<bean:write name="loop" property="intakeId"/>" style="text-decoration:none;font-size:.95em;"><bean:write name="loop" property="intakeId"/></a></td>
	       <td colspan="2" class="searchFieldResult<%=style%>"><bean:write name="loop" property="lastname"/></td>
	       <td colspan="2" class="searchFieldResult<%=style%>"><bean:write name="loop" property="mi"/></td>
	       <td colspan="2" class="searchFieldResult<%=style%>"><bean:write name="loop" property="firstname"/></td>
	       <td colspan="2" class="searchFieldResult<%=style%>"><bean:write name="loop" property="ssn"/></td>
	       <td colspan="2" class="searchFieldResult<%=style%>"><bean:write name="loop" property="dob"/></td>
	       <td colspan="2" class="searchFieldResult<%=style%>"><bean:write name="loop" property="entryDate"/></td>
	       <td colspan="2" class="searchFieldResult<%=style%>"><bean:write name="loop" property="intakeStatus"/></td>
	   </tr>
	   </logic:iterate>
	    -->
		<tr><td height="3" colspan="16" bgcolor="#b2b3b5"></td></tr>
	</logic:notEmpty>
	<logic:empty name="fundsForm" property="fundsList">
		 <td colspan="16" class="searchFieldResultEven" align="left">No Funds</td>
	</logic:empty>
	</table>
	</div>
	</br>
	</td>
	</tr>
	</table>
	