package com.example.budgetplanner;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class createNewBudget extends AppCompatActivity {
    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Double.parseDouble(s);
            return false;
        } catch (NumberFormatException e){
            return true;

        }
    }

    public Boolean monthCh(int da, int mo){
        if(mo == 1 || mo == 3 || mo == 5 || mo == 7 || mo == 8 || mo == 10 || mo == 12){
            if(da>0 && da<=31){
                return true;
            }
            return false;
        }
        if(mo == 4 || mo == 6 || mo == 9 || mo == 11){
            if(da>0 && da<=30){
                return true;
            }
            return false;
        }
        if(mo==2){
            if(da>0 && da<=29){
                return true;
            }
            return false;
        }
        return false;
    }
    public int check(String s){
        if ((s.length() - s.replace(".","").length())!=2 || s.length()!=8){
            return 1;
        }
        char tchk = s.charAt(2);
        if(tchk != '.'){
            return 1;
        }
        tchk = s.charAt(5);
        if(tchk != '.'){
            return 1;
        }

        for(int i = 0; i<8; i++){
            if(i==2 || i == 5){continue;}
            if(s.charAt(i)>'9' || s.charAt(i)<'0'){
                return 1;
            }
        }

        int da = Character.getNumericValue(s.charAt(0))*10+ Character.getNumericValue(s.charAt(1));
        int mo = Character.getNumericValue(s.charAt(3))*10+ Character.getNumericValue(s.charAt(4));

        if(!monthCh(da,mo)){
            return 1;
        }

        return 0;
    }
    public String[] catToArr(ArrayList<category_budget> a){
        String[] array = new String[a.size()];
        for(int i =0; i<a.size();i++){
            array[i]=a.get(i).getCategory();
        }
        return array;
    }
    public float[] planToArr(ArrayList<category_budget> a){
        float[] array = new float[a.size()];
        for(int i =0; i<a.size();i++){
            array[i]=a.get(i).getPlanned_category_budget();
        }
        return array;
    }
    ArrayList<category_budget>  categories_arr = new ArrayList<category_budget>();



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_new_budget);


        ListView categories =  findViewById(R.id.categories);
        adapter_category_budget adapter = new adapter_category_budget(createNewBudget.this, categories_arr);
        categories.setAdapter(adapter);
        categories.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                category_budget selectedBudget = categories_arr.get(position);
                categories_arr.remove(selectedBudget);
                Toast.makeText(createNewBudget.this, "Категория удалена", Toast.LENGTH_SHORT).show();
                adapter.notifyDataSetInvalidated();
            }
        });
        
        Button add_category = findViewById(R.id.add_category);
        EditText category_name =findViewById(R.id.et_category_name);
        EditText category_price = findViewById(R.id.et_category_price);

        add_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = category_name.getText().toString();
                String price = category_price.getText().toString();
                if(name == null || price == null || name == "" || price == "" ){
                    Toast.makeText(createNewBudget.this, "Заполните все поля для ввода", Toast.LENGTH_SHORT).show();
                }else if(name.length()<=2){
                    Toast.makeText(createNewBudget.this, "Название категории должно быть больше двух символов", Toast.LENGTH_SHORT).show();
                } else if(isDigit(price)){
                        Toast.makeText(createNewBudget.this, "Введённая сумма не является вещественным числом", Toast.LENGTH_SHORT).show();
                }else{
                    category_budget categoryBudget = new category_budget(name,Float.parseFloat(price),0f);
                    categories_arr.add(categoryBudget);
                    adapter.notifyDataSetInvalidated();

                }
            }


        });

        EditText budget_name = findViewById(R.id.budget_name);
        EditText start_of_budget = findViewById(R.id.start_period);
        EditText end_of_budget = findViewById(R.id.end_period);


        Button create_new_budget = findViewById(R.id.save_budget);
        create_new_budget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = budget_name.getText().toString();
                String startOfPeriod = start_of_budget.getText().toString();
                String endOfPeriod = end_of_budget.getText().toString();

                

                
                if(name == null || name == "" || startOfPeriod == null || startOfPeriod == ""|| endOfPeriod ==null || endOfPeriod == ""){
                    Toast.makeText(createNewBudget.this, "Заполните все поля", Toast.LENGTH_SHORT).show();
                } else if (check(startOfPeriod)==1 || check(endOfPeriod)==1) {
                    Toast.makeText(createNewBudget.this, "Неправильно введённое значение", Toast.LENGTH_SHORT).show();
                } else{
                    float planned_budget = 0;
                    for(int i = 0; i<(int)categories_arr.size();i++){
                        planned_budget+= categories_arr.get(i).planned_category_budget;

                    }

                    Intent intent = new Intent(createNewBudget.this, main_menu.class);
                    date stOfPe = new date(startOfPeriod);
                    date enOfPe = new date(endOfPeriod);
                    intent.putExtra("name",name);
                    intent.putExtra("start",stOfPe.getString());
                    intent.putExtra("end",enOfPe.getString());
                    intent.putExtra("plan",planned_budget);
                    intent.putExtra("cate",catToArr(categories_arr));
                    intent.putExtra("plans",planToArr(categories_arr));
                    startActivity(intent);

                }
            }
        });



    }
}
