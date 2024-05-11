package employeeSystemBackend.employeeSystem.controller;

import employeeSystemBackend.employeeSystem.exception.ResourceNotFound;
import employeeSystemBackend.employeeSystem.model.Employee;
import employeeSystemBackend.employeeSystem.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    //Get all employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    //Create employee
    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee) {

        return employeeRepository.save(employee);
    }

    //Get employee by ID

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Employee with ID:" + id + " does not exist"));
        return ResponseEntity.ok(employee);
    }

}
