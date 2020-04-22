package com.mx.mobi_flm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;

import androidx.appcompat.app.AppCompatActivity;

public class Hora extends AppCompatActivity {
    PendingIntent pendingIntent;
    AlarmManager alarmManager;
    //view members
    private TimePicker myTP;
    private Button btn1, btn2;
    private TextView tv;
    // Aux Members
    private Integer hour;
    private Integer minut;
    private Calendar myCalendar;
    // Firebase members
    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;
    private FirebaseFirestore db;
    private CollectionReference pacientesCollRef;
    private DocumentReference PacientRef;

    public void onStart() {
        super.onStart();
        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hora);

        onStart();

        myCalendar = Calendar.getInstance();
        //Views Binding
        tv = findViewById(R.id.text1);
        btn1 = findViewById(R.id.button1);
        myTP = findViewById(R.id.Timer1);


        tv.setText("Nada");
        btn1.setText("Selecione o Horário");

        /*--------------------------------------------------------ALARM_____________________------------------------------------->*/

        alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(Hora.this, Opcoes.class);
        pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    hour = myTP.getHour();
                    minut = myTP.getMinute();
                } else {
                    hour = myTP.getCurrentHour();
                    minut = myTP.getCurrentMinute();
                }


                tv.setText(new StringBuilder().append("Horário Escolhido:>").append(hour).append(":").append(minut));

                myCalendar.set(Calendar.HOUR_OF_DAY, hour);
                myCalendar.set(Calendar.MINUTE, minut);
                alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, myCalendar.getTimeInMillis(),
                        AlarmManager.INTERVAL_DAY, pendingIntent);

            }
        });


    }//oncreate
}//Class
