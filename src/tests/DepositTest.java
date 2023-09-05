package tests;

import main.Deposit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class DepositTest {
    public Deposit deposit;
    @BeforeEach
    void setUp() {
        deposit = new Deposit("RUR", "Вклад",BigDecimal.valueOf(200));
    }

    @Test
    void getProductBalance() {
        assertEquals("RUR 200", deposit.getProductBalance().toString());
    }

    @Test
    void depositFunds() {
        deposit.depositFunds(BigDecimal.valueOf(100));
        assertEquals("RUR 300", deposit.getProductBalance().toString());
    }

    @Test
    void closeDeposit() {
        deposit.closeDeposit();
        assertEquals("RUR 0", deposit.getProductBalance().toString());
    }
}