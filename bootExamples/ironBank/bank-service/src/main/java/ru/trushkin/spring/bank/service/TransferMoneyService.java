package ru.trushkin.spring.bank.service;

import java.math.BigDecimal;

public interface TransferMoneyService {
    BigDecimal transferMoney(String name, BigDecimal amount);
}
