package com.motivity.DropWizardHibernate.auth;

import java.util.Optional;
import com.motivity.DropWizardHibernate.core.Manager;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;

public class ManagerAuthentication implements Authenticator<BasicCredentials, Manager> {

	Manager manager;
	
	public ManagerAuthentication(Manager manager) {
		this.manager = manager;
	}
	
	@Override
	public Optional<Manager> authenticate(BasicCredentials credentials) throws AuthenticationException {
		if (manager.getManagerName().equals(credentials.getUsername())
				&& manager.getManagerPassword().equals(credentials.getPassword())) {
			return Optional.of(new Manager());
		} else {
			return Optional.empty();
		}
	}
}
