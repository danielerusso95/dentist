package it.softwareinside.management.dentist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.softwareinside.management.dentist.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

}
