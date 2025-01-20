package com.example.Tutorly;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);


        // Change the status bar color
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.Home_statusbar));
        getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.Home_statusbar));

        // Set the status bar icons and text to dark (for light backgrounds)
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);


        setContentView(R.layout.activity_message);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button BackToHomeBtn = findViewById(R.id.BackToHome);
        BackToHomeBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MessageActivity.this, HomeActivity.class);
            startActivity(intent);
        });

        Button ToMapsBtn = findViewById(R.id.ToMaps);
        ToMapsBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MessageActivity.this, FindPeopleActivity.class);
            startActivity(intent);
        });

        Button ToProfileBtn = findViewById(R.id.ToProfile);
        ToProfileBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MessageActivity.this, ProfileActivity.class);
            startActivity(intent);
        });
    }
}