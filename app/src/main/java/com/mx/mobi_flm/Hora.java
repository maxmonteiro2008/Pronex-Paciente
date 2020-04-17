package com.mx.mobi_flm;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

public class Hora extends AppCompatActivity {

    TimePicker myTP;
    Button btn1, btn2;

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hora);

        tv = findViewById(R.id.text1);
        btn1 = findViewById(R.id.button1);
        myTP = findViewById(R.id.Timer1);

        tv.setText("Nada");
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tv.setText("DEU MEU");
            }
        });

    }
}
