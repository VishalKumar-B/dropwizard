package com.motivity.DropWizardHibernate;

import java.io.File;
import java.io.IOException;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;

public class TemplateConfigurationContext {

	private static Configuration configuration = new Configuration(Configuration.VERSION_2_3_27);

	public static Configuration getConfiguration() {
		try {
			configuration.setDirectoryForTemplateLoading(new File("src/main/resources/assets/"));
			configuration.setDefaultEncoding("UTF-8");
			configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
			configuration.setLogTemplateExceptions(false);
			configuration.setWrapUncheckedExceptions(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return configuration;
	}
}
