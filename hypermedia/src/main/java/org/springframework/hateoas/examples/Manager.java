
package org.springframework.hateoas.examples;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Data
@Entity
@NoArgsConstructor
class Manager {

	@Id @GeneratedValue private Long id;
	private String name;

	
	@JsonIgnore //
	@OneToMany(mappedBy = "manager") //
	private List<Employee> employees = new ArrayList<>();

	Manager(String name) {
		this.name = name;
	}

	public Optional<Long> getId() {
		return Optional.ofNullable(this.id);
	}
}
