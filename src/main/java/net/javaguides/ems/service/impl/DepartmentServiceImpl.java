package net.javaguides.ems.service.impl;

import net.javaguides.ems.dto.DepartmentDto;
import net.javaguides.ems.entity.Department;
import net.javaguides.ems.repository.DepartmentRepository;
import net.javaguides.ems.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl (DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }


    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department = new Department(departmentDto.getId() , departmentDto.getName());
        Department saved = departmentRepository.save(department);
        return new DepartmentDto(saved.getId(), saved.getName());
    }

    @Override
    public List<DepartmentDto> getAllDepartment() {
        return departmentRepository.findAll()
                .stream()
                .map(dep -> new DepartmentDto(dep.getId() , dep.getName()))
                .collect(Collectors.toList());
    }
}
