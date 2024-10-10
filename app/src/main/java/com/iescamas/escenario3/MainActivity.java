package com.iescamas.escenario3;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    RadioButton rb1,rb2,rb3;
    SwitchCompat swc;
    Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        swc = findViewById(R.id.swc_Onoff);
        sp = findViewById(R.id.sp_opciones);

        sp.setVisibility(View.INVISIBLE);
        swc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    sp.setVisibility(View.VISIBLE);
                    cambiaSpinner();
                }
                else{
                    sp.setVisibility(View.INVISIBLE);
                    rb1.setText(R.string.elemento1_off);
                    rb2.setText(R.string.elemento2_off);
                    rb3.setText(R.string.elemento3_off);
                }

            }
        });

    }
    private void cambiaSpinner(){

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.opciones_on, android.R.layout.simple_spinner_item);
        sp.setAdapter(adapter);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (i == 0){
                    rb1.setText(R.string.elemento1_1on);
                    rb2.setText(R.string.elemento1_2on);
                    rb3.setText(R.string.elemento1_3on);
                }
                else {
                    rb1.setText(R.string.elemento2_1on);
                    rb2.setText(R.string.elemento2_2on);
                    rb3.setText(R.string.elemento2_3on);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}