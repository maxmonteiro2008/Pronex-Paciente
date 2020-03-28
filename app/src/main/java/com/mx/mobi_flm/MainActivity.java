package com.mx.mobi_flm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {
    /* DATA
final String[] titleArray = {"Elephant","Octopus","Pig","Sheep","Rabbit","Snake","Spider","Spider","Spider","Tiger"

};

    final String[] infoArray = {
            "8 tentacled monster",
            "Delicious in rolls",
            "Great for jumpers",
            "Nice in a stew",
            "Great for shoes",
            "Scary.",
            "DADOD",
            "htrdes",
            "SEDR",
            "dervdaes"
    };

  final  Integer[] imageArray = {
            R.drawable.health_book,
            R.drawable.health_book__bold,
            R.drawable.health_book_blue,
            R.drawable.health_book_red,
            R.drawable.health_calendar,
            R.drawable.health_checkup,
            R.drawable.health_graph,
            R.drawable.man_health_worker,
            R.drawable.woman_health_worker,
            R.drawable.hospital_red
    };
<---------------------------------------------------BEGIN----------------------------------------------------->*/
//Views
Button btn1, btn2;
    TextView textView1, textView2;
    // Firebase
// Write a message to the database
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference myRef = db.getReference("Users");



    /*   Data get END--------------------------------------------------------------------------------------------  */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //CustomListAdapter myAdapter = new CustomListAdapter(this, R.layout.activity_main,this,imageArray,titleArray,infoArray);
        //ArrayAdapter myAdapter = new ArrayAdapter<String>(this,R.layout.activity_main,titleArray);
        //listView1 = (ListView) findViewById(R.id.listview1);
        //listView1.setAdapter(myAdapter);



    }
}
