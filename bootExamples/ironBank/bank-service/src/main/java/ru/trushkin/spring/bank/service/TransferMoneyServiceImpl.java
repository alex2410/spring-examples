package ru.trushkin.spring.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.trushkin.spring.bank.dao.MoneyDao;
import ru.trushkin.spring.bank.models.Bank;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Service
@Transactional
public class TransferMoneyServiceImpl implements TransferMoneyService {

    private MoneyDao moneyDao;
    private ProphetService prophetService;

    @Autowired
    public TransferMoneyServiceImpl(MoneyDao moneyDao, ProphetService prophetService) {
        this.moneyDao = moneyDao;
        this.prophetService = prophetService;
    }

    @Override
    public BigDecimal transferMoney(String name, BigDecimal amount) {
        Bank bank = moneyDao.getBank();
        if (bank.getAmount().compareTo(amount) >= 0 && prophetService.willSurvive(name)) {
            bank.credit(amount);
            return moneyDao.save(bank).getAmount();
        }
        return null;
    }
}
