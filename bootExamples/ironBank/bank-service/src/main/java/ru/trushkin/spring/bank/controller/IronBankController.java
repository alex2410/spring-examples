package ru.trushkin.spring.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.trushkin.spring.bank.dao.MoneyDao;
import ru.trushkin.spring.bank.dao.TestDao;
import ru.trushkin.spring.bank.models.Bank;
import ru.trushkin.spring.bank.models.TestEntity;
import ru.trushkin.spring.bank.service.TransferMoneyService;

import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;

@RestController
public class IronBankController {

    private MoneyDao moneyDao;
    private TestDao testDao;
    private TransferMoneyService transferMoneyService;

    @Autowired
    public IronBankController(MoneyDao moneyDao, TransferMoneyService transferMoneyService, TestDao testDao) {
        this.testDao = testDao;
        this.moneyDao = moneyDao;
        this.transferMoneyService = transferMoneyService;
    }

    @GetMapping("/credit")
    public String credit(@RequestParam String name, @RequestParam BigDecimal amount) {
        BigDecimal result = transferMoneyService.transferMoney(name, amount);
        if (result == null) {
            return "rejected to " + name;
        }
        return "Credit approved for " + name + ", bank balance" + result;
    }

    @GetMapping("/state")
    public BigDecimal state() {
        return moneyDao.getBank().getAmount();
    }

    @GetMapping("/bank")
    public BigDecimal create() {
        Bank bank = moneyDao.getBank();
        if (bank != null) {
            return bank.getAmount();
        }
        BigDecimal bigDecimal = new BigDecimal(ThreadLocalRandom.current().nextInt(1, 100));
        Bank b = new Bank();
        b.setAmount(bigDecimal);
        moneyDao.save(b);
        return bigDecimal;
    }

    @GetMapping("/test")
    public TestEntity createTest() {
        TestEntity testEntity = testDao.getEntity();
        if (testEntity != null) {
            testEntity.setAmount(testEntity.getAmount().multiply(BigDecimal.TEN));
            testDao.save(testEntity);
            return testEntity;
        }
        BigDecimal bigDecimal = new BigDecimal(ThreadLocalRandom.current().nextInt(1, 100));
        TestEntity b = new TestEntity();
        b.setAmount(bigDecimal);
        testDao.save(b);
        return b;
    }
}
