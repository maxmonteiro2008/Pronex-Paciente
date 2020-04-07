package com.mx.mobi_flm;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {

    public static final String UID = "com.mx.mobi_flm.UID";
    TextView textView1, textView2;
//Views members
private Button btn1;
    private EditText edname, edpassword;
    //aux members
    private String[] pacientes=new String[10];
    Integer i=0;
    Integer j=0;
    private String email, password;
    User mUser1, mUser2,mUser3;
    private User[] mUserArray= new User[10];
    private String user;
    private Boolean logedin = false;
    // Firebase members
    private FirebaseAuth mAuth;
    private FirebaseUser fbuser;
    private FirebaseFirestore db;
    private CollectionReference myRef ;
    private DocumentReference myDoc;

    private void login(String email, String password) {

        mAuth = FirebaseAuth.getInstance();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.i("LOGIN", "signInWithEmail:success");
                            fbuser = mAuth.getCurrentUser();
                            user = "OK";

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.i("LOGIN", "signInWithEmail:failure", task.getException());
                            user = "login fail";


                        }

                    }
                });


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Views connection
        btn1 = findViewById(R.id.button1);
        textView2 = findViewById(R.id.textview2);
        textView2.setText("Fulano");
        edname = findViewById(R.id.editlogin);
        edpassword = findViewById(R.id.editpass);
        //listview1=(ListView) findViewById(R.id.listview1);

       //textView1= findViewById(R.id.textview1);
       //Firebase

        // FirebaseUser currentUser = mAuth.getCurrentUser();

       /* db = FirebaseFirestore.getInstance();
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
        }); */


     //  <---------------------------------------------------- View ACTIONS_---------------------------------------->

      btn1.setOnClickListener(new View.OnClickListener() {
          @SuppressLint("SetTextI18n")
          public void onClick(View v) {

              email = edname.getText().toString();
              password = edpassword.getText().toString();
              login(email, password);
              fbuser = mAuth.getCurrentUser();
              if (fbuser != null) {
                  String u = fbuser.getUid();
                  textView2.setText(u);
              }

              //textView2.setText(fbuser.getUid().toString());
              // Intent myIntent = new Intent(this, Opcoes.class);
              //myIntent.putExtra(UID, fbuser.getUid().toString());
              //startActivity(myIntent);
          }
      });
    }
}
