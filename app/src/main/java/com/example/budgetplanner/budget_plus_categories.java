package com.example.budgetplanner;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;

public class budget_plus_categories implements Serializable {
    budget Budget;
    ArrayList<category_budget> category_budgets;

    public budget_plus_categories(budget budget, ArrayList<category_budget> category_budgets) {
        this.Budget = budget;
        this.category_budgets = category_budgets;
    }

    public budget getBudget() {
        return Budget;
    }
}
