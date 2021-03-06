package com.goo.training.ssh.jbs.account.action;

import com.goo.training.ssh.jbs.account.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport {
	private static final long serialVersionUID = -518996422060716751L;

	public String execute() throws Exception {
		ActionContext.getContext().getSession().remove(User.SESSION_KEY);
		return SUCCESS;
	}
}
