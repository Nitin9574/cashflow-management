package com.qt.cashflow.controller;

import com.qt.cashflow.entity.Budget;
import com.qt.cashflow.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/budgets")
public class BudgetController {

    @Autowired
    BudgetService budgetService;

    @GetMapping("/get")
    public List<Budget> getAllBudgets() {
        System.out.println("test vhjvdsjchyvbd");
        return budgetService.getAllBudgets();

    }

    @PutMapping("/{id}")
    public String updateBudget(@PathVariable long id, @RequestBody Budget budget) {
        return budgetService.updateBudget(id, budget);
    }



    @PostMapping("/add")
    public String addbudget(@RequestBody Budget budget) {
        return budgetService.addbudget(budget);
    }


}
















//    @GetMapping("/{id}")
//    public Budget getBudgetById(@PathVariable long id) {
//        return budgetService.getBudgetById(id);
//    }









//
//    @DeleteMapping("/{id}")
//    public void deleteBudget(@PathVariable long id) {
//        budgetService.deleteBudget(id);
//    }