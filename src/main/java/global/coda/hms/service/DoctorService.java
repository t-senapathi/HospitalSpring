package global.coda.hms.service;

import global.coda.hms.mapper.DoctorMapper;
import global.coda.hms.model.Doctor;
import global.coda.hms.model.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Doctor service.
 */
@Service
public class DoctorService {

    /**
     * The Doctor mapper.
     */
    DoctorMapper doctorMapper;
    /**
     * The Logger.
     */
    Logger LOGGER = LogManager.getLogger(DoctorService.class);

    /**
     * Instantiates a new Doctor service.
     *
     * @param mapper the mapper
     */
    DoctorService(DoctorMapper mapper) {
        this.doctorMapper = mapper;
    }

    /**
     * Create doctor doctor.
     *
     * @param doctor the doctor
     * @return the doctor
     */
    public Doctor createDoctor(Doctor doctor) {
        LOGGER.entry(doctor);
        doctorMapper.createUser(doctor);
        doctorMapper.createDoctor(doctor);
        LOGGER.traceExit(doctor);
        return doctor;
    }

    /**
     * Gets all doctors.
     *
     * @return the all doctors
     */
    public List<Doctor> getAllDoctors() {
        LOGGER.traceEntry();
        List<Doctor> doctorList = doctorMapper.getAllDoctors();
        LOGGER.traceExit(doctorList);
        return doctorList;
    }

    /**
     * Gets doctor.
     *
     * @param id the id
     * @return the doctor
     */
    public Doctor getDoctor(int id) {
        LOGGER.entry(id);
        Doctor doctor = doctorMapper.getDoctor(id);
        LOGGER.traceExit(doctor);
        return doctor;
    }

    /**
     * Update doctor doctor.
     *
     * @param doctor the doctor
     * @return the doctor
     */
    public Doctor updateDoctor(Doctor doctor) {
        LOGGER.entry(doctor);
        doctorMapper.updateUser(doctor);
        doctorMapper.updateDoctor(doctor);
        LOGGER.traceExit(doctor);
        return doctor;
    }

    /**
     * Delete doctor boolean.
     *
     * @param id the id
     * @return the boolean
     */
    public boolean deleteDoctor(int id) {
        LOGGER.entry(id);
        doctorMapper.deleteUser(id);
        doctorMapper.deleteDoctor(id);
        LOGGER.traceExit("true");
        return true;
    }


    /**
     * Get all patient under doctor list.
     *
     * @param id the id
     * @return the list
     */
    public List<Doctor> getAllPatientUnderDoctor(int id) {
        LOGGER.traceEntry();
        List<Doctor> doctorList = doctorMapper.getAllPatientUnderAllDoctors(id);
        LOGGER.traceExit(doctorList);
        return doctorList;
    }
}

