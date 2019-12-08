package ru.trushkin.spring.example.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.trushkin.spring.example.jpa.entity.Employee;
import ru.trushkin.spring.example.jpa.repositories.EmployeeRepository;
import ru.trushkin.spring.example.services.TestService;
import ru.trushkin.spring.example.services.TestServicePrototype;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.UUID;

@RestController
public class TestController {

    private final EmployeeRepository employeeRepository;
    private final TestService testService;
    private final TestServicePrototype testServicePrototype;

    @Autowired
    public TestController(TestService testService, TestServicePrototype testServicePrototype, EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
        this.testService = testService;
        this.testServicePrototype = testServicePrototype;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index() {
        return testService.sayTest() + testServicePrototype.sayTest();
    }

    @GetMapping(value = "/create")
    public String create(@RequestParam String name) {
        Employee e = new Employee();
        e.setId(UUID.randomUUID().toString());
        e.setName(name);
        employeeRepository.save(e);
        return e.getId();
    }

    @GetMapping(value = "/all")
    public List<Employee> all() {
       return employeeRepository.findAll();
    }

    @GetMapping(value = "/byName")
    public List<Employee> byName(@RequestParam String name) {
        return employeeRepository.findByName(name);
    }

    @GetMapping(value = "/byName2")
    public Employee byName2(@RequestParam String name) {
        return employeeRepository.findEmployeeByName(name);
    }

    @PostConstruct
    public void init() {
        System.out.println("constructed");
    }
}
