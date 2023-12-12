package com.qt.cashflow.service;


import com.qt.cashflow.entity.Expense;
import com.qt.cashflow.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    @Override
    public Expense addExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    @Override
    public String updateExpense(Long id, Expense expense) {
        Optional<Expense> existingExpenseOptional = expenseRepository.findById(id);

        if (existingExpenseOptional.isPresent()) {
            Expense existingExpense = existingExpenseOptional.get();

            existingExpense.setId(expense.getId());
            existingExpense.setClothes(expense.getClothes());
            existingExpense.setFuel(expense.getFuel());
            existingExpense.setFood(expense.getFood());
            existingExpense.setGroceries(expense.getGroceries());
            existingExpense.setRoom_rents(expense.getRoom_rents());
            existingExpense.setTelephone_bill(expense.getTelephone_bill());
            existingExpense.setVegetables(expense.getVegetables());
            existingExpense.setToiletries(expense.getToiletries());

            expenseRepository.save(existingExpense);
            return "Expense updated successfully";
        } else {
            throw new IllegalArgumentException("Expense not found");
        }
    }
}



























//    @Override
//    public String addexpense(Expense expense) {
//        expenseRepository.save(expense);
//        return " expense added succesfully";
//    }
//
//    @Override
//    public Expense getExpenseById(Long id) {
//        return expenseRepository.findById(id).orElse(null);
//    }

//@Override
//    public Expense updateExpense(Long id, Expense expense) {
//        if (expenseRepository.existsById(id)) {
//            expense.setId(id);
//            return expenseRepository.save(expense);
//        } else {
//            return null; // Handle the case where the expense with the given id doesn't exist.
//        }
//    }
//
//    @Override
//    public void deleteExpense(Long id) {
//        expenseRepository.deleteById(id);
//    }