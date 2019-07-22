
package org.springframework.hateoas.examples;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.SimpleIdentifiableRepresentationModelAssembler;
import org.springframework.stereotype.Component;


@Component
class EmployeeRepresentationModelAssembler extends SimpleIdentifiableRepresentationModelAssembler<Employee> {

	EmployeeRepresentationModelAssembler() {
		super(EmployeeController.class);
	}

	@Override
	public void addLinks(EntityModel<Employee> resource) {

		
		super.addLinks(resource);

		resource.getContent().getId() //
				.ifPresent(id -> { //
					
					resource.add(linkTo(methodOn(ManagerController.class).findManager(id)).withRel("manager"));
					resource.add(linkTo(methodOn(EmployeeController.class).findDetailedEmployee(id)).withRel("detailed"));

					
					resource.add(linkTo(methodOn(SupervisorController.class).findOne(id)).withRel("supervisor"));
				});
	}

	
	@Override
	public void addLinks(CollectionModel<EntityModel<Employee>> resources) {

		super.addLinks(resources);

		resources.add(linkTo(methodOn(EmployeeController.class).findAllDetailedEmployees()).withRel("detailedEmployees"));
		resources.add(linkTo(methodOn(ManagerController.class).findAll()).withRel("managers"));
		resources.add(linkTo(methodOn(RootController.class).root()).withRel("root"));
	}
}
