package com.example.accesoapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Usuario y contraseña válidos
    private static final String USUARIO_OK  = "LENRAY";
    private static final String PASSWORD_OK = "2356";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText etUsuario  = findViewById(R.id.etUsuario);
        final EditText etPassword = findViewById(R.id.etPassword);
        Button btnEntrar          = findViewById(R.id.btnEntrar);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario  = etUsuario.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (usuario.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            "Llena todos los campos", Toast.LENGTH_SHORT).show();

                } else if (usuario.equals(USUARIO_OK) && password.equals(PASSWORD_OK)) {
                    Intent intent = new Intent(MainActivity.this, PerfilActivity.class);
                    intent.putExtra("usuario", usuario);
                    startActivity(intent);

                } else {
                    Toast.makeText(MainActivity.this,
                            "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                    etPassword.setText("");
                }
            }
        });
    }
}
