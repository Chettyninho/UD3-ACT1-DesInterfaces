package com.example.act1_desinterfaces;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView background = findViewById(R.id.backgroundLogin);
        Glide.with(this)
                .load("https://images.unsplash.com/photo-1507961455425-0caef37ef6fe?q=80&w=1776&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D")
                .transition(DrawableTransitionOptions.withCrossFade(200))
                .centerCrop()
                .into(background);

        // Suponiendo que tienes una referencia al TextView
        TextView textView = findViewById(R.id.contrasena);

        // Agrega un OnClickListener al TextView
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Construye y muestra el AlertDialog
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                alertDialogBuilder.setMessage("Sos un pelotudo...?")
                        .setPositiveButton("SiSoy", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Lógica al hacer clic en "Aceptar". por ejemplo redirigir a alguna pagina que gestione la recuperacion de contraseña
                            }
                        })
                        .setNegativeButton("No olvidé la contraseña", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Lógica al hacer clic en "Cancelar", osea ninguna, seguir donde estamos.
                                dialog.dismiss(); // Cierra el AlertDialog
                            }
                        })
                        .show();
            }
        });
    }
}
