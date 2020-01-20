package global.coda.hms.service;

import global.coda.hms.mapper.PatientMapper;
import global.coda.hms.model.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    PatientMapper patientMapper;
    Logger LOGGER = LogManager.getLogger(PatientService.class);

    PatientService(PatientMapper mapper) {
        this.patientMapper = mapper;
    }

    public Patient createPatient(Patient patient) {
        LOGGER.entry(patient);
        patientMapper.createUser(patient);
        patientMapper.createPatient(patient);
        LOGGER.traceExit(patient);
        return patient;
    }

    public List<Patient> getAllPatients() {
        LOGGER.traceEntry();
        List<Patient> patientList = patientMapper.getAllPatients();
        LOGGER.traceExit(patientList);
        return patientList;
    }

    public Patient getPatient(int id) {
        LOGGER.entry(id);
        Patient patient = patientMapper.getPatient(id);
        LOGGER.traceExit(patient);
        return patient;
    }

    public Patient updatePatient(Patient patient) {
        LOGGER.entry(patient);
        patientMapper.updateUser(patient);
        patientMapper.updatePatient(patient);
        LOGGER.traceExit(patient);
        return patient;
    }

    public boolean deletePatient(int id) {
        LOGGER.entry(id);
        patientMapper.deleteUser(id);
        patientMapper.deletePatient(id);
        LOGGER.traceExit("true");
        return true;
    }
}
