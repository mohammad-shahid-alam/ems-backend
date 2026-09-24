package net.javaguides.ems.service;

import net.javaguides.ems.dto.EmployeeDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);

    Page<EmployeeDto> getAllEmployees(int pageNo , int pageSize , String sortBy);

    EmployeeDto updateEmployee(Long employeeId ,EmployeeDto updatedEmployee);

     void deleteEmployee(Long employeeId);

}
