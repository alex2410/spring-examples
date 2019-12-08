package ru.trushkin.spring.example.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.trushkin.spring.example.jpa.entity.Employee;
import ru.trushkin.spring.example.jpa.entity.EmployeeMongo;

import java.util.List;

@Repository
public interface EmployeeRepositoryMongo extends MongoRepository<EmployeeMongo, String> {

    EmployeeMongo findEmployeeByName(String name);
}
