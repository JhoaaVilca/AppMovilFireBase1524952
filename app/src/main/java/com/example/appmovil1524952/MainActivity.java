package com.example.appmovil1524952;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Iniciar Objetos apra cada control en xml - java - xml

        Button btnLogin = findViewById(R.id.btnlogin);
        TextView lblregistrate = findViewById(R.id.lblregistrate);
        TextView lblresetpass = findViewById(R.id.lblResetPass);
        EditText txtEmail = findViewById(R.id.txtEmailLogin);
        EditText txtPassLogin = findViewById(R.id.txtPassLogin);

        //TEXTVIEW lblregistrate debe abrir view -> Registrate

        lblregistrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent conectar = new Intent(  MainActivity.this, Register.class );
                startActivity(conectar);

            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent conectar = new Intent(  MainActivity.this, menu.class );
                startActivity(conectar);

            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emaillogin = txtEmail.getText().toString();
                String passlogin = txtPassLogin.getText().toString();

                if (TextUtils.isEmpty(emaillogin)||TextUtils.isEmpty(passlogin)){
                    Toast.makeText(MainActivity.this,"Los campos son obligatorios", Toast.LENGTH_SHORT).show();
                }else {
                    FirebaseAuth.getInstance().signInWithEmailAndPassword(emaillogin,passlogin).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Intent con = new Intent(MainActivity.this,menu.class);
                                startActivity(con);
                                finish();
                            }else {
                                Toast.makeText(MainActivity.this,"Credenciales incorrectas",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

    }
}