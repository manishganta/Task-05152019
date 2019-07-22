
package org.springframework.hateoas.examples;

import org.springframework.data.repository.CrudRepository;

interface ManagerRepository extends CrudRepository<Manager, Long> {

	Manager findByEmployeesId(Long id);
}
