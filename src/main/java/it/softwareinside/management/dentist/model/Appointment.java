package it.softwareinside.management.dentist.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A class that defined a appointment for a customer,
 * it linked to Customer Class by many to one relation
 * 
 * @author daniele
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long id;

	@Column
	@NotNull
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="customer_cf", nullable=false)
	private Customer customer;

}
