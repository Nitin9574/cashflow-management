package com.qt.cashflow.service;


import com.qt.cashflow.entity.Budget;

import java.util.List;

public interface BudgetService {
    List<Budget> getAllBudgets();
    String addbudget(Budget budget);

    String updateBudget(long id, Budget budget);
}






























//    Budget getBudgetById(long id);
//    Budget createBudget(Budget budget);
//    Budget updateBudget(long id, Budget budget);
//    void deleteBudget(long id);