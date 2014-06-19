package com.goo.training.ssh.jbs.account.action;

import com.goo.training.ssh.jbs.account.model.User;
import com.goo.training.ssh.jbs.account.service.UserAlreadyExistsException;
import com.goo.training.ssh.jbs.account.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {
	private static final long serialVersionUID = 7021982816578678150L;

	private User user;

	private UserService userService;

	public String execute() throws Exception {
		try {
			userService.addUser(user);
		} catch (UserAlreadyExistsException e) {
			return INPUT;
		}
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
