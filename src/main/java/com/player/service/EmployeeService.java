//package com.player.service;
//
//import java.util.List;
//
//import com.player.model.Department;
//import com.player.model.Employee;
//import com.player.repository.DepartmentRepository;
//import com.player.repository.EmployeeRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class EmployeeService {
//    @Autowired
//    private EmployeeRepository employeeRepository;
//    @Autowired
//    private DepartmentRepository departmentRepository;
//
//    public List<Employee> getAllEmployees() {
//        return employeeRepository.findAll();
//    }
//    public Employee addEmployee(Employee employee) {
//        Department dept = departmentRepository.findById(employee.getDepartment().getId()).orElse(null);
//        if (null == dept) {
//            dept = new Department();
//        }
//        dept.setDeptName(employee.getDepartment().getDeptName());
//        employee.setDepartment(dept);
//        return employeeRepository.save(employee);
//    }
//    public Employee editEmployees(Employee entity) {
//        return employeeRepository.save(entity);
//    }
//    public void deleteEmployees(Integer id) {
//        employeeRepository.deleteById(id);
//    }
//}
