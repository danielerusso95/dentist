package it.softwareinside.management.dentist.model;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A class that defined a customer of a dentist,
 * it linked to Appointment Class by one to many relation
 * 
 * @author daniele
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="customer")
public class Customer {

	@Id
	@Column(length = 16)
	private String cf;

	@Column(name="name")
	@NotEmpty(message="name can't be empty")
	private String name;
	
	@Column(name="surname")
	@NotEmpty(message="surnname can't be empty")
	private String surname;
	
	@Column(name="phoneNumber")
	@NotEmpty(message="phone can't be empty")
	@Length(min = 5,max = 15,message = "please insert a correct phone number")
	private String phoneNumber;
	
	@Column(name="email")
	@NotEmpty(message="email can't be empty")
	@Email(message = "please insert a correct email")
	private String email;
	
	@Column(name="dob")
	private Date dob;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
	@JsonIgnore
	private List<Appointment> appointment;

}
