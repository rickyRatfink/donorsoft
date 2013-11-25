package org.faithfarm.struts.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;
import org.faithfarm.domain.Campaign;

public class CampaignForm extends ActionForm {

		private Campaign campaign=new Campaign();
		private List<Campaign> campaignList = new ArrayList<Campaign>();
		private String action;
		
		public Campaign getCampaign() {
			return campaign;
		}
		public void setCampaign(Campaign campaign) {
			this.campaign = campaign;
		}
		public List<Campaign> getCampaignList() {
			return campaignList;
		}
		public void setCampaignList(List<Campaign> campaignList) {
			this.campaignList = campaignList;
		}
		public String getAction() {
			return action;
		}
		public void setAction(String action) {
			this.action = action;
		}
		
		
}
