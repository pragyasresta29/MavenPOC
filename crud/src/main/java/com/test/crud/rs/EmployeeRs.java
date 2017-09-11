package com.test.crud.rs;

import com.test.crud.model.Employee;
import com.test.crud.service.EmployeeService;
import com.test.crud.service.EmployeeServiceImpl;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/employee")
public class EmployeeRs {
    @Inject
    EmployeeService employeeService=new EmployeeServiceImpl();

    @Path("/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getList(){ return employeeService.getEmployeeList(); }

    @Path("/test/")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(){ return "hello"; }


    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Employee getById(@PathParam("id") String id){
        return employeeService.getEmployee(Integer.parseInt(id));
    }

    @Path("/insert")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String add(Employee employee){
        /*Employee employee1 = new Employee();
        employee1.setId(1);
        employee1.setName("hello");
        employee1.setAddress("ktm");*/
        employeeService.addEmployee(employee);
        return (employee.getFirstName());
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Employee update(@PathParam("id")int id, Employee employee){
        employeeService.editEmployee(employee);
        return employee;
    }

    @Path("/{id}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public String delete(@PathParam("id")int id,Employee employee){
        employeeService.deleteEmployee(employee);
        return employee.toString()+"  deleted!!";
    }

}
