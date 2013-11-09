package org.faithfarm.struts.action;

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
import org.faithfarm.domain.GiftPledge;
import org.faithfarm.domain.GiftType;
import org.faithfarm.domain.SystemUser;
import org.faithfarm.hibernate.dao.GiftPledgeDao;
import org.faithfarm.hibernate.dao.GiftTypeDao;
import org.faithfarm.struts.form.GiftsForm;
import org.faithfarm.struts.form.LoginForm;
import org.faithfarm.utils.HtmlDropDownBuilder;


public class GiftsAction extends Action {
	
	private final static Logger LOGGER = Logger.getLogger(LoginAction.class.getName());
	private final static HtmlDropDownBuilder html = new HtmlDropDownBuilder();
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {		
		LOGGER.setLevel(Level.INFO);

		 HttpSession session = request.getSession(true);
		 SystemUser user = (SystemUser) session.getAttribute("USER_"+session.getId());
		 if (user==null)
			 return mapping.findForward(Constants.LOGIN);
		 
		 GiftsForm giftForm = (GiftsForm)form;
		 GiftPledgeDao dao = new GiftPledgeDao();
		 GiftTypeDao typeDao = new GiftTypeDao();
		 
		 giftForm.setGiftList(dao.listGiftPledges());
		 System.out.println (">"+giftForm.getAction());
		 if ("New Gift".equals(giftForm.getAction()))
			 giftForm.setGift(new GiftPledge());
		 if ("Save".equals(giftForm.getAction())) {
			 dao.addGiftPledge(giftForm.getGift());
			 giftForm.setAction(null);
		 }
		 if ("Edit".equals(giftForm.getAction())) {
			 GiftPledge gift = dao.findById(giftForm.getKey());
			 giftForm.setGift(gift);
		 }
		 if ("Delete".equals(giftForm.getAction())) {
			 dao.deleteGiftPledge(giftForm.getKey());
			 giftForm.setGiftList(dao.listGiftPledges());
			 giftForm.setAction(null);
		 }
		 
		 LOGGER.log(Level.INFO, "In giftAction action..."+user.getUsername());
		 return mapping.findForward(Constants.SUCCESS);
	}
	
	public boolean validate(LoginForm loginForm) {
		  List<ErrorMessage> messages = new ArrayList<ErrorMessage>();
		  ActionErrors errors = new ActionErrors();
		  
		  if ((loginForm.getSystemUser().getUsername()==null) || (loginForm.getSystemUser().getUsername().length() < 1)) 
		     	messages.add(new ErrorMessage("username is required",""));
		  if ((loginForm.getSystemUser().getPassword()==null) || (loginForm.getSystemUser().getPassword().length() < 1)) 
			    messages.add(new ErrorMessage("password is required",""));
		  
		  if (messages.size()>0) {
			  loginForm.setMessages(messages); 	 
			  return false;
		  }
		  else
			  return true;
		}
	
}
