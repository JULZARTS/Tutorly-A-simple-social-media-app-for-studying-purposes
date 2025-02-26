package com.example.Tutorly;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;



public class HomeActivity extends AppCompatActivity {
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

        setContentView(R.layout.activity_home);

        Button ToFinduserBtn = findViewById(R.id.ToFinduser);
        ToFinduserBtn.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, FindPeopleActivity.class);
            startActivity(intent);
        });

        Button ToNotificationsBtn = findViewById(R.id.ToNotifications);
        ToNotificationsBtn.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, NotificationsActivity.class);
            startActivity(intent);
        });

        Button ToMessagesBtn = findViewById(R.id.ToMessages);
        ToMessagesBtn.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, MessageActivity.class);
            startActivity(intent);
        });

        Button ToProfileBtn = findViewById(R.id.ToProfile);
        ToProfileBtn.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
            startActivity(intent);
        });


    }
}
