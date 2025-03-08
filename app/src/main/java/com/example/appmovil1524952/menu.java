package com.example.appmovil1524952;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btncerrarsesion = findViewById(R.id.btncerrarsesionMenu);
        btncerrarsesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent conectar = new Intent(  menu.this, MainActivity.class );
                startActivity(conectar);

            }
        });

        ImageView btnclientes = findViewById(R.id.btnclientess);
        btnclientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gocliente= new Intent(menu.this, clientes.class);
                startActivity(gocliente);
            }
        });


    }
}