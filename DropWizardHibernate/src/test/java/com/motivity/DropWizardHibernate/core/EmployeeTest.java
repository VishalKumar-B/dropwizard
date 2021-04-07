package com.motivity.DropWizardHibernate.core;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;

class EmployeeTest {

	private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

	@Test
	public void serializesToJSON() throws Exception {
		final Employee employee = new Employee("1", "abc", "1234");

		final String expected = MAPPER
				.writeValueAsString(MAPPER.readValue(fixture("fixtures/Employee.json"), Employee.class));

		assertThat(MAPPER.writeValueAsString(employee)).isEqualTo(expected);
	}

	@Test
	public void deserializesFromJSON() throws Exception {
		final Employee employee = new Employee("1", "abc", "1234");
		assertThat(MAPPER.readValue(fixture("fixtures/Employee.json"), Employee.class).getId()).isEqualTo(employee.getId());
		assertThat(MAPPER.readValue(fixture("fixtures/Employee.json"), Employee.class).getName()).isEqualTo(employee.getName());
		assertThat(MAPPER.readValue(fixture("fixtures/Employee.json"), Employee.class).getMobileNumber()).isEqualTo(employee.getMobileNumber());
	}

}
