package com.elmernissi.mysharedpreferencesintro;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editNom, editAge;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialisation des vues
        editNom = findViewById(R.id.editNom);
        editAge = findViewById(R.id.editAge);
        Button btnSave = findViewById(R.id.btnSave);
        Button btnAfficher = findViewById(R.id.btnAfficher);

        // Initialisation de SharedPreferences
        sharedPreferences = getSharedPreferences("UserData", Context.MODE_PRIVATE);

        // Gestionnaire de clic pour le bouton Enregistrer
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Récupérer les données saisies
                String nom = editNom.getText().toString();
                String age = editAge.getText().toString();

                // Éditeur SharedPreferences pour enregistrer les données
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Nom", nom);
                editor.putString("Age", age);
                editor.apply();

                // Effacer les champs d'édition
                editNom.setText("");
                editAge.setText("");

                Toast.makeText(MainActivity.this, "Données enregistrées avec succès.", Toast.LENGTH_SHORT).show();
            }
        });

        // Gestionnaire de clic pour le bouton Afficher
        btnAfficher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Récupérer les données enregistrées depuis SharedPreferences
                String nom = sharedPreferences.getString("Nom", "");
                String age = sharedPreferences.getString("Age", "");

                // Afficher un Toast avec les données
                Toast.makeText(MainActivity.this, "Nom : " + nom + "\nAge : " + age, Toast.LENGTH_SHORT).show();

                // Passer aux détails avec une nouvelle activité
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                startActivity(intent);
            }
        });
    }
}
