package com.example.jonat_000.bmi2;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;


public class BMI extends AppCompatActivity {

    final Context context = this;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        final EditText height = (EditText) findViewById(R.id.heightCM);
        final EditText weight = (EditText) findViewById(R.id.weightKG);
        final TextView resultBMI = (TextView) findViewById(R.id.resultBMI);
        final CheckBox activeCheck = (CheckBox) findViewById(R.id.checkBox);
        Button button = (Button) findViewById(R.id.bmiBtn);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        resultBMI.setTextColor(Color.BLACK);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                height.clearComposingText();


                weight.setHint("Enter Weight in KG");
                height.setHint("Enter Height in CM");



                // check for null
                if (weight.getText().toString().length() < 1) {
                    sendToast("Enter Weight");
                    return;
                }
                if (height.getText().toString().length() < 1) {
                    sendToast("Enter Height");
                    return;
                }

                double h = Float.valueOf(height.getText().toString());
                double w = Float.valueOf(weight.getText().toString());

                GetBMI s = new GetBMI();

                double BMI = s.calcBmi(w, h);

               // if (BMI <= 24 && BMI >= 18) {
                //    resultBMI.setTextColor(Color.GREEN);
               // }
               // if (BMI >= 25 && BMI <= 29) {
               //     resultBMI.setTextColor(Color.YELLOW);
               // }
               // if (BMI >= 30 && BMI <= 54) {
                //    resultBMI.setTextColor(Color.RED);
               // }

                if (activeCheck.isChecked()) {

                    if (BMI >= 21 && BMI <= 27.99) {
                        resultBMI.setTextColor(Color.GREEN);
                    } else if (BMI >= 28 && BMI <= 32.99) {
                        resultBMI.setTextColor(Color.YELLOW);
                    } else if (BMI >= 33 && BMI <= 55) {
                        resultBMI.setTextColor(Color.RED);
                    } else {
                        resultBMI.setTextColor(Color.BLACK);
                    }
                } else {

                    if (BMI >= 18 && BMI <= 24.99) {
                        resultBMI.setTextColor(Color.GREEN);
                    } else if (BMI >= 25 && BMI <= 29.99) {
                        resultBMI.setTextColor(Color.YELLOW);
                    } else if (BMI >= 30 && BMI <= 55) {
                        resultBMI.setTextColor(Color.RED);
                    } else {
                        resultBMI.setTextColor(Color.BLACK);
                    }
                }
                resultBMI.setText(String.valueOf(BMI));

                // set bmi colour here





            }

        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    public void sendToast(String msg) {
        CharSequence text = msg;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bmi, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "BMI Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.jonat_000.bmi2/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "BMI Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.jonat_000.bmi2/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
