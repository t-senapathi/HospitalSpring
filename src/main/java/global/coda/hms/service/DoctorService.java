package global.coda.hms.service;

import global.coda.hms.mapper.DoctorMapper;
import global.coda.hms.model.Doctor;
import global.coda.hms.model.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    DoctorMapper doctorMapper;
    Logger LOGGER = LogManager.getLogger(DoctorService.class);

    DoctorService(DoctorMapper mapper) {
        this.doctorMapper = mapper;
    }

    public Doctor createDoctor(Doctor doctor) {
        LOGGER.entry(doctor);
        doctorMapper.createUser(doctor);
        doctorMapper.createDoctor(doctor);
        LOGGER.traceExit(doctor);
        return doctor;
    }

    public List<Doctor> getAllDoctors() {
        LOGGER.traceEntry();
        List<Doctor> doctorList = doctorMapper.getAllDoctors();
        LOGGER.traceExit(doctorList);
        return doctorList;
    }

    public Doctor getDoctor(int id) {
        LOGGER.entry(id);
        Doctor doctor = doctorMapper.getDoctor(id);
        LOGGER.traceExit(doctor);
        return doctor;
    }

    public Doctor updateDoctor(Doctor doctor) {
        LOGGER.entry(doctor);
        doctorMapper.updateUser(doctor);
        doctorMapper.updateDoctor(doctor);
        LOGGER.traceExit(doctor);
        return doctor;
    }

    public boolean deleteDoctor(int id) {
        LOGGER.entry(id);
        doctorMapper.deleteUser(id);
        doctorMapper.deleteDoctor(id);
        LOGGER.traceExit("true");
        return true;
    }


    public List<Doctor> getAllPatientUnderDoctor(int id){
        LOGGER.traceEntry();
        List<Doctor> doctorList= doctorMapper.getAllPatientUnderAllDoctors(id);
        LOGGER.traceExit(doctorList);
        return  doctorList;
    }
}

