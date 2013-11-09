<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>  

<html:form action="Gifts.do">
<table width="800" cellpadding="0" cellspacing="0" border="0" style="margin-left:10px;margin-top:10px;">
	<tr>
	<td class="createForm">
		<h2>Create Gift/Pledge</h2>
		<table width="100%" cellpadding="0" cellspacing="0" border="0">
		<tr>
			<td class="formfield">Gift Date</td>
			<td><html:text property="gift.giftDate" size="15" maxlength="10" styleClass="tcal" /></td>
		</tr>
		<tr>
			<td class="formfield">Pledged Amount</td>
			<td><html:text name="giftsForm" property="gift.pledgedAmount" size="15" maxlength="10" styleClass="textbox" onblur="extractNumber(this,2,true);"
 					onkeyup="extractNumber(this,2,true);" onkeypress="return blockNonNumbers(this, event, true, true);"/></td>
		</tr>
		<tr>
			<td class="formfield">Received Amount</td>
			<td><html:text property="gift.receivedAmount" size="15" maxlength="10" styleClass="textbox"  onblur="extractNumber(this,2,true);"
 					onkeyup="extractNumber(this,2,true);" onkeypress="return blockNonNumbers(this, event, true, true);"/></td>
		</tr>
		<tr>
			<td class="formfield">Non-Deductible</td>
			<td><html:text  property="gift.nonDeductibleAmount" size="15" maxlength="10" styleClass="textbox" onblur="extractNumber(this,2,true);"
 					onkeyup="extractNumber(this,2,true);" onkeypress="return blockNonNumbers(this, event, true, true);"/></td>
		</tr>
		<tr>
			<td class="formfield">Gift Type</td>
			<td>
				<html:select  property="gift.giftType.giftTypeId" styleClass="select" >
					<html:option value="">Select</html:option>
					<html:optionsCollection name="ddl_giftType" value="giftTypeId" label="name" />
				</html:select>
			</td>
		</tr>
		<tr>
			<td class="formfield">Receipt</td>
			<td><html:text name="giftsForm" property="gift.receipt" size="30" maxlength="30" styleClass="textbox" /></td>
		</tr>
		<tr>
			<td class="formfield">Note</td>
			<td><html:textarea name="giftsForm" property="gift.note" styleClass="textarea" /></td>
		</tr>
		
		</table>
		<table width="100%" cellpadding="0" cellspacing="0" border="0">
		<tr>
			<td align="center" style="padding-bottom: 20px;padding-top: 20px;">
				<html:submit property="action" value="Save" styleClass="button"/>
				<logic:equal name="giftsForm" property="action" value="Edit">
					<logic:equal name="loginForm" property="systemUser.userRole" value="Administrator">
								<html:submit property="action" value="Delete" styleClass="button"/>
					</logic:equal>
				</logic:equal>
			</td>
		</tr>
		</table>
	</tr>
</table>
</html:form>
