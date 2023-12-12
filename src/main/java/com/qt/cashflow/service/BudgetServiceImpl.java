package com.qt.cashflow.service;


import com.qt.cashflow.entity.Budget;
import com.qt.cashflow.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetServiceImpl implements BudgetService
{

    @Autowired
    private BudgetRepository budgetRepository;

    @Override
    public List<Budget> getAllBudgets() {
        return budgetRepository.findAll();
    }

    @Override
    public String addbudget(Budget budget) {
        budgetRepository.save(budget);
        return "budget add successfull";
    }

    @Override
    public String updateBudget(long id, Budget updatedBudget) {
        Budget existingBudget = budgetRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Budget not found"));

        existingBudget.setFood(updatedBudget.getFood());
        existingBudget.setFuel(updatedBudget.getFuel());
        existingBudget.setGroceries(updatedBudget.getGroceries());
        existingBudget.setVegetables(updatedBudget.getVegetables());
        existingBudget.setToiletries(updatedBudget.getToiletries());
        existingBudget.setClothes(updatedBudget.getClothes());
        existingBudget.setTelephone_bill(updatedBudget.getTelephone_bill());
        existingBudget.setRoom_rents(updatedBudget.getRoom_rents());


        budgetRepository.save(existingBudget);
        return "Budget updated successfully";
    }

}























//    @Override
//    public Budget getBudgetById(long id) {
//        return budgetRepository.findById(id).orElse(null);
//    }
//
//    @Override
//    public Budget createBudget(Budget budget) {
//        return budgetRepository.save(budget);
//    }
//
//    @Override
//    public Budget updateBudget(long id, Budget budget) {
//        if (budgetRepository.existsById(id)) {
//            budget.setId(id);
//            return budgetRepository.save(budget);
//        } else {
//            return null; // Handle the case where the budget with the given id doesn't exist.
//        }
//    }
//
//    @Override
//    public void deleteBudget(long id) {
//        budgetRepository.deleteById(id);
//    }