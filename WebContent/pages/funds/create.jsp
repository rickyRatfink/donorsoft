<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>  



<table width="800" cellpadding="0" cellspacing="0" border="0" style="margin-left:10px;margin-top:10px;">
	<tr>
	<td class="createForm">
		<h2>Create New Fund</h2>
		<table width="100%" cellpadding="0" cellspacing="0" border="0">
		<tr>
			<td class="field">Fund Name</td>
			<td class="field">Attribute1</td>
			<td class="field">Attribute2</td>
			<td class="field">Attribute3</td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		</table>
		<table width="100%" cellpadding="0" cellspacing="0" border="0">
		<tr>
			<td align="left" style="padding-bottom: 20px;padding-top: 20px;"><html:submit property="action" value="Save" styleClass="button"/></td>
		</tr>
		</table>
	</tr>
</table>
