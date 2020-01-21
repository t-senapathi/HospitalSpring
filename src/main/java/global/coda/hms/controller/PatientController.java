package global.coda.hms.controller;

import java.util.List;

import global.coda.hms.model.Patient;
import global.coda.hms.model.ResponseEntity;
import global.coda.hms.service.PatientService;
import org.apache.catalina.connector.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * The type Patient controller.
 */
@RestController
@RequestMapping("/patients")
public class PatientController {
    /**
     * The Logger.
     */
    private Logger LOGGER = LogManager.getLogger(PatientController.class);
    /**
     * The Patient service.
     */
    @Autowired
    private PatientService patientService;

    /**
     * Gets all patients.
     *
     * @param httpServletRequest the http servlet request
     * @return the all patients
     */
    @GetMapping("/all")
    public ResponseEntity<List<Patient>> getAllPatients(HttpServletRequest httpServletRequest) {
        LOGGER.traceEntry();
        ResponseEntity<List<Patient>> responseEntity = new ResponseEntity<>();
        List<Patient> patientList = patientService.getAllPatients();
        responseEntity.setStatusCode(Response.SC_OK);
        responseEntity.setData(patientList);
        responseEntity.setRequestId((Integer) httpServletRequest.getAttribute("requestId"));
        LOGGER.traceExit(patientList);
        return responseEntity;
    }

    /**
     * Gets patient.
     *
     * @param id the id
     * @return the patient
     */
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatient(@PathVariable int id) {
        LOGGER.entry(id);
        ResponseEntity<Patient> responseEntity = new ResponseEntity<>();
        Patient patient = patientService.getPatient(id);
        responseEntity.setData(patient);
        responseEntity.setStatusCode(Response.SC_OK);
        LOGGER.traceExit(patient);
        return responseEntity;
    }

    /**
     * Create patient response entity.
     *
     * @param patient the patient
     * @return the response entity
     */
    @PostMapping("/create")
    public ResponseEntity<Integer> createPatient(@RequestBody Patient patient) {
        LOGGER.entry(patient);
        ResponseEntity<Integer> responseEntity = new ResponseEntity<>();
        patient = patientService.createPatient(patient);
        responseEntity.setStatusCode(Response.SC_OK);
        responseEntity.setData(patient.getPkUserId());
        LOGGER.traceExit(patient);
        return responseEntity;
    }

    /**
     * Update patient response entity.
     *
     * @param patient the patient
     * @return the response entity
     */
    @PutMapping("/update")
    public ResponseEntity<Integer> updatePatient(@RequestBody Patient patient) {
        LOGGER.entry(patient);
        ResponseEntity<Integer> responseEntity = new ResponseEntity<>();
        patient = patientService.updatePatient(patient);
        responseEntity.setData(patient.getPkUserId());
        responseEntity.setStatusCode(Response.SC_OK);
        LOGGER.traceExit(patient);
        return responseEntity;
    }

    /**
     * Delete patient response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deletePatient(@RequestParam("id") int id) {
        LOGGER.entry(id);
        ResponseEntity<Boolean> responseEntity = new ResponseEntity<>();
        boolean result = patientService.deletePatient(id);
        responseEntity.setStatusCode(Response.SC_OK);
        responseEntity.setData(result);
        LOGGER.traceExit(result);
        return responseEntity;
    }
}
