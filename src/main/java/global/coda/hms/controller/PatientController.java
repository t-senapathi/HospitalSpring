package global.coda.hms.controller;

import java.util.List;

import global.coda.hms.mapper.PatientMapper;
import global.coda.hms.model.Patient;
import global.coda.hms.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    PatientService patientService;

    @GetMapping("/all")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/id")
    public Patient getPatient(@RequestParam("id") int id) {
        return patientService.getPatient(id);
    }
    @PostMapping("/create")
    public int createPatient(@RequestBody Patient patient) {
        patient=patientService.createPatient(patient);
        return patient.getPkUserId();
    }

}
