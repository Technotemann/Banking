package main;

import org.javamoney.moneta.Money;

import java.math.BigDecimal;

abstract public class AbstractCard extends AbstractProduct {
    AbstractCard(String unit, String name) {
        super(unit, name);
    }

    AbstractCard(String unit, String name, BigDecimal balance) {
        super(unit, name, balance);
    }

    /**
     * Метод выводит средства с карты
     *
     * @param funds - сумма вывода
     */
    public void withdrawFunds(BigDecimal funds) {
        if (funds.compareTo(BigDecimal.ZERO) >= 0 && writeLock.tryLock()) {
            try {
                productBalance = productBalance.subtract(Money.of(funds, productCurrencyUnit));
            } finally {
                writeLock.unlock();
            }
        } else {
            System.out.println("операция со счётом недоступна");
        }
    }
}