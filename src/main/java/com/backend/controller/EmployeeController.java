package com.backend.controller;

import com.backend.model.EmployeeRequest;
import com.backend.model.EmployeeResponse;
import com.backend.model.EmployeeUpdate;
import com.backend.service.EmployeeService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//@CrossOrigin("*")
//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(origins = "http://frontendnew2.s3-website.ap-south-1.amazonaws.com")
@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
@Tag(name = "Employee")
public class EmployeeController {
    @Autowired

    private EmployeeService service;

//    @PostMapping
//    public ResponseEntity<String> addEmployee(@RequestBody EmployeeRequest employeeRequest){
//        String empId = service.addEmployee(employeeRequest);
//        return new ResponseEntity<>(empId, HttpStatus.CREATED);
//    }

    @PostMapping
    @Operation(
            description = "1. This is to add employees in the DB " +
                    "2. {" +
                    "  \"firstName\": \"string\",\n" +
                    "  \"lastName\": \"string\",\n" +
                    "  \"email\": \"string\"\n" +
                    "}",
            summary = "This is summary for employee endpoints",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"

                    ),
                    @ApiResponse(
                            description = "Unauthorized",
                            responseCode = "403"

                    )
            }
    )
    public ResponseEntity<EmployeeRequest> addEmployee(@RequestBody EmployeeRequest employeeRequest) {
        EmployeeRequest empId = service.addEmployee(employeeRequest);
        return new ResponseEntity<>(empId, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> getEmpById(@PathVariable String id) {
        EmployeeResponse employeeResponse = service.getById(id);
        return ResponseEntity.ok(employeeResponse);
    }

    @Operation(summary = "This is to fetch all the employee from the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fetched all the employee from the DB",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Not Available",
                    content = @Content)
    })
    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> getAllEmp() {
        List<EmployeeResponse> employeeResponses = service.getAllEmp();
        return new ResponseEntity<>(employeeResponses, HttpStatus.OK);
    }

//    @GetMapping
//    @ResponseStatus(HttpStatus.OK)
//    public List<EmployeeResponse> getAllEmp(){
//        List<EmployeeResponse> employeeResponses = service.getAllEmp();
//       return employeeResponses;
//    }

    @DeleteMapping("/{id}")
    @Hidden
    public ResponseEntity<String> deleteEmp(@PathVariable String id) {
        String emp = service.deleteEmp(id);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeUpdate> updateEmp(@PathVariable String id, @RequestBody EmployeeUpdate employeeUpdate) {
        EmployeeUpdate update = service.updateEmp(id, employeeUpdate);
        return ResponseEntity.ok(update);
    }
    @GetMapping({"/demo"})
    public String emp() {
        return
                "Hello, World!";
    }

}
