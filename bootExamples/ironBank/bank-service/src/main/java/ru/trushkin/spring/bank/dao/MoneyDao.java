package ru.trushkin.spring.bank.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.trushkin.spring.bank.models.Bank;

import java.util.List;

@Repository
public interface MoneyDao extends JpaRepository<Bank, Long> {

    default Bank getBank() {
        List<Bank> all = findAll();
        return all.isEmpty() ? null : all.get(0);
    }
}
