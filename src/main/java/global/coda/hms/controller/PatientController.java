package global.coda.hms.controller;

import java.util.List;

import global.coda.hms.model.Patient;
import global.coda.hms.model.ResponseEntity;
import global.coda.hms.service.PatientService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
public class PatientController {
    Logger LOGGER = LogManager.getLogger(PatientController.class);
    @Autowired
    PatientService patientService;

    @GetMapping("/all")
    public ResponseEntity<List<Patient>> getAllPatients()
    {
        LOGGER.traceEntry();
        ResponseEntity<List<Patient>> responseEntity= new ResponseEntity<>();
        List<Patient> patientList = patientService.getAllPatients();
        responseEntity.setStatusCode(200);
        responseEntity.setData(patientList);
        LOGGER.traceExit(patientList);
        return responseEntity;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatient(@PathVariable int id)
    {
        LOGGER.entry(id);
        ResponseEntity<Patient> responseEntity= new ResponseEntity<>();
        Patient patient=patientService.getPatient(id);
        responseEntity.setData(patient);
        responseEntity.setStatusCode(200);
        LOGGER.traceExit(patient);
        return responseEntity;
    }

    @PostMapping("/create")
    public ResponseEntity<Integer> createPatient(@RequestBody Patient patient) {
        LOGGER.entry(patient);
        ResponseEntity<Integer> responseEntity= new ResponseEntity<>();
        patient=patientService.createPatient(patient);
        responseEntity.setStatusCode(200);
        responseEntity.setData(patient.getPkUserId());
        LOGGER.traceExit(patient);
        return responseEntity;
    }
    @PutMapping("/update")
    public ResponseEntity<Integer> updatePatient(@RequestBody Patient patient) {
        LOGGER.entry(patient);
        ResponseEntity<Integer> responseEntity= new ResponseEntity<>();
        patient=patientService.updatePatient(patient);
        responseEntity.setData(patient.getPkUserId());
        responseEntity.setStatusCode(200);
        LOGGER.traceExit(patient);
        return responseEntity;
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deletePatient(@RequestParam("id") int id)
    {
        LOGGER.entry(id);
        ResponseEntity<Boolean> responseEntity= new ResponseEntity<>();
        boolean result= patientService.deletePatient(id);
        responseEntity.setStatusCode(200);
        responseEntity.setData(result);
        LOGGER.traceExit(result);
        return responseEntity;
    }
}
