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


public class MainActivity extends AppCompatActivity {

//Views members
private Button btn1, btn2;
    TextView textView1, textView2;

    //aux members
    private String[] pacientes=new String[10];
    Integer i=0;

// Firebase members
    private FirebaseFirestore db;
    private CollectionReference myRef ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //CustomListAdapter myAdapter = new CustomListAdapter(this, R.layout.activity_main,this,imageArray,titleArray,infoArray);
        //ArrayAdapter myAdapter = new ArrayAdapter<String>(this,R.layout.activity_main,titleArray);
        //Views connection
        btn1 = findViewById(R.id.button1);
       textView2= findViewById(R.id.textview2);

       //Firebase
        //db = FirebaseFirestore.getInstance();
        myRef=db.collection("Users");
        myRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
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
              textView2.setText(pacientes[i]);
          }


      });
    }
}
