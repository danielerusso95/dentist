package it.softwareinside.management.dentist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.softwareinside.management.dentist.model.Appointment;
import it.softwareinside.management.dentist.service.AppointmentService;
@RestController
@RequestMapping("/api/appointment")
public class RestControllerAppointment {

	@Autowired
	private AppointmentService appointmentService;
	
	/**
	 * uri to get all appointment
	 * @return
	 */
	@GetMapping("/getAll")
	public List<Appointment> getAllAppointments(){
		return appointmentService.getAllAppointments();
	}
	
	/**
	 * uri to get one appointment by ID
	 * @return
	 */
	@GetMapping("/getOneAppointment/{id}")
	public Appointment getOneAppointment(@PathVariable() long id) {
		return appointmentService.getOneAppointment(id);
	}
	/**
	 * return list of appointment by date
	 * @param day
	 * @param month
	 * @param year
	 * @return
	 */
	@GetMapping("/getAllByDate/{day}/{month}/{year}")
	public List<Appointment> getAllAppointmentsByDate(@PathVariable() int day,@PathVariable() int month,@PathVariable() int year){
		return appointmentService.getAppointmentsByDate(day,month,year);
	}
	/**
	 * uri to insert appointment
	 * @param appointment
	 * @return
	 */
	@PostMapping("/insert")
	public boolean insertAppointments(@RequestBody() Appointment appointment){
		return appointmentService.addAppointment(appointment);
	}
	
	@PutMapping(value="/edit/{id}")
	public Appointment editAppointment(@PathVariable() long id,@RequestBody() Appointment appointment) {
		return appointmentService.editAppointment(id, appointment);
	}
	
	@DeleteMapping("/delete/{id}")
    public boolean deleteCustomer(@PathVariable long id) {
        return appointmentService.deleteAppointment(id);
    }
}
