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
import org.apache.struts.action.ActionRedirect;
import org.faithfarm.domain.Constants;
import org.faithfarm.domain.ErrorMessage;
import org.faithfarm.domain.SystemUser;
import org.faithfarm.hibernate.dao.SystemUserDao;
import org.faithfarm.struts.form.LoginForm;
import org.faithfarm.utils.HtmlDropDownBuilder;
import org.faithfarm.utils.Validator;


public class DonorsAction extends Action {
	
	private final static Logger LOGGER = Logger.getLogger(LoginAction.class.getName());
	private final static HtmlDropDownBuilder html = new HtmlDropDownBuilder();
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {		
		LOGGER.setLevel(Level.INFO);

		 HttpSession session = request.getSession(true);
		 String action = request.getParameter("action");
		 LoginForm loginForm = (LoginForm)form;
		 
		 LOGGER.log(Level.INFO, "In login action..."+loginForm.getSystemUser().getUsername());
	
		 return mapping.findForward(Constants.LOGIN);
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
