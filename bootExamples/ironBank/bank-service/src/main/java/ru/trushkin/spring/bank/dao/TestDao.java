package ru.trushkin.spring.bank.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.trushkin.spring.bank.models.TestEntity;

import java.util.List;

@Repository
public interface TestDao extends JpaRepository<TestEntity, Long> {

    default TestEntity getEntity() {
        List<TestEntity> all = findAll();
        return all.isEmpty() ? null : all.get(0);
    }
}
