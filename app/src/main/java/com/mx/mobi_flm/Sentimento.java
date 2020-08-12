package com.mx.mobi_flm;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;
import java.util.Date;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Sentimento extends AppCompatActivity {

    //Aux members
    Integer msentimento, msintoma = 0;
    Calendar calendar;
    FirebaseAuth mAuth;
    FirebaseUser currentUser;
    FirebaseFirestore db;
    CollectionReference sentimento;
    //View Members
    private SwitchMaterial cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8, cb9, cb10, cb11, cb12, cb13, cb14, cb15, cb16;

    // FireBase member
    private Button btn1;
    private TextView txv1, txv2, txv3, txv4;
    private SeekBar skb1;
    private ImageView img1, img2, img3;

    private void firebaseInit() {
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        calendar = Calendar.getInstance();
        currentUser = mAuth.getCurrentUser();
    }

    private void saveSentimento(String paciente, Date data, Integer sentindo, Integer sintoma) {
        RelatarSentimento sent = new RelatarSentimento(paciente, data, sentindo, sintoma);

        sentimento = db.collection("sentimento");
        sentimento.add(sent).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Log.d("SENTIMENTO", "DocumentSnapshot added with ID: " + documentReference.getId());
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("SENTIMENTO", "Error adding document", e);
                    }
                });


    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sentimento);
        //Firebase Initializatioon
        firebaseInit();

        //Views Attachement

        btn1 = findViewById(R.id.buttonsave);
        txv1 = findViewById(R.id.txv1);
        txv2 = findViewById(R.id.txv2);
        txv3 = findViewById(R.id.txv3);
        txv4 = findViewById(R.id.txv4);
        skb1 = findViewById(R.id.seekBar);

        img1 = findViewById(R.id.imgbad);
        img2 = findViewById(R.id.imgwhatever);
        img3 = findViewById(R.id.imggood);

        cb1 = findViewById(R.id.switch1);
        cb2 = findViewById(R.id.switch2);
        cb3 = findViewById(R.id.switch3);
        cb4 = findViewById(R.id.switch4);
        cb5 = findViewById(R.id.switch5);
        cb6 = findViewById(R.id.switch6);
        cb7 = findViewById(R.id.switch7);
        cb8 = findViewById(R.id.switch8);
        cb9 = findViewById(R.id.switch9);
        cb10 = findViewById(R.id.switch10);
        cb11 = findViewById(R.id.switch11);
        cb12 = findViewById(R.id.switch12);
        cb13 = findViewById(R.id.switch13);
        cb14 = findViewById(R.id.switch14);
        cb15 = findViewById(R.id.switch15);
        cb16 = findViewById(R.id.switch16);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (cb1.isChecked()) {
                    msintoma += 1;
                }
                if (cb2.isChecked()) {
                    msintoma += 2;
                }
                if (cb3.isChecked()) {
                    msintoma += 4;
                }
                if (cb4.isChecked()) {
                    msintoma += 8;
                }
                if (cb5.isChecked()) {
                    msintoma += 16;
                }
                if (cb6.isChecked()) {
                    msintoma += 32;
                }
                if (cb7.isChecked()) {
                    msintoma += 64;
                }
                if (cb8.isChecked()) {
                    msintoma += 128;
                }
                if (cb9.isChecked()) {
                    msintoma += 256;
                }
                if (cb10.isChecked()) {
                    msintoma += 512;
                }
                if (cb11.isChecked()) {
                    msintoma += 1024;
                }
                if (cb12.isChecked()) {
                    msintoma += 2048;
                }
                if (cb13.isChecked()) {
                    msintoma += 4096;
                }
                if (cb14.isChecked()) {
                    msintoma += 8192;
                }
                if (cb15.isChecked()) {
                    msintoma += 16384;
                }
                if (cb15.isChecked()) {
                    msintoma += 32768;
                }
                if (cb16.isChecked()) {
                    msintoma += 65536;
                }

                saveSentimento(currentUser.getUid(), calendar.getTime(), msentimento, msintoma);

            }
        });//Button Save

        skb1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //msentimento =progress;

                if (progress < 5) {
                    txv2.setText("mal");
                    img1.setVisibility(View.VISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.INVISIBLE);
                }

                if (progress == 5) {
                    txv2.setText("Normal");
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.VISIBLE);
                    img3.setVisibility(View.INVISIBLE);

                }
                if (progress > 5) {
                    txv2.setText("Bem");
                    img1.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.VISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                msentimento = seekBar.getProgress();
                txv2.append(msentimento.toString());
            }
        });


    }//Oncreat
}//Activity
