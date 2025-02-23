package com.example.Tutorly;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
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

public class SignupActivity extends AppCompatActivity {

    EditText email, pass, confirmpass;
    Button btnSignup;
    FirebaseAuth auth;
    TextView txt1;
    Drawable bg, bg2;
    GradientDrawable gradientDrawable, gradientDrawable2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        email = findViewById(R.id.email);
        pass = findViewById(R.id.password);
        confirmpass = findViewById(R.id.confirm_password);
        btnSignup = findViewById(R.id.signupbtn);
        auth = FirebaseAuth.getInstance();
        txt1 = findViewById(R.id.Text1);

        //backgroundssss
        bg = pass.getBackground();
        bg2 = confirmpass.getBackground();
        gradientDrawable = (GradientDrawable) bg;
        gradientDrawable2 = (GradientDrawable) bg2;

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user_email = email.getText().toString().trim();
                String user_pass = pass.getText().toString().trim();
                String user_confirmpass = confirmpass.getText().toString().trim();

                if (TextUtils.isEmpty(user_email)) {
                    email.setError("Email cannot be empty!");
                } else if (!Patterns.EMAIL_ADDRESS.matcher(user_email).matches()) {
                    email.setError("Please enter a valid email!");
                } else if (TextUtils.isEmpty(user_pass)) {
                    pass.setError("Password cannot be empty!");
                } else if (user_pass.length() < 6) {
                    pass.setError("Password must be at least 6 characters long!");
                } else if (!user_pass.equals(user_confirmpass)) {
                    pass.setError("Password do not match!");
                    confirmpass.setError("Password do not match!");
                    gradientDrawable.setStroke(5, Color.rgb(219, 40, 0));
                    gradientDrawable2.setStroke(5, Color.rgb(219, 40, 0));
                    gradientDrawable.setColor(Color.argb(70, 219, 40, 0));
                    gradientDrawable2.setColor(Color.argb(70, 219, 40, 0));

                } else {


                    auth.createUserWithEmailAndPassword(user_email, user_pass)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(SignupActivity.this, "Signup successful", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                                        startActivity(intent);
                                    } else {
                                        Toast.makeText(SignupActivity.this, "Error creating account: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });

        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignupActivity.this, MainActivity.class);
                startActivity(i);
            }


        });

    }
}