package main;

import java.math.BigDecimal;

public class Deposit extends AbstractProduct {

    public Deposit(String unit, String name) {
        super(unit, name);
    }

    public Deposit(String unit, String name, BigDecimal balance) {
        super(unit, name, balance);
    }

    /**
     * Метод осуществляет закрытие вклада посредством обнуления баланса
     */
    public void closeDeposit() {
        if (writeLock.tryLock()) {
            try {
                productBalance = productBalance.multiply(0);
            } finally {
                writeLock.unlock();
            }
        }
    }
}
