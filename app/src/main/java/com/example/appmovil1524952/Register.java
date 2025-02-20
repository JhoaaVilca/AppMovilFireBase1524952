package com.example.appmovil1524952;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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

    }
}