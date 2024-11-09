package com.k8s.springreactive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.k8s.springreactive.dao.EmployeeDao;
import com.k8s.springreactive.dto.EmployeeDto;

import reactor.core.publisher.Flux;

@Service
public class EmployeeService {

    @Autowired
    EmployeeDto employeeDto;

    public List<EmployeeDao> fetchAllEmployees() {
        return employeeDto.getEmployee();
    }

    public Flux<EmployeeDao> streamAllEmployeesFlux() {
        return employeeDto.streamEmployeeFlux();
    }

}
