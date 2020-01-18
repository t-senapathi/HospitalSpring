package global.coda.hms.controller;

import global.coda.hms.model.Doctor;
import global.coda.hms.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;

    @GetMapping("/all")
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @GetMapping("/id")
    public Doctor getDoctor(@RequestParam("id") int id) {
        return doctorService.getDoctor(id);
    }

    @PostMapping("/create")
    public int createDoctor(@RequestBody Doctor doctor) {
        doctor=doctorService.createDoctor(doctor);
        return doctor.getPkUserId();
    }
    @PutMapping("/update")
    public int updateDoctor(@RequestBody Doctor doctor) {
        doctor=doctorService.updateDoctor(doctor);
        return doctor.getPkUserId();
    }

    @DeleteMapping("/delete")
    public boolean deleteDoctor(@RequestParam("id") int id) {
        return doctorService.deleteDoctor(id);
    }
}
