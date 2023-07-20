package com.evoke.controller;

import com.evoke.models.Address;
import com.evoke.models.Employee;
import com.evoke.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @QueryMapping
    public List<Employee> findAll() {
        return service.findAll();
    }

    @MutationMapping
    public Employee saveEmployee(@Argument Employee employee) {
        return service.save(employee);
    }

    @MutationMapping
    public Employee updateEmployee(@Argument Long id, @Argument Employee employee) {
        return service.update(id, employee);
    }

    @MutationMapping
    public Boolean deleteEmployee(@Argument Long id) {
        return service.delete(id);
    }

    @SchemaMapping
    public Address address(Employee employee) {
        return employee.getAddress();
    }

}
