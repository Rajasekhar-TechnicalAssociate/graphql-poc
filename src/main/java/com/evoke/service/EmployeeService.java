package com.evoke.service;


import com.evoke.models.Employee;
import com.evoke.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    private Optional<Employee> findById(Long id) {
        return repository.findById(id);
    }

    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Transactional
    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    public Employee update(Long id, Employee employee) {
        final Optional<Employee> optional = findById(id);
        if (!optional.isPresent()) throw new RuntimeException("Employee not found. Employee ID: " + id);
        return repository.save(employee);
    }

    public Boolean delete(Long id) {
        final Optional<Employee> optional = findById(id);
        if (!optional.isPresent()) return false;
        repository.delete(optional.get());
        return true;
    }

}
