
package org.springframework.hateoas.examples;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
class RootController {

	@GetMapping("/")
	ResponseEntity<RepresentationModel> root() {

		RepresentationModel resourceSupport = new RepresentationModel();

		resourceSupport.add(linkTo(methodOn(RootController.class).root()).withSelfRel());
		resourceSupport.add(linkTo(methodOn(EmployeeController.class).findAll()).withRel("employees"));
		resourceSupport
				.add(linkTo(methodOn(EmployeeController.class).findAllDetailedEmployees()).withRel("detailedEmployees"));
		resourceSupport.add(linkTo(methodOn(ManagerController.class).findAll()).withRel("managers"));

		return ResponseEntity.ok(resourceSupport);
	}

}
