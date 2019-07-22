
package org.springframework.hateoas.examples;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


interface EmployeeRepository extends CrudRepository<Employee, Long> {

	List<Employee> findByManagerId(Long id);

}
