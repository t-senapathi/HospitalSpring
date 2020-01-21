package global.coda.hms.service;

import global.coda.hms.mapper.EmployeeRepo;
import global.coda.hms.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;

    public Employee createEmployee(Employee employee){
       return employeeRepo.save(employee);
    }
}
