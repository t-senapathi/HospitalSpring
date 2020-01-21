package global.coda.hms.controller;

import global.coda.hms.model.Employee;
import global.coda.hms.model.ResponseEntity;
import global.coda.hms.service.EmployeeService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * The type Employee controller.
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    /**
     * The Employee service.
     */
    @Autowired
    EmployeeService employeeService;

    /**
     * Create employee response entity.
     *
     * @param employee the employee
     * @param request  the request
     * @return the response entity
     */
    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee, HttpServletRequest request) {
        ResponseEntity<Employee> responseEntity = new ResponseEntity<>();
        responseEntity.setStatusCode(Response.SC_OK);
        responseEntity.setRequestId((Integer) request.getAttribute("requestId"));
        responseEntity.setData(employeeService.createEmployee(employee));
        return responseEntity;
    }
}
