package com.volleyball.financeApp.volleyballTeam;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table
public class Expense {
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
    private long expenseNumber;
    private  String title;
    private float overallPrice;
    private float paid;
    private float leftToPay;
    private  String adminNote;
    @OneToMany
    private List<Payment> payments;
    // account expenses list??
    public Expense() {
        payments = new LinkedList<Payment>();
    }

    Expense(String title, float overallPrice) {
        this.title = title;
        this.overallPrice = overallPrice;
        payments = new LinkedList<Payment>();
    }
}
