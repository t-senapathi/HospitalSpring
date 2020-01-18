package global.coda.hms.service;

import global.coda.hms.mapper.PatientMapper;
import global.coda.hms.model.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    PatientMapper patientMapper;

    PatientService(PatientMapper mapper) {
        this.patientMapper = mapper;
    }

    public Patient createPatient(Patient patient) {
        patientMapper.createUser(patient);
        patientMapper.createPatient(patient);
        return patient;
    }

    public List<Patient> getAllPatients() {
        List<Patient> patientList = patientMapper.getAllPatients();
        return patientList;
    }

    public Patient getPatient(int id) {
        Patient patient = patientMapper.getPatient(id);
        return patient;
    }

    public Patient updatePatient(Patient patient) {
        patientMapper.updateUser(patient);
        patientMapper.updatePatient(patient);
        return patient;
    }

    public boolean deletePatient(int id) {
        patientMapper.deleteUser(id);
        patientMapper.deletePatient(id);
        return true;
    }
}
