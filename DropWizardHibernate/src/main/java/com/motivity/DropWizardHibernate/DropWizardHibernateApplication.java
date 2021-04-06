package com.motivity.DropWizardHibernate;

import com.motivity.DropWizardHibernate.auth.ManagerAuthentication;
import com.motivity.DropWizardHibernate.core.Employee;
import com.motivity.DropWizardHibernate.core.Manager;
import com.motivity.DropWizardHibernate.db.EmployeeDAO;
import com.motivity.DropWizardHibernate.health.DatabaseHealthCheck;
import com.motivity.DropWizardHibernate.resources.EmployeeResource;
import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DropWizardHibernateApplication extends Application<DropWizardHibernateConfiguration> {

	public static void main(final String[] args) throws Exception {
		new DropWizardHibernateApplication().run(args);
	}

	@Override
	public String getName() {
		return "DropWizardHibernate";
	}

	private final HibernateBundle<DropWizardHibernateConfiguration> hibernate = new HibernateBundle<DropWizardHibernateConfiguration>(
			Employee.class) {

		@Override
		public DataSourceFactory getDataSourceFactory(DropWizardHibernateConfiguration configuration) {
			return configuration.getDataSourceFactory();
		}
	};

	@Override
	public void initialize(final Bootstrap<DropWizardHibernateConfiguration> bootstrap) {
		bootstrap.addBundle(hibernate);
	}

	@Override
	public void run(final DropWizardHibernateConfiguration configuration, final Environment environment) {

		final EmployeeDAO employeeDAO = new EmployeeDAO(hibernate.getSessionFactory());
		final EmployeeResource employeeResource = new EmployeeResource(employeeDAO);
		final DatabaseHealthCheck healthCheck = new DatabaseHealthCheck(configuration.getDataSourceFactory());
		
		
		environment.jersey().register(new AuthDynamicFeature(new BasicCredentialAuthFilter.Builder<Manager>()
        		.setAuthenticator(new ManagerAuthentication(new Manager("abc","abc")))
        		.setRealm("BASIC-AUTH-REALM")
        		.buildAuthFilter()));
		
		environment.healthChecks().register("database", healthCheck);
		environment.jersey().register(employeeResource);
	}

}
