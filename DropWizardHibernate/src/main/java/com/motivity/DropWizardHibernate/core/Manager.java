package com.motivity.DropWizardHibernate.core;

import java.security.Principal;

public class Manager implements Principal{

	private String managerName;
	private String managerPassword;

	public Manager() {
		super();
	}

	public Manager(String managerName, String managerPassword) {
		super();
		this.managerName = managerName;
		this.managerPassword = managerPassword;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerPassword() {
		return managerPassword;
	}

	public void setManagerPassword(String managerPassword) {
		this.managerPassword = managerPassword;
	}

	@Override
	public String getName() {
		return null;
	}

}
