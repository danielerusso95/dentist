package it.softwareinside.management.dentist.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.softwareinside.management.dentist.model.Appointment;
import it.softwareinside.management.dentist.repository.AppointmentRepository;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;

	@Autowired
	private CustomerService customerService;

	
	/**
	 * return full list of appointment
	 * @return
	 */
	public List<Appointment> getAllAppointments() {

		return appointmentRepository.findAll();
	}

	/**
	 * return one appointment by ID
	 * @return
	 */
	public Appointment getOneAppointment(long id) {
		return appointmentRepository.findById(id).get();

	}

	/**
	 * return a list of appointments by date
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public List<Appointment> getAppointmentsByDate(int day,int month,int year) {
		List<Appointment> listByDate = new ArrayList<Appointment>();
		for (int i = 0; i < appointmentRepository.findAll().size(); i++) {
			if(appointmentRepository.findAll().get(i).getDate().getDate()==day+1 
					&& appointmentRepository.findAll().get(i).getDate().getMonth()==month-1 
					&& appointmentRepository.findAll().get(i).getDate().getYear()==year-1900){
				System.out.println("sono qui");
				listByDate.add(appointmentRepository.findAll().get(i));
			}
		}
		return listByDate;
	}

	/**
	 * return true if appointment is added, if not return false
	 * @param appointment
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public boolean addAppointment(Appointment appointment) {
		if(appointment.getDate().getHours()-2<9||appointment.getDate().getHours()-2>=18)
			return false;

		if(appointment.getDate().getMinutes()!=0 && appointment.getDate().getMinutes()!=30)
			return false;

		for(int i=0;i<appointmentRepository.findAll().size();i++)
			if(appointmentRepository.findAll().get(i).getDate().compareTo(appointment.getDate())==0)
				return false;
		customerService.editCustomer(appointment.getCustomer().getCf(),appointment.getCustomer());
		appointmentRepository.save(appointment);
		return true;
	}

	public Appointment editAppointment(long id,Appointment newAppointment) {
		for (int i = 0; i<appointmentRepository.findAll().size(); i++) {
			if(appointmentRepository.findAll().get(i).getId()==id) {
				if(this.addAppointment(newAppointment)) {
					this.addAppointment(newAppointment);
					appointmentRepository.deleteById(id);
					return newAppointment;
				}
			}
		}
		return null;
	}

	public boolean deleteAppointment(long id) {
		for (int i = 0; i<appointmentRepository.findAll().size(); i++) {
			if(appointmentRepository.findAll().get(i).getId()==id) {
				appointmentRepository.deleteById(id);
				return true;
			}
		}
		return false;
	}
}
