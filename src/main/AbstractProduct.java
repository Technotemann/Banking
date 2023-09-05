package main;

import org.javamoney.moneta.Money;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import java.math.BigDecimal;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

abstract public class AbstractProduct {
    protected ReadWriteLock lock = new ReentrantReadWriteLock();
    protected Lock writeLock = lock.writeLock();
    protected CurrencyUnit productCurrencyUnit;
    protected volatile MonetaryAmount productBalance;
    protected String productName;

    AbstractProduct(String unit, String name) {
        productCurrencyUnit = Monetary.getCurrency(unit);
        productBalance = Money.of(0, productCurrencyUnit);
        productName = name;
    }

    AbstractProduct(String unit, String name, BigDecimal balance) {
        productCurrencyUnit = Monetary.getCurrency(unit);
        productBalance = Money.of(balance, productCurrencyUnit);
        productName = name;
    }

    /**
     * Метод возвращает значение баланса продукта
     *
     * @return MonetaryAmount - значение баланса
     */
    public MonetaryAmount getProductBalance() {
        return this.productBalance;
    }

    /**
     * Метод пополняет баланс продукта
     *
     * @param funds - сумма пополнения
     */
    public void depositFunds(BigDecimal funds) {
        if (funds.compareTo(BigDecimal.ZERO) >= 0 && writeLock.tryLock()) {
            try {
                productBalance = productBalance.add(Money.of(funds, productCurrencyUnit));
            } finally {
                writeLock.unlock();
            }
        } else {
            System.out.println("операция со счётом недоступна");
        }
    }
}
