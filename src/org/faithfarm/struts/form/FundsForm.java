package org.faithfarm.struts.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;
import org.faithfarm.domain.Funds;

public class FundsForm extends ActionForm {

	List<Funds> fundsList = new ArrayList<Funds>();
	
	String action;

	
	public List<Funds> getFundsList() {
		return fundsList;
	}

	public void setFundsList(List<Funds> fundsList) {
		this.fundsList = fundsList;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	
	
}
