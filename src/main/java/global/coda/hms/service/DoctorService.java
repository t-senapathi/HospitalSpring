package global.coda.hms.service;

import global.coda.hms.exception.BusinessException;
import global.coda.hms.exception.SystemException;
import global.coda.hms.exception.UserNotFoundException;
import global.coda.hms.mapper.DoctorMapper;
import global.coda.hms.model.Doctor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import java.util.List;

/**
 * The type Doctor service.
 */
@Service
public class DoctorService {

    /**
     * The Doctor mapper.
     */
    private DoctorMapper doctorMapper;
    /**
     * The Logger.
     */
    private Logger LOGGER = LogManager.getLogger(DoctorService.class);

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
     * @throws BusinessException the business exception
     * @throws SystemException   the system exception
     */
    public Doctor createDoctor(Doctor doctor) throws BusinessException, SystemException {
        try {
            LOGGER.entry(doctor);
            doctorMapper.createUser(doctor);
            doctorMapper.createDoctor(doctor);
            LOGGER.traceExit(doctor);
            return doctor;
        } catch (DuplicateKeyException e) {
            throw new BusinessException("Username already Exists");
        }
        catch (Exception e){
            throw new SystemException(e);
        }
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
     * @throws BusinessException the business exception
     * @throws SystemException   the system exception
     */
    public Doctor getDoctor(int id) throws BusinessException, SystemException {
        try {
            LOGGER.entry(id);
            Doctor doctor = doctorMapper.getDoctor(id);
            if (doctor == null) {
                throw new UserNotFoundException("NO Doctor Found for the given id");
            }
            LOGGER.traceExit(doctor);
            return doctor;
        } catch (UserNotFoundException e) {
            throw new BusinessException(e);
        } catch (Exception e) {
            throw new SystemException(e);
        }
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

