package ru.trushkin.spring.example.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.trushkin.spring.example.jpa.entity.EmployeeMongo;
import ru.trushkin.spring.example.jpa.repositories.EmployeeRepositoryMongo;
import ru.trushkin.spring.example.services.TestService;
import ru.trushkin.spring.example.services.TestServicePrototype;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.UUID;

@RequestMapping("/m")
@RestController
public class TestControllerMongo {

    private final EmployeeRepositoryMongo EmployeeMongoRepository;
    private final TestService testService;
    private final TestServicePrototype testServicePrototype;

    @Autowired
    public TestControllerMongo(TestService testService, TestServicePrototype testServicePrototype,
                               EmployeeRepositoryMongo EmployeeMongoRepository) {
        this.EmployeeMongoRepository = EmployeeMongoRepository;
        this.testService = testService;
        this.testServicePrototype = testServicePrototype;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index() {
        return testService.sayTest() + testServicePrototype.sayTest();
    }

    @GetMapping(value = "/create")
    public String create(@RequestParam String name) {
        EmployeeMongo e = new EmployeeMongo();
        e.setId(UUID.randomUUID().toString());
        e.setName(name);
        EmployeeMongoRepository.save(e);
        return e.getId();
    }

    @GetMapping(value = "/all")
    public List<EmployeeMongo> all() {
        return EmployeeMongoRepository.findAll();
    }


    @GetMapping(value = "/byName2")
    public EmployeeMongo byName2(@RequestParam String name) {
        return EmployeeMongoRepository.findEmployeeByName(name);
    }

    @PostConstruct
    public void init() {
        System.out.println("constructed");
    }
}
