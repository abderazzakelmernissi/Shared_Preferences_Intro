package com.elmernissi.mysharedpreferencesintro;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {

    private TextView txtDetails;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // Initialisation de la vue
        txtDetails = findViewById(R.id.txtDetails);

        // Initialisation de SharedPreferences
        sharedPreferences = getSharedPreferences("UserData", Context.MODE_PRIVATE);

        // Récupérer les données depuis SharedPreferences
        String nom = sharedPreferences.getString("Nom", "");
        String age = sharedPreferences.getString("Age", "");

        // Afficher les données dans le TextView
        String details = "Nom : " + nom + "\nAge : " + age;
        txtDetails.setText(details);
    }
}
