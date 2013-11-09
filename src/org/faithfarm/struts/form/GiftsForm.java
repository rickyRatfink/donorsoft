package org.faithfarm.struts.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;
import org.faithfarm.domain.GiftPledge;

public class GiftsForm extends ActionForm {

	private GiftPledge gift = new GiftPledge();
	List<GiftPledge>giftList = new ArrayList<GiftPledge>();
	
	String action;
	Long key;
	
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public List<GiftPledge> getGiftList() {
		return giftList;
	}
	public void setGiftList(List<GiftPledge> giftList) {
		this.giftList = giftList;
	}
	public GiftPledge getGift() {
		return gift;
	}
	public void setGift(GiftPledge gift) {
		this.gift = gift;
	}
	public Long getKey() {
		return key;
	}
	public void setKey(Long key) {
		this.key = key;
	}
	
	
	
}
