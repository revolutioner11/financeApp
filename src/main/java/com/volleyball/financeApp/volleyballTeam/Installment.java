package com.volleyball.financeApp.volleyballTeam;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Installment {
    @Id
    @SequenceGenerator(
            name = "installment_sequence",
            sequenceName = "installment_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "installment_sequence"
    )
    private long installmentNumber;

    @ManyToOne  // check if correct?
    private BankAccount bankAccount;

    private  float amount;
    private String reason;
    private String adminNote;
    private String additionalPayers;
    private LocalDate date;

    public Installment() {
        date = LocalDate.now();
    }

    Installment(BankAccount bankAccount, float amount) {
        this.bankAccount = bankAccount;
        this.amount = amount;
        date = LocalDate.now();
    }
}
