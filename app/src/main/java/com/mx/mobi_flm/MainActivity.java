package com.mx.mobi_flm;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import java.lang.Integer;
import android.os.Bundle;
import android.util.Log;

import android.view.View;
import android.widget.Button;

import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class MainActivity extends AppCompatActivity {

//Views members
private Button btn1, btn2;
    TextView textView1, textView2;

    //aux members
    private String[] pacientes=new String[10];
    Integer i=0;
    Integer j=0;

// Firebase members
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;
    private CollectionReference myRef ;
    private DocumentReference myDoc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Views connection
        btn1 = findViewById(R.id.button1);
       textView2= findViewById(R.id.textview2);

       //Firebase
        db = FirebaseFirestore.getInstance();
        myRef=db.collection("Users");
        myDoc=myRef.document("Latussa");

        myRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : Objects.requireNonNull(task.getResult())) {
                        Log.i("FIREBASE", i.toString()+ ":"+ document.getId() + " => " +document.getData());
                        pacientes[i++]= document.getId();
                    }
                } else {
                    Log.i("FIREBASE", "Error getting documents", task.getException());
                }
            }
        });

      btn1.setOnClickListener(new View.OnClickListener() {
          public void onClick(View v) {
              if(j<i){
                  textView2.setText(pacientes[j]);
                  j++;
              }
              else{
                  textView2.setText(pacientes[0]);
              }
          }


      });
    }
}
