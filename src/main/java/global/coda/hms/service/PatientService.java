package global.coda.hms.service;

import global.coda.hms.mapper.PatientMapper;
import global.coda.hms.model.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Patient service.
 */
@Service
public class PatientService {

    /**
     * The Patient mapper.
     */
    PatientMapper patientMapper;
    /**
     * The Logger.
     */
    Logger LOGGER = LogManager.getLogger(PatientService.class);

    /**
     * Instantiates a new Patient service.
     *
     * @param mapper the mapper
     */
    PatientService(PatientMapper mapper) {
        this.patientMapper = mapper;
    }

    /**
     * Create patient patient.
     *
     * @param patient the patient
     * @return the patient
     */
    public Patient createPatient(Patient patient) {
        LOGGER.entry(patient);
        patientMapper.createUser(patient);
        patientMapper.createPatient(patient);
        LOGGER.traceExit(patient);
        return patient;
    }

    /**
     * Gets all patients.
     *
     * @return the all patients
     */
    public List<Patient> getAllPatients() {
        LOGGER.traceEntry();
        List<Patient> patientList = patientMapper.getAllPatients();
        LOGGER.traceExit(patientList);
        return patientList;
    }

    /**
     * Gets patient.
     *
     * @param id the id
     * @return the patient
     */
    public Patient getPatient(int id) {
        LOGGER.entry(id);
        Patient patient = patientMapper.getPatient(id);
        LOGGER.traceExit(patient);
        return patient;
    }

    /**
     * Update patient patient.
     *
     * @param patient the patient
     * @return the patient
     */
    public Patient updatePatient(Patient patient) {
        LOGGER.entry(patient);
        patientMapper.updateUser(patient);
        patientMapper.updatePatient(patient);
        LOGGER.traceExit(patient);
        return patient;
    }

    /**
     * Delete patient boolean.
     *
     * @param id the id
     * @return the boolean
     */
    public boolean deletePatient(int id) {
        LOGGER.entry(id);
        patientMapper.deleteUser(id);
        patientMapper.deletePatient(id);
        LOGGER.traceExit("true");
        return true;
    }
}
