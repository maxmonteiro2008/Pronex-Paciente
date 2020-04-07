package com.mx.mobi_flm;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import androidx.appcompat.app.AppCompatActivity;

public class Opcoes extends AppCompatActivity {
    TextView textView1, textView2, textView3, textView4;
    //Views members
    private ImageButton btn1, btn2, btn3, btn4;
    // Firebase members
    private FirebaseAuth mAuth;
    private FirebaseUser fbuser;
    private FirebaseFirestore db;
    private CollectionReference myRef;
    private DocumentReference myDoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcoes);

        //Views connection
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        textView2 = findViewById(R.id.textview2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textView2.setText("Fulano");
        textView3.setText("Diabetes");
        textView4.setText("0");
        textView4 = findViewById(R.id.textView4);


    }
}
