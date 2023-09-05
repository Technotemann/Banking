package main;

import org.javamoney.moneta.Money;

import javax.money.MonetaryAmount;
import java.math.BigDecimal;

public class CreditCard extends AbstractCard {
    protected Double productInterestRate;

    public CreditCard(String unit, String name, Double interest) {
        super(unit, name);
        productInterestRate = interest;
    }

    public CreditCard(String unit, String name, BigDecimal balance, Double interest) {
        super(unit, name, balance);
        productInterestRate = interest;
    }

    /**
     * Метод возращает задолженность по кредитной карте
     *
     * @return Money - задолженность
     */
    public MonetaryAmount getProductDebt() {
        if (this.getProductBalance().isNegative()) {
            return this.getProductBalance().abs();
        } else {
            return Money.of(0, this.getProductBalance().getCurrency());
        }
    }
}
