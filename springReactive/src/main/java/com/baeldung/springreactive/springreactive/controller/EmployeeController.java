package com.baeldung.springreactive.springreactive.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baeldung.springreactive.springreactive.dao.EmployeeDao;
import com.baeldung.springreactive.springreactive.service.EmployeeService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/baeldung")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/oldway")
    public List<EmployeeDao> getAllEmployee() {
        return employeeService.fetchAllEmployees();

    }
    @GetMapping(value ="/reactiveway", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<EmployeeDao> getAllEmployeeFlux() {
        return employeeService.streamAllEmployeesFlux();

    }
}
