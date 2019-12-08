package ru.trushkin.spring.example.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.trushkin.spring.example.jpa.entity.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

    Employee findEmployeeByName(String name);
    List<Employee> findByName(String name);
}
