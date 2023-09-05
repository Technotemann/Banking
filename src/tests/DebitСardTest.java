package tests;

import main.DebitСard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class DebitCardTest {
    public DebitСard debitCard;

    @BeforeEach
    void setUp() {
        debitCard = new DebitСard("RUR", "Депозит", BigDecimal.valueOf(200));
    }

    @Test
    void getProductBalance() {
        assertEquals("RUR 200", debitCard.getProductBalance().toString());
    }

    @Test
    void withdrawFunds() {
        debitCard.withdrawFunds(BigDecimal.valueOf(100));
        assertEquals("RUR 100", debitCard.getProductBalance().toString());
    }

    @Test
    void depositFunds() {
        debitCard.depositFunds(BigDecimal.valueOf(100));
        assertEquals("RUR 300", debitCard.getProductBalance().toString());
    }
}