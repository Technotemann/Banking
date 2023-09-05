package main;

import java.math.BigDecimal;

public class DebitСard extends AbstractCard {

    public DebitСard(String unit, String name) {
        super(unit, name);
    }

    public DebitСard(String unit, String name, BigDecimal balance) {
        super(unit, name, balance);
    }
}
