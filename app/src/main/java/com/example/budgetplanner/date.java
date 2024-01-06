package com.example.budgetplanner;

import android.widget.Toast;

public class date {
    public int date,month, year;

    public date(String s) {

        this.date = Character.getNumericValue(s.charAt(0))*10+ Character.getNumericValue(s.charAt(1));;
        this.month = Character.getNumericValue(s.charAt(3))*10+ Character.getNumericValue(s.charAt(4));;
        this.year = Character.getNumericValue(s.charAt(6))*10+ Character.getNumericValue(s.charAt(7));;
    }

    public String getString(){
        return Integer.toString(date)+"."+Integer.toString(month)+"."+Integer.toString(year);
    }





}
