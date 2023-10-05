package com.backend.service;

import com.backend.entity.Employee;
import com.backend.model.EmployeeRequest;
import com.backend.model.EmployeeResponse;
import com.backend.model.EmployeeUpdate;
import com.backend.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeRequest addEmployee(EmployeeRequest employeeRequest) {
        Employee employee = Employee.builder()
                .firstName(employeeRequest.getFirstName())
                .lastName(employeeRequest.getLastName())
                .email(employeeRequest.getEmail())
                .build();
        employee = repository.save(employee);
        return employeeRequest;
    }

    public EmployeeResponse getById(String id) {
        Employee employee = repository.findById(id).get();

        EmployeeResponse employeeResponse = EmployeeResponse.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .build();
        return employeeResponse;
    }

    //    public EmployeeUpdate updateEmp(String id, EmployeeUpdate employeeUpdate) {
//        Employee employee1 = repository.findById(id).get();
//
//
//            EmployeeUpdate employeeUpdate1 = EmployeeUpdate.builder()
//                    .id(employeeUpdate.getId())
//                    .firstName(employeeUpdate.getFirstName())
//                    .lastName(employeeUpdate.getLastName())
//                    .email(employeeUpdate.getLastName())
//                    .build();
//            repository.save(employee1);
//
//        return employeeUpdate;
//    }
    public EmployeeUpdate updateEmp(String id, EmployeeUpdate employeeUpdate) {
        Employee employee1 = repository.findById(id).orElse(null);

        if (employee1 != null) {
            // Update the fields of the existing employee using the builder pattern
            Employee updatedEmployee = Employee.builder()
                    .id(employeeUpdate.getId())
                    .firstName(employeeUpdate.getFirstName())
                    .lastName(employeeUpdate.getLastName())
                    .email(employeeUpdate.getEmail())
                    .build();

            // Save the updated employee back to the repository
            repository.save(updatedEmployee);
        }

        return employeeUpdate;
    }

//
//    public List<EmployeeResponse> getAllEmp() {
//        List<Employee> employeesEntities = repository.findAll();
//        List<EmployeeResponse> employes = employeesEntities.stream().map(
//                employee -> new
//                        EmployeeResponse(employee.getId()
//                        , employee.getFirstName()
//                        , employee.getLastName()
//                        , employee.getEmail())
//        ).collect(Collectors.toList());
//        return employes;
//    }

    public List<EmployeeResponse> getAllEmp() {
        List<Employee> employeesEntities = repository.findAll();
        List<EmployeeResponse> employes = employeesEntities.stream().map(
                employee -> new
                        EmployeeResponse(employee.getId()
                        , employee.getFirstName()
                        , employee.getLastName()
                        , employee.getEmail())
        ).collect(Collectors.toList());
        return employes;
    }

//    private EmployeeResponse mapTODto(Employee employee) {
//        EmployeeResponse employeeResponse = EmployeeResponse.builder()
//                .id(employee.getId())
//                .firstName(employee.getFirstName())
//                .lastName(employee.getLastName())
//                .email(employee.getEmail())
//                .build();
//        return employeeResponse;
//    }

    public String deleteEmp(String id) {
        repository.deleteById(id);
        return "Deleted";
    }

//    public EmployeeUpdate updateEmp(String id, EmployeeUpdate employeeUpdate) {
//        Optional<Employee> optionalEmployee = repository.findById(id);
//
//        if (optionalEmployee.isPresent()) {
//            Employee employee = optionalEmployee.get();
//
//            employee.setFirstName(employeeUpdate.getFirstName());
//            employee.setLastName(employeeUpdate.getLastName());
//            employee.setEmail(employeeUpdate.getEmail());
//            repository.save(employee);
//        }
//        return employeeUpdate;
//    }


//    public String addEmployee(EmployeeRequest employeeRequest) {
//
//        Employee employee= Employee.builder()
//                .firstName(employeeRequest.getFirstName())
//                .lastName(employeeRequest.getLastName())
//                .email(employeeRequest.getEmail())
//                .build();
//        employee = repository.save(employee);
//        return employee.getId();
//    }
}
