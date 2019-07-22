
package org.springframework.hateoas.examples;

import lombok.Value;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@Value
@JsonPropertyOrder({ "id", "name", "role", "manager" })
public class EmployeeWithManager {

	@JsonIgnore private final Employee employee;

	public Long getId() {

		return this.employee.getId() //
				.orElseThrow(() -> new RuntimeException("Couldn't find anything."));
	}

	public String getName() {
		return this.employee.getName();
	}

	public String getRole() {
		return this.employee.getRole();
	}

	public String getManager() {
		return this.employee.getManager().getName();
	}

}
