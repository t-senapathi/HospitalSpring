package global.coda.hms.service;

import global.coda.hms.mapper.DoctorMapper;
import global.coda.hms.model.Doctor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    DoctorMapper doctorMapper;

    DoctorService(DoctorMapper mapper) {
        this.doctorMapper = mapper;
    }

    public Doctor createDoctor(Doctor doctor) {
        doctorMapper.createUser(doctor);
        doctorMapper.createDoctor(doctor);
        return doctor;
    }

    public List<Doctor> getAllDoctors() {
        List<Doctor> doctorList = doctorMapper.getAllDoctors();
        return doctorList;
    }

    public Doctor getDoctor(int id) {
        Doctor doctor = doctorMapper.getDoctor(id);
        return doctor;
    }

    public Doctor updateDoctor(Doctor doctor) {
        doctorMapper.updateUser(doctor);
        doctorMapper.updateDoctor(doctor);
        return doctor;
    }

    public boolean deleteDoctor(int id) {
        doctorMapper.deleteUser(id);
        doctorMapper.deleteDoctor(id);
        return true;
    }
}

