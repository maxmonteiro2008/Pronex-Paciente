package com.mx.mobi_flm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Date;
import java.util.concurrent.locks.Lock;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Opcoes extends AppCompatActivity {
    private Context mContext;
    public static Paciente[] mPacientesArray = new Paciente[10];
    private ImageButton btn1, btn2, btn3, btn4;
    public static String[] pacientesid = new String[10];
    //Aux Members
    private final String[] doencas = {" ", " ", "Tuberculose ", "HIV ", " ", "Tuberculose e HIV ", " ", " ", " ", " ", " "};
    //Views members
    TextView textView2, textView4, textView6, textView7;
    Paciente mypaciente = new Paciente();
    String s;
    Timestamp ts, tsn;
    Date ds, dsn, dt;
    Lock mylock;
    private String uid = null;
    private Integer i = 0;
    private Integer j = 0;
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


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcoes);
        mContext = getApplicationContext();
        this.onStart();
        tsn = Timestamp.now();


        //Views connection ---------------------------------------------------------------------------------------------------------------------->
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        textView2 = findViewById(R.id.textview2);
        textView4 = findViewById(R.id.textView4);
        textView6 = findViewById(R.id.textView6);
        textView7 = findViewById(R.id.textView7);


        //<---------------------------Firebase---------------------------------------------------------->

        if (currentUser != null) {
            pacientesCollRef = FirebaseFirestore.getInstance().collection("pacientes");
            PacientRef = pacientesCollRef.document(currentUser.getUid());
            PacientRef.get().addOnCompleteListener(this, new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if (task.isSuccessful()) {
                        if (task.getResult().exists()) {
                            mypaciente = task.getResult().toObject(Paciente.class);
                            textView2.setText(task.getResult().getString("nome"));
                            Integer i = Integer.parseInt(task.getResult().get("doencas").toString());
                            textView4.setText(doencas[i]);
                            ts = task.getResult().getTimestamp("inictb");
                            ds = ts.toDate();
                            dsn = tsn.toDate();
                            long dlt = dsn.getTime() - ds.getTime();
                            dlt = dlt / (60 * 60 * 24 * 1000);
                            textView6.setText(Long.toString(dlt));
                            btn1.setVisibility(View.VISIBLE);
                            btn2.setVisibility(View.VISIBLE);
                            btn3.setVisibility(View.VISIBLE);
                            btn4.setVisibility(View.VISIBLE);
                            Log.i("DOCUMENT", "DocumentSnapshot data: " + task.getResult().getData().toString());
                        } else {
                            Log.i("DOCUMENT", "No such document");
                        }
                    } else {
                        Log.i("DOCUMENT", "get failed with ", task.getException());
                    }
                }
            });


        }

        btn1.setVisibility(View.INVISIBLE);
        btn2.setVisibility(View.INVISIBLE);
        btn3.setVisibility(View.INVISIBLE);
        btn4.setVisibility(View.INVISIBLE);
//  <-----------------------------------------------   UI   actions------------------------------------------------------------------------------------------------->
        //INformação
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mypaciente != null) {
                    textView2.setText(mypaciente.getNome() + mypaciente.getSobrenome());
                } else {
                    textView2.setText("error");
                }
            }
        });

        //Tomar Medicação
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent medIntent = new Intent(Opcoes.this, Medicacao.class);
                startActivity(medIntent);

            }
        });

        //Configurar horário medicação
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent hmed = new Intent(Opcoes.this, Hora.class);
                startActivity(hmed);
            }
        });


        //Como estou me asentindo
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mypaciente != null) {
                    textView2.setText(mypaciente.getNome() + mypaciente.getSobrenome());
                } else {
                    textView2.setText("Error");
                }
            }
        });


    }//onCreate
} //Activity
