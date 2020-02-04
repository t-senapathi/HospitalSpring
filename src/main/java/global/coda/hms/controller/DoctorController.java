package global.coda.hms.controller;

import global.coda.hms.exception.BusinessException;
import global.coda.hms.exception.SystemException;
import global.coda.hms.model.Doctor;
import global.coda.hms.model.ResponseEntity;
import global.coda.hms.service.DoctorService;
import org.apache.catalina.connector.Response;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * The type Doctor controller.
 */
@RestController
@RequestMapping("/doctor")
@CrossOrigin
public class DoctorController {
    /**
     * The Logger.
     */
    private Logger LOGGER = LogManager.getLogger(DoctorController.class);
    /**
     * The Doctor service.
     */
    @Autowired
    private DoctorService doctorService;

    /**
     * Gets all doctors.
     *
     * @return the all doctors
     */
    @CrossOrigin
    @GetMapping("/all")
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        LOGGER.traceEntry();
        ResponseEntity<List<Doctor>> responseEntity = new ResponseEntity<>();
        List<Doctor> doctorList = doctorService.getAllDoctors();
        responseEntity.setData(doctorList);
        responseEntity.setStatusCode(Response.SC_OK);
        LOGGER.traceExit(doctorList);
        return responseEntity;
    }

    /**
     * Gets doctor.
     *
     * @param id the id
     * @return the doctor
     * @throws SystemException   the system exception
     * @throws BusinessException the business exception
     */
    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctor(@PathVariable int id) throws SystemException, BusinessException {
        LOGGER.entry(id);
        ResponseEntity<Doctor> responseEntity = new ResponseEntity<>();
        Doctor doctor = doctorService.getDoctor(id);
        responseEntity.setStatusCode(Response.SC_OK);
        responseEntity.setData(doctor);
        LOGGER.traceExit(doctor);
        return responseEntity;
    }

    /**
     * Create doctor response entity.
     *
     * @param doctor the doctor
     * @return the response entity
     * @throws SystemException   the system exception
     * @throws BusinessException the business exception
     */
    @CrossOrigin
    @PostMapping("/create")
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor) throws SystemException, BusinessException{
        LOGGER.entry(doctor);
        ResponseEntity<Doctor> responseEntity = new ResponseEntity<>();
        doctor = doctorService.createDoctor(doctor);
        responseEntity.setData(doctor);
        responseEntity.setStatusCode(Response.SC_OK);
        LOGGER.traceExit(doctor);
        return responseEntity;
    }

    /**
     * Update doctor response entity.
     *
     * @param doctor the doctor
     * @return the response entity
     */
    @CrossOrigin
    @PutMapping("/update")
    public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor doctor) {
        LOGGER.entry(doctor);
        ResponseEntity<Doctor> responseEntity = new ResponseEntity<>();
        doctor = doctorService.updateDoctor(doctor);
        responseEntity.setStatusCode(Response.SC_OK);
        responseEntity.setData(doctor);
        LOGGER.traceExit(doctor);
        return responseEntity;
    }

    /**
     * Delete doctor response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteDoctor(@PathVariable int id) {
        LOGGER.entry(id);
        ResponseEntity<Boolean> responseEntity = new ResponseEntity<>();
        boolean result = doctorService.deleteDoctor(id);
        responseEntity.setData(result);
        responseEntity.setStatusCode(Response.SC_OK);
        LOGGER.traceExit(result);
        return responseEntity;
    }

    /**
     * Gets patient under a doctor.
     *
     * @param doctorId the doctor id
     * @return the patient under a doctor
     */
    @CrossOrigin
    @GetMapping("/patients")
    public ResponseEntity<List<Doctor>> getPatientUnderADoctor(@PathParam("doctorId") Integer doctorId) {
        LOGGER.entry(doctorId);
        if (doctorId == null) {
            doctorId = 0;
        }
        ResponseEntity<List<Doctor>> responseEntity = new ResponseEntity<>();
        List<Doctor> doctorList = doctorService.getAllPatientUnderDoctor(doctorId);
        responseEntity.setStatusCode(Response.SC_OK);
        responseEntity.setData(doctorList);
        LOGGER.traceExit(doctorList);
        return responseEntity;
    }

}
