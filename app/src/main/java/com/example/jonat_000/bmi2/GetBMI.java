package com.example.jonat_000.bmi2;

import java.text.DecimalFormat;

 /**
 * Created by jonat_000 on 1/22/2016.
 */
public class GetBMI {
    double bmi;

//method to calc bmi
    public double calcBmi(double w, double h) {
        DecimalFormat df = new DecimalFormat("#.00");


        bmi = (w / (h * h) * 10000);

        if (bmi >= 55) {

            w = w / 2.2046;
            h = h * 30.48;
            bmi = (w / (h * h) * 10000);

        }
        return Double.parseDouble(df.format(bmi));
    }

}
