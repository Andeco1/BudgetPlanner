package com.example.budgetplanner;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.ObjectInputStream;
import java.util.ArrayList;

public class main_menu extends AppCompatActivity {
    ArrayList<budget> all_budgets = new ArrayList<budget>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        Intent i = new Intent(main_menu.this, createNewBudget.class);

        Button add_budget = findViewById(R.id.create_budget);
        add_budget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
            }
        });

        ListView budgets =  findViewById(R.id.budgets);
        adapter_budget adapt = new adapter_budget(main_menu.this, all_budgets);
        budgets.setAdapter(adapt);

        Bundle arguments = getIntent().getExtras();
        budget newBuPlCa;
        if(arguments!=null){
            String nameOfBudget = arguments.get("name").toString();
            String da1 = arguments.get("start").toString();
            String da2 = arguments.get("end").toString();
            float plan = arguments.getFloat("plan");
            String[] arrayofcat= arguments.getStringArray("cate");
            float[] arrayofplan = arguments.getFloatArray("plans");
            newBuPlCa = new budget(nameOfBudget,da1,da2,plan,arrayofcat,arrayofplan);
            all_budgets.add(newBuPlCa);
            adapt.notifyDataSetInvalidated();
        }else {
            adapt.notifyDataSetInvalidated();
        }
//        date da1 = new date("12.02.23");
//        budget bud = new budget("fjej",da1,da1,100000f,0f);
//        ArrayList<category_budget> j = new ArrayList<>();
//        budget_plus_categories newBudget = new budget_plus_categories(bud,j);



    }
}
