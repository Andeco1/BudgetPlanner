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

public class adapter_budget extends ArrayAdapter<budget> {
    public adapter_budget(Context context, ArrayList<budget> arr){
        super(context,R.layout.adapter_item_budgets, arr);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final budget budget1 = getItem(position);
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_item_budgets,null);
        }
        ((TextView) convertView.findViewById(R.id.budget_name)).setText(budget1.getName());
        ((TextView) convertView.findViewById(R.id.budget_period)).setText((budget1.getPeriod()));
        ((TextView) convertView.findViewById(R.id.budget)).setText(budget1.getBudgetTxt());

        return convertView;
    }

}
