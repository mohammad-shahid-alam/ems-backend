package net.javaguides.ems.service.impl;

import lombok.extern.slf4j.Slf4j;
import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.entity.Employee;
import net.javaguides.ems.exception.EmailAlreadyExistsException;
import net.javaguides.ems.exception.ResourceNotFoundException;
import net.javaguides.ems.mapper.EmployeeMapper;
import net.javaguides.ems.repository.EmployeeRepository;
import net.javaguides.ems.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        if(employeeRepository.existsByEmail(employeeDto.getEmail())) {
            throw new EmailAlreadyExistsException("Employee already exists with email : " + employeeDto.getEmail());
        }
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
       Employee savedEmployee = employeeRepository.save(employee);
       log.info("Saved employee with id : {}" , savedEmployee.getId());
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById (Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with given id " + employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public Page<EmployeeDto> getAllEmployees(int pageNo , int pageSize , String sortBy) {
        Pageable pageable = PageRequest.of(pageNo , pageSize , Sort.by(sortBy));
            Page <Employee> employees = employeeRepository.findAll(pageable);
        return employees.map(EmployeeMapper::mapToEmployeeDto);
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
       Employee employee =  employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee does not exists with given id" + employeeId)
        );
       employee.setFirstName(updatedEmployee.getFirstName());
       employee.setLastName(updatedEmployee.getLastName());
       employee.setEmail(updatedEmployee.getEmail());
       Employee updatedEmployeeObj = employeeRepository.save(employee);
        log.info("Updated employee with id: {}", employeeId);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }


    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee =  employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee does not exists with given id" + employeeId)
        );
        employeeRepository.deleteById(employeeId);
        log.info("Deleted employee with id: {}", employeeId);

    }
}
