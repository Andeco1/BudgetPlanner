package com.example.budgetplanner;

import java.io.Serializable;
import java.util.ArrayList;

public class budget implements Serializable {
    public String name;
    public date start,end;
    public float planned_budget, left_budget;
    public String[] arrayOfCategories;
    public float[] arrayOfPlan;

    public budget(String nameOfBudget, String da1, String da2, float plan, String[] array_cat, float[] array_plan) {
        date da11 = new date(da1);
        date da22 = new date(da2);
        this.name = nameOfBudget;
        this.start = da11;
        this.end = da22;
        this.planned_budget = plan;
        this.left_budget = 0f;
        this.arrayOfCategories = array_cat;
        this.arrayOfPlan = array_plan;
    }



    public budget(String name,date start, date end, float planned_budget, float left_budget) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.planned_budget = planned_budget;
        this.left_budget = left_budget;
    }


    public String getPeriod() {
        return start.getString()+" - "+end.getString();
    }

    public String getBudgetTxt() {
        return Integer.toString(Math.round((planned_budget-left_budget)*100f)/100)+" / "+Integer.toString(Math.round(planned_budget*100f)/100);
    }

    public String getName() {
        return name;
    }




}
