package com.motivity.DropWizardHibernate;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

public class DropWizardHibernateConfiguration extends Configuration {
    
	@NotNull
	@Valid
	@JsonProperty("database")
	private DataSourceFactory dataSourceFactory = new DataSourceFactory();

	public DataSourceFactory getDataSourceFactory() {
		return dataSourceFactory;
	}
	
}
