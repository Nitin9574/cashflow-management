package com.qt.cashflow.service;


import com.qt.cashflow.entity.Expense;

import java.util.List;

public interface ExpenseService {
    List<Expense> getAllExpenses();

    Expense addExpense(Expense expense);

    String updateExpense(Long id, Expense expense);
}


















//    String addexpense(Expense expense);
//    Expense getExpenseById(Long id);

//    Expense updateExpense(Long id, Expense expense);
//    void deleteExpense(Long id);