package net.javaguides.ems.repository;

import net.javaguides.ems.entity.Employee;
import net.javaguides.ems.projection.EmployeeNameEmailView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee , Long> {

    boolean existsByEmail(String email);
    List<EmployeeNameEmailView> findByDepartmentId(Long departmentId);

}
