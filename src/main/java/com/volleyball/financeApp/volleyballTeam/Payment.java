package com.volleyball.financeApp.volleyballTeam;

import javax.persistence.Table;
import java.time.LocalDate;

// @ not entity but what??
@Table
public class Payment {
    private LocalDate date;
    private float amount;
    private String note;

    Payment(float amount) {
        this.amount = amount;
        date = LocalDate.now();
    }
}
