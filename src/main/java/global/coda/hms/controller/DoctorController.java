package global.coda.hms.controller;

import global.coda.hms.model.Doctor;
import global.coda.hms.model.ResponseEntity;
import global.coda.hms.service.DoctorService;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    Logger LOGGER = LogManager.getLogger(DoctorController.class);
    @Autowired
    DoctorService doctorService;

    @GetMapping("/all")
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        LOGGER.traceEntry();
        ResponseEntity<List<Doctor>> responseEntity = new ResponseEntity<>();
        List<Doctor> doctorList = doctorService.getAllDoctors();
        responseEntity.setData(doctorList);
        responseEntity.setStatusCode(200);
        LOGGER.traceExit(doctorList);
        return responseEntity;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctor(@PathVariable int id) {
        LOGGER.entry(id);
        ResponseEntity<Doctor> responseEntity = new ResponseEntity<>();
        Doctor doctor = doctorService.getDoctor(id);
        responseEntity.setStatusCode(200);
        responseEntity.setData(doctor);
        LOGGER.traceExit(doctor);
        return responseEntity;
    }

    @PostMapping("/create")
    public ResponseEntity<Integer> createDoctor(@RequestBody Doctor doctor) {
        LOGGER.entry(doctor);
        ResponseEntity<Integer> responseEntity = new ResponseEntity<>();
        doctor = doctorService.createDoctor(doctor);
        responseEntity.setData(doctor.getPkUserId());
        responseEntity.setStatusCode(200);
        LOGGER.traceExit(doctor);
        return responseEntity;
    }

    @PutMapping("/update")
    public ResponseEntity<Integer> updateDoctor(@RequestBody Doctor doctor) {
        LOGGER.entry(doctor);
        ResponseEntity<Integer> responseEntity = new ResponseEntity<>();
        doctor = doctorService.updateDoctor(doctor);
        responseEntity.setStatusCode(200);
        responseEntity.setData(doctor.getPkUserId());
        LOGGER.traceExit(doctor);
        return responseEntity;
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deleteDoctor(@RequestParam("id") int id) {
        LOGGER.entry(id);
        ResponseEntity<Boolean> responseEntity = new ResponseEntity<>();
        boolean result = doctorService.deleteDoctor(id);
        responseEntity.setData(result);
        responseEntity.setStatusCode(200);
        LOGGER.traceExit(result);
        return responseEntity;
    }

    @GetMapping("/patients")
    public ResponseEntity<List<Doctor>> getPatientUnderADoctor(@PathParam("doctorId") Integer doctorId) {
        LOGGER.entry(doctorId);
        if(doctorId == null){
            doctorId=0;
        }
        ResponseEntity<List<Doctor>> responseEntity = new ResponseEntity<>();
        List<Doctor> doctorList= doctorService.getAllPatientUnderDoctor(doctorId);
        responseEntity.setStatusCode(200);
        responseEntity.setData(doctorList);
        LOGGER.traceExit(doctorList);
        return  responseEntity;
    }

}
