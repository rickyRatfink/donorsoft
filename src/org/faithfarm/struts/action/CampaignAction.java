package org.faithfarm.struts.action;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.faithfarm.domain.Constants;
import org.faithfarm.domain.ErrorMessage;
import org.faithfarm.domain.SystemUser;
import org.faithfarm.hibernate.dao.CampaignDao;
import org.faithfarm.struts.form.CampaignForm;
import org.faithfarm.struts.form.LoginForm;
import org.faithfarm.utils.HtmlDropDownBuilder;


public class CampaignAction extends Action {
	
	private final static Logger LOGGER = Logger.getLogger(LoginAction.class.getName());
	private final static HtmlDropDownBuilder html = new HtmlDropDownBuilder();
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {		
		LOGGER.setLevel(Level.SEVERE);

		 HttpSession session = request.getSession(true);
		 SystemUser user = (SystemUser) session.getAttribute("USER_"
					+ session.getId());
		 
			try {

				String action = request.getParameter("action");
				CampaignForm campaignForm = (CampaignForm)form;
				
				if (user == null)
					return mapping.findForward(Constants.LOGIN);

				CampaignDao dao = new CampaignDao();
				campaignForm.setCampaignList(dao.listCampaigns());
				
				if ("Save".equals(campaignForm.getAction())) {
					dao.addCampaign(campaignForm.getCampaign());
					campaignForm.setCampaignList(dao.listCampaigns());
					campaignForm.setAction(null);
				}
				return mapping.findForward(Constants.SUCCESS);
			} 	
			catch (Exception e) {
				StringWriter sw = new StringWriter();
				PrintWriter pw = new PrintWriter(sw);
				e.printStackTrace(pw);			
				session.setAttribute("SYSTEM_ERROR", sw.toString());
				e.printStackTrace();
				return mapping.findForward(Constants.ERROR);
			}
	}
	

	
}
