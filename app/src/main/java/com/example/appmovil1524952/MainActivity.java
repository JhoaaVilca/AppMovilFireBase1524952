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

    }
}