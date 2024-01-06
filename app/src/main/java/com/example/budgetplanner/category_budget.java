package com.example.budgetplanner;

import java.io.Serializable;

public class category_budget implements Serializable {
    public String category;
    public float planned_category_budget, left_category_budget;

    public category_budget(String category, float planned_category_budget, float left_category_budget) {
        this.category = category;
        this.planned_category_budget = planned_category_budget;
        this.left_category_budget = left_category_budget;
    }

    public float getPlanned_category_budget() {
        return planned_category_budget;
    }

    public String getCategory() {
        return category;
    }

    public float getLeft_category_budget() {
        return left_category_budget;
    }
}
