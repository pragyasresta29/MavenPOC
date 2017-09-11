package com.test.crud.service;

import com.test.crud.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService{
    Session session;
    public EmployeeServiceImpl(){
        super();
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        session=sessionFactory.openSession();

    }
    @Override
    public List<Employee> getEmployeeList() {
//        List<Employee> employees=new ArrayList<>();
//        employees.add(new Employee(1, "Pragya","Shrestha","Boudha",22));
//        employees.add(new Employee(2, "Salu","Khadka","Chabahil",22));
//        employees.add(new Employee(2, "Ram","Khadka","Chabahil",22));
//

        session.beginTransaction();
        List<Employee> employeeList = (List<Employee>) session.createCriteria(Employee.class);
        session.close();
        return employeeList;
//        return employees;

    }

    @Override
    public Employee getEmployee(Integer id) {


        session.beginTransaction();
        Employee employee= (Employee) session.get(Employee.class,id);
        session.close();
        return employee;

    }



    @Override
    public void addEmployee(Employee employee) {

        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void editEmployee(Employee employee) {

        session.beginTransaction();
        session.saveOrUpdate(employee);
        session.getTransaction().commit();
        session.close();
    }
    @Override
    public void deleteEmployee(Employee employee) {

        session.beginTransaction();
        session.delete(employee);
        session.getTransaction().commit();
        session.close();

    }

}
