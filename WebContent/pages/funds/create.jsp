<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>  



<table width="800" cellpadding="0" cellspacing="0" border="0" style="margin-left:10px;margin-top:10px;">
	<tr>
	<td class="createForm">
		<h2>Create New Fund</h2>
		<table width="100%" cellpadding="0" cellspacing="0" border="0">
		<tr>
			<td class="field">Name</td>
			<td><html:text property="fund.name" size="40" maxlength="80" styleClass="textbox" /></td>
		</tr>
		<tr>
			<td class="field">Description</td>
			<td><html:textarea property="fund.description" cols="1" rows="1" styleClass="textarea" /></br></br></td>
		</tr>
		<tr>
			<td class="field">Cash Account</td>
			<td><html:text property="fund.cashAccount" size="20" maxlength="20" styleClass="textbox" /></td>
		</tr>
		<tr>
			<td class="field">Receivables Account</td>
			<td><html:text property="fund.receivablesAccount" size="20" maxlength="20" styleClass="textbox" /></td>
		</tr>
		<tr>
			<td class="field">Revenue Account</td>
			<td><html:text property="fund.revenueAccount" size="20" maxlength="20" styleClass="textbox" /></td>
		</tr>
		
		</table>
		<table width="100%" cellpadding="0" cellspacing="0" border="0">
		<tr>
			<td align="left" style="padding-bottom: 20px;padding-top: 20px;"><html:submit property="action" value="Save" styleClass="button"/></td>
		</tr>
		</table>
	</tr>
</table>
