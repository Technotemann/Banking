package tests;

import main.CreditCard;
import main.Deposit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CreditCardTest {
    public CreditCard creditCard;

    @BeforeEach
    void setUp() {
        creditCard = new CreditCard("RUR", "Кредитка", BigDecimal.valueOf(100), 5.00);
    }

    @Test
    void getProductBalance() {
        assertEquals("RUR 100", creditCard.getProductBalance().toString());
    }

    @Test
    void withdrawFunds() {
        creditCard.withdrawFunds(BigDecimal.valueOf(200));
        assertEquals("RUR -100", creditCard.getProductBalance().toString());
    }

    @Test
    void getProductDebt() {
        creditCard.withdrawFunds(BigDecimal.valueOf(300));
        assertEquals("RUR 200", creditCard.getProductDebt().toString());
    }

    @Test
    void depositFunds() {
        assertEquals("RUR 100", creditCard.getProductBalance().toString());
    }

}