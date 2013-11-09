<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>  

<jsp:include page="../../includes/header.jsp"/>


<html:form action="Gifts.do">
<table width="100%" cellpadding="0" cellspacing="0" border="0">
	<tr>
		<td width="100%" align="left" valign="top" class="mainBkgr" >
			<div id="boxContent"> 
				<div id="breadcrumb">
					&nbsp;&nbsp;Home > Gifts/Pledges
				</div>
				
				
				<table width="100%" height="550" cellpadding="0" cellspacing="0" border="0">
				<tr>
				<td width="100%"  valign="top" background="<%=request.getContextPath()%>/images/mainbg.jpg">
					<jsp:include page="../../includes/messages.jsp" flush="true"/>
					<jsp:include page="menu.jsp" flush="true" />
					<logic:equal name="giftsForm" property="action" value="New Gift">
						<jsp:include page="create.jsp" flush="true" />
					</logic:equal>
					<logic:equal name="giftsForm" property="action" value="Edit">
						<jsp:include page="create.jsp" flush="true" />
					</logic:equal>
					<logic:empty name="giftsForm" property="action">
						<jsp:include page="results.jsp" flush="true" />
					</logic:empty>
				</td>
				</tr>
				</table>
				
			</div>
		</td>
	</tr>
</table>
</html:form>

<jsp:include page="../../includes/footer.jsp"/>

