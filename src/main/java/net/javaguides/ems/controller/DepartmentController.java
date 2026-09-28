package net.javaguides.ems.controller;

import jakarta.validation.Valid;
import net.javaguides.ems.dto.DepartmentDto;
import net.javaguides.ems.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController (DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@Valid @RequestBody DepartmentDto departmentDto) {
        DepartmentDto saved = departmentService.createDepartment(departmentDto);
        return new ResponseEntity<>(saved , HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments() {
        return new ResponseEntity<>(departmentService.getAllDepartment() , HttpStatus.OK);

    }

}
