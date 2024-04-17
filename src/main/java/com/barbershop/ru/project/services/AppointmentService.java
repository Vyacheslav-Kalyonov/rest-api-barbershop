package com.barbershop.ru.project.services;

import com.barbershop.ru.project.models.Appointment;
import com.barbershop.ru.project.models.Staff;
import com.barbershop.ru.project.repositories.AppointmentRepository;
import com.barbershop.ru.project.repositories.StaffRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final StaffRepository staffRepository;


    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository, StaffRepository staffRepository) {
        this.appointmentRepository = appointmentRepository;
        this.staffRepository = staffRepository;
    }

    @Transactional
    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    @Transactional
    public Appointment findOne(int id) {
        return appointmentRepository.findById(id).orElse(null);
    }

    @Transactional
    public void save(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    @Transactional
    public void delete(int id) {
        appointmentRepository.deleteById(id);
    }

    @Transactional
    public void update(int id, Appointment updatedAppointment) {
        updatedAppointment.setId(id);
        appointmentRepository.save(updatedAppointment);
    }

    @Transactional
    public List<Appointment> findAppointmentByDataAndStaffId(Date date1, Date date2, int staffId) {
        return appointmentRepository.findAppointmentByDataBetweenAndStaffId(date1, date2, staffId);
    }

    public List<String> checkAvailableTime(Date date, int barbershopId) {
        Set<String> result = new LinkedHashSet<>();
        List<Staff> staffList = staffRepository.findAllByPositionIsTrue();
        for (Staff staff : staffList) {
            result.addAll(findAppointmentByStaffId(date, staff.getId()));
        }

        return result.stream().sorted().toList();
    }

    public List<String> findAppointmentByStaffId(Date date, int id) {
        Date date1 = (Date) date.clone();
        Date date2 = (Date) date.clone();

        date1.setHours(0);
        date1.setMinutes(0);
        date1.setSeconds(0);

        date2.setHours(23);
        date2.setMinutes(59);
        date2.setSeconds(59);

        List<Appointment> appointments = findAppointmentByDataAndStaffId(date1, date2, id);

        List<String> occupiedAppointments = getFormatStringForTime(appointments);
        List<String> possibleTime = getPossibleTime();
        possibleTime.removeAll(occupiedAppointments);

        return possibleTime;
    }

    private List<String> getFormatStringForTime(List<Appointment> appointments) {
        List<String> result = new LinkedList<>();

        for (Appointment appointment : appointments) {
            String formatAppointment = appointment.getData().getHours() + ":" + appointment.getData().getMinutes();

            if (appointment.getData().getMinutes() == 0) {
                formatAppointment += "0";
            }

            result.add(formatAppointment);
        }

        return result;
    }

    private List<String> getPossibleTime() {
        List<String> time = new LinkedList<>();

        for(int i = 10; i <= 20; i++) {

            String str1 = i + ":" + "00";
            String str2 = i + ":" + "30";

            time.add(str1);
            time.add(str2);
        }

        return time;
    }
}
