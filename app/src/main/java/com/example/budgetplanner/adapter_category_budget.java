package com.example.budgetplanner;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class adapter_category_budget extends ArrayAdapter<category_budget> {
    public adapter_category_budget(Context context, ArrayList<category_budget> arr){
        super(context,R.layout.adapter_item_category_budgets, arr);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final category_budget category = getItem(position);
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_item_category_budgets,null);
        }
        ((TextView) convertView.findViewById(R.id.category_budget_name)).setText(category.category);
        ((TextView) convertView.findViewById(R.id.category_budget)).setText(Integer.toString((Math.round(category.planned_category_budget*100f))/100)+"₽");

        return convertView;
    }

}
