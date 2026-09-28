package net.javaguides.ems.service;

import net.javaguides.ems.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {

    DepartmentDto createDepartment (DepartmentDto departmentDto);

    List<DepartmentDto> getAllDepartment();


}
