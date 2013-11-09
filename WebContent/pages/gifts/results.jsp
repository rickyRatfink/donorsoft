<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>




<table width="1000" cellpadding="0" cellspacing="0" border="0" style="margin-left:10px;margin-top:10px;">
	<tr>
	<td class="createForm">
		<h2>Gifts Listing</h2>
		
<% int count=0; %>
  
  <html:form method="POST" action="/Gifts.do" > 
  
  <div class="grid">
     <table width="900" cellpadding="0" cellspacing="0" border="0">
     <tr>
           <td width="5" height="18" background="<%=request.getContextPath() %>/images/searchHeaderBk.png" class="searchFieldHeader"></td>
           <td width="90" height="18" background="<%=request.getContextPath() %>/images/searchHeaderBk.png" class="searchFieldHeader">GIFT ID</td>
           <td width="3" height="18" background="<%=request.getContextPath() %>/images/searchHeaderSpacer.png"></td>
           <td width="150" height="18" background="<%=request.getContextPath() %>/images/searchHeaderBk.png" class="searchFieldHeader">DATE</td>
           <td width="3" height="18" background="<%=request.getContextPath() %>/images/searchHeaderSpacer.png"></td>
           <td width="50" height="18" background="<%=request.getContextPath() %>/images/searchHeaderBk.png" class="searchFieldHeader">PLEDGED</td>
           <td width="3" height="18" background="<%=request.getContextPath() %>/images/searchHeaderSpacer.png"></td>
           <td width="150" height="18" background="<%=request.getContextPath() %>/images/searchHeaderBk.png" class="searchFieldHeader">RECEIVED</td>
           <td width="3" height="18" background="<%=request.getContextPath() %>/images/searchHeaderSpacer.png"></td>
           <td width="70" height="18" background="<%=request.getContextPath() %>/images/searchHeaderBk.png" class="searchFieldHeader">NON-DEDUCTIBLE</td>
           <td width="3" height="18" background="<%=request.getContextPath() %>/images/searchHeaderSpacer.png"></td>
           <td width="70" height="18" background="<%=request.getContextPath() %>/images/searchHeaderBk.png" class="searchFieldHeader">GIFT TYPE</td>
    </tr>
    <logic:notEmpty name="giftsForm" property="giftList">
        <logic:iterate id="loop" name="giftsForm" property="giftList">
	    <% count++; 
	    String style="Odd";
	    if (count%2==0) style="Even"; %>
	    <tr>
	       <td colspan="2" class="searchFieldResult<%=style%>" align="center"> 
                 <a style="text-decoration:none;font-size:.95em;" href="javascript:submitForm('Edit','<bean:write name="loop" property="giftPledgeId"/>');"><bean:write name="loop" property="giftPledgeId"/></a>
           </td>
	       <td colspan="2" class="searchFieldResult<%=style%>"><bean:write name="loop" property="giftDate"/></td>
	       <td colspan="2" class="searchFieldResult<%=style%>"><bean:write name="loop" property="pledgedAmount" format="$###,#####.00"/></td>
	       <td colspan="2" class="searchFieldResult<%=style%>"><bean:write name="loop" property="receivedAmount" format="$###,#####.00#"/></td>
	       <td colspan="2" class="searchFieldResult<%=style%>"><bean:write name="loop" property="nonDeductibleAmount" format="$###,#####.00#"/></td>
	       <td colspan="2" class="searchFieldResult<%=style%>"><bean:write name="loop" property="giftType.name" format="$###,#####.00"/></td>
	   </tr>
	   </logic:iterate>
	   <tr><td height="3" colspan="16" bgcolor="#b2b3b5"></td></tr>
	</logic:notEmpty>
	<logic:empty name="giftsForm" property="giftList">
		 <td colspan="16" class="searchFieldResultEven" align="left">No Funds</td>
	</logic:empty>
	</table>
	</div>
	
	<html:hidden property="action" value="" styleId="action" />
    <html:hidden property="key" value="" styleId="key" />
	
	</html:form>
	
	
	</br>
	</td>
	</tr>
	</table>
	