package com.volleyball.financeApp.entity;

import javax.persistence.*;
import java.time.LocalDate;

// @ not entity but what??
@Entity
@Table
public class Payment {
    @Id
    @SequenceGenerator(
            name = "payment_sequence",
            sequenceName = "payment_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "payment_sequence"
    )
    private long paymentNumber;
   // @Temporal(TemporalType.DATE)
    private LocalDate date;

    @ManyToOne
    private Expense expense;
    private float amount;
    private String note;
    Payment() {
        date = LocalDate.now();

    }

    Payment(float amount) {
        this.amount = amount;
        date = LocalDate.now();
    }
}
