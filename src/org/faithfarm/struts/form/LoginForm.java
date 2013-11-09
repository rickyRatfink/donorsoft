package org.faithfarm.struts.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;
import org.faithfarm.domain.ErrorMessage;
import org.faithfarm.domain.SystemUser;

public class LoginForm  extends ActionForm {

	private SystemUser user = new SystemUser();
	private SystemUser systemUser = new SystemUser();
	private List<SystemUser> userList = new ArrayList<SystemUser>();
	private List<ErrorMessage> messages = new ArrayList<ErrorMessage>();
    private String messageType;
	
	public SystemUser getSystemUser() {
		return systemUser;
	}

	public void setSystemUser(SystemUser systemUser) {
		this.systemUser = systemUser;
	}

	
	public SystemUser getUser() {
		return user;
	}

	public void setUser(SystemUser user) {
		this.user = user;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public List<ErrorMessage> getMessages() {
		return messages;
	}

	public void setMessages(List<ErrorMessage> messages) {
		this.messages = messages;
	}

	public List<SystemUser> getUserList() {
		return userList;
	}

	public void setUserList(List<SystemUser> userList) {
		this.userList = userList;
	}

	/*
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		  ActionErrors errors = new ActionErrors();
		  if ((this.systemUser.getUsername()==null) || (this.systemUser.getUsername().length() < 1)) 
		      errors.add("",new ActionMessage("errors.required","username"));
		  if ((this.systemUser.getPassword()==null) || (this.systemUser.getPassword().length() < 1)) 
		      errors.add("", new ActionMessage("errors.required","password"));
		  
		  	 
		  return errors;
		}
		*/
}
