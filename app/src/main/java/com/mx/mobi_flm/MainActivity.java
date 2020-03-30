package com.mx.mobi_flm;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import java.lang.Integer;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;


public class MainActivity extends AppCompatActivity {

//Views members
private Button btn1, btn2;
    TextView textView1, textView2,textView3,textView4;
    ListView listview1;
    //aux members
    private String[] pacientes=new String[10];
    Integer i=0;
    Integer j=0;
    User mUser1, mUser2,mUser3;
    private User[] mUserArray= new User[10];
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
        textView3= findViewById(R.id.textView3);
        textView4= findViewById(R.id.textView4);
        //listview1=(ListView) findViewById(R.id.listview1);

       //textView1= findViewById(R.id.textview1);
       //Firebase
        db = FirebaseFirestore.getInstance();
        myRef=db.collection("Users");

        myRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : Objects.requireNonNull(task.getResult())) {
                        Log.i("FIREBASE", i.toString()+ ":"+ document.getId() + " => " +document.getData());
                        mUserArray[i]=document.toObject(User.class);
                        Log.i("DAO", mUserArray[i].toString());
                        pacientes[i++]= document.getId();
                    }
                } else {
                    Log.i("FIREBASE", "Error getting documents", task.getException());
                }
            }
        });

        // LIST VIEW

      /* if(pacientes[0]!= null) {
           ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this,R.layout.activity_listview, R.id.list_item,pacientes);
           listview1.setAdapter(myAdapter);
       }*/

     //  <---------------------------------------------------- View ACTIONS_---------------------------------------->

      btn1.setOnClickListener(new View.OnClickListener() {
          @SuppressLint("SetTextI18n")
          public void onClick(View v) {
              if(j<i){
                  textView2.setText(pacientes[j]);
                  textView3.setText(mUserArray[j].getNickname());
                  textView4.setText(mUserArray[j].getTransactions().toString());
                  j++;
              }
              else{
                  textView2.setText(pacientes[0]);
                  textView3.setText(mUserArray[0].getNickname());
                  textView4.setText(mUserArray[0].getTransactions().toString());
              }
          }


      });
    }
}
