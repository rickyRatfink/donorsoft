<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>  

<table  cellpadding="0" cellspacing="0" border="0" style="margin-left:10px;margin-top:10px;">
	<tr>
	<td class="linkmenu">
		<logic:notEqual name="fundsForm" property="action" value="New Fund">
			<a href="<%=request.getContextPath() %>/Funds.do?action=New Fund" style="text-decoration:none;"><b>New Fund</b></a>
		</logic:notEqual>
		<logic:equal name="fundsForm" property="action" value="New Fund">
			<a href="#" style="text-decoration:none;color:#e4e4e4;">New Fund</a>
		</logic:equal>
		&nbsp;|&nbsp;
		<logic:notEqual name="fundsForm" property="action" value="Show Disabled Funds">
			<a href="<%=request.getContextPath() %>/Funds.do?action=Show Disabled Funds" style="text-decoration:none;"><b>Show Disabled Funds</b></a>
		</logic:notEqual>
		<logic:equal name="fundsForm" property="action" value="Show Disabled Funds">
			<a href="#" style="text-decoration:none;color:#e4e4e4;">Show Disabled Funds</a>
		</logic:equal>
		&nbsp;|&nbsp;
		<logic:notEqual name="fundsForm" property="action" value="Enable All">
			<a href="<%=request.getContextPath() %>/Funds.do?action=Enable All" style="text-decoration:none;"><b>Enable All</b></a>
		</logic:notEqual>
		<logic:equal name="fundsForm" property="action" value="Enable All">
			<a href="#" style="text-decoration:none;color:#e4e4e4;">Enable All</a>
		</logic:equal>
		&nbsp;|&nbsp;
		<logic:notEqual name="fundsForm" property="action" value="Disable All">
			<a href="<%=request.getContextPath() %>/Funds.do?action=Disable All" style="text-decoration:none;"><b>Disable All</b></a>
		</logic:notEqual>
		<logic:equal name="fundsForm" property="action" value="Disable All">
			<a href="#" style="text-decoration:none;color:#e4e4e4;">Disable All</a>
		</logic:equal>
		&nbsp;|&nbsp;
		<logic:notEqual name="fundsForm" property="action" value="Funds Report">
			<a href="<%=request.getContextPath() %>/Funds.do?action=Funds Report" style="text-decoration:none;"><b>Funds Report</b></a>
		</logic:notEqual>
		<logic:equal name="fundsForm" property="action" value="Funds Report">
			<a href="#" style="text-decoration:none;color:#e4e4e4;">Funds Report</a>
		</logic:equal>
		&nbsp;|&nbsp;
		<logic:notEqual name="fundsForm" property="action" value="Save Fund Order">
			<a href="<%=request.getContextPath() %>/Funds.do?action=Save Fund Order" style="text-decoration:none;"><b>Save Fund Order</b></a>
		</logic:notEqual>
		<logic:equal name="fundsForm" property="action" value="Save Fund Order">
			<a href="#" style="text-decoration:none;color:#e4e4e4;">Save Fund Order</a>
		</logic:equal>
		

	</td>
	</tr>
</table>