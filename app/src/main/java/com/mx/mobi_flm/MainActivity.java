package com.mx.mobi_flm;


import android.annotation.SuppressLint;
import android.content.Intent;
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

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {

    TextView textView1, textView2;
//Views members
private Button btn1;
    private EditText edname, edpassword;
    //aux members
    private String[] pacientes=new String[10];
    Integer i=0;
    Integer j=0;
    private String email, password;
    private User[] mUserArray= new User[10];
    private String user;

    // Firebase members
    private FirebaseAuth mAuth;
    private FirebaseUser fbuser;


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
        textView2.setText("Usuario-Não-Autenticado");
        edname = findViewById(R.id.editlogin);
        edpassword = findViewById(R.id.editpass);


     //  <---------------------------------------------------- View ACTIONS_---------------------------------------->

      btn1.setOnClickListener(new View.OnClickListener() {
          @SuppressLint("SetTextI18n")
          public void onClick(View v) {

              email = edname.getText().toString();
              password = edpassword.getText().toString();
              /*  if( (email!= null) && (password!=null)) { */
              //login(email, password);
              if (email.isEmpty() || password.isEmpty()) {
                  login("miguelmonte.vix@gmail.com", "cabecadedragao");
              } else {
                  login(email, password);
              }
              fbuser = mAuth.getCurrentUser();
              //}
              if (fbuser != null) {
                  //String u = fbuser.getUid();
                  textView2.setTextColor(getResources().getColor(R.color.green));
                  textView2.setText("Usuario-Autenticado");

                  Intent myIntent = new Intent(MainActivity.this, Opcoes.class);
                  myIntent.putExtra("UID", fbuser.getUid());
                  startActivity(myIntent);
              }

          }
      });
    }
}
