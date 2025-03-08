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
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
        Button btncancelar = findViewById(R.id.btnCancelarRegister);
        Button btnregister = findViewById(R.id.btnRegistrarRegister);
        Button btnlimpiar = findViewById(R.id.btnLimpiarRegister);

        EditText txtnombreapellidos = findViewById(R.id.txtApellidosNombresRegister);
        EditText txtcorreo = findViewById(R.id.txtCorreoRegister);
        EditText txttelefono = findViewById(R.id.txttelefonoRegister);
        EditText txtcontraseña = findViewById(R.id.txtContraseñaRegister);

        btncancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent conectar = new Intent(  Register.this, MainActivity.class );
                startActivity(conectar);

            }
        });

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreusuario = txtnombreapellidos.getText().toString();
                String telefonousuario = txttelefono.getText().toString();
                String emailuser = txtcorreo.getText().toString();
                String passuusuario = txtcontraseña.getText().toString();

                if (TextUtils.isEmpty(nombreusuario)||TextUtils.isEmpty(telefonousuario)||TextUtils.isEmpty(emailuser)||TextUtils.isEmpty(passuusuario)){
                    Toast.makeText(Register.this,"Todos los campos son obligatorios",Toast.LENGTH_SHORT).show();
                }else{
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(emailuser,passuusuario).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                String UserId = FirebaseAuth.getInstance().getCurrentUser().getUid();
                                Map<String, String> user = new HashMap<>();
                                user.put("username", nombreusuario);
                                user.put("telefono",telefonousuario);
                                user.put("email", emailuser);

                                FirebaseDatabase.getInstance().getReference().child("usuarios").child(UserId).setValue(user);
                                Toast.makeText(Register.this,"Registro Exitoso", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(Register.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
}