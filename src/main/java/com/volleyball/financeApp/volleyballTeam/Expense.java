package com.volleyball.financeApp.volleyballTeam;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

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
    @OneToMany
    private List<AccountExpense> accountExpenses;
    public Expense() {
       // payments = new LinkedList<Payment>();
        //accountExpenses = new LinkedList<AccountExpense>();
    }

    Expense(String title, float overallPrice) {
        this.title = title;
        this.overallPrice = overallPrice;
        payments = new LinkedList<Payment>();
    }

    long getExpenseNumber() {
        return expenseNumber;
    }
}
