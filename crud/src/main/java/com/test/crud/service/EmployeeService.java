package com.test.crud.service;

import com.test.crud.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployeeList();
    Employee getEmployee(Integer id);
    void addEmployee(Employee employee);
    void editEmployee(Employee employee);
    void deleteEmployee(Employee employee);
}
