package com.qt.cashflow.controller;


import com.qt.cashflow.entity.Expense;
import com.qt.cashflow.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/get")
    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    @PutMapping("/{id}")
    public String updateExpense(@PathVariable Long id, @RequestBody Expense expense) {
        return expenseService.updateExpense(id, expense);
    }

    @PostMapping("/addexpense")
    public Expense addExpense(@RequestBody Expense expense) {
        return expenseService.addExpense(expense);
    }


}
















//    @GetMapping("/{id}")
//    public Expense getExpenseById(@PathVariable Long id) {
//        return expenseService.getExpenseById(id);
//    }


//
//    @DeleteMapping("/{id}")
//    public void deleteExpense(@PathVariable Long id) {
//        expenseService.deleteExpense(id);
//    }