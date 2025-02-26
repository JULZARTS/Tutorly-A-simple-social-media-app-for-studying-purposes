package com.example.Tutorly;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MessageActivity extends AppCompatActivity {

    private RecyclerView chatRecyclerView;
    private ChatListAdapter chatListAdapter;
    private List<Chat> chatList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);

        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.Home_statusbar));
        getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.Home_statusbar));

        setContentView(R.layout.activity_message);

        // Navigation buttons
        Button backToHomeBtn = findViewById(R.id.BackToHome);
        backToHomeBtn.setOnClickListener(v -> startActivity(new Intent(this, HomeActivity.class)));

        Button toMapsBtn = findViewById(R.id.ToMaps);
        toMapsBtn.setOnClickListener(v -> startActivity(new Intent(this, FindPeopleActivity.class)));

        Button toProfileBtn = findViewById(R.id.ToProfile);
        toProfileBtn.setOnClickListener(v -> startActivity(new Intent(this, ProfileActivity.class)));

        chatRecyclerView = findViewById(R.id.chatListView);
        chatRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        chatList = createSampleChatData();

        chatListAdapter = new ChatListAdapter(chatList, chat -> {
            Intent intent = new Intent(this, PrivateMessageActivity.class);
            intent.putExtra("recipientName", chat.getContactName() != null ? chat.getContactName() : "Unknown");
            startActivity(intent);
        });

        chatRecyclerView.setAdapter(chatListAdapter);
    }

    private List<Chat> createSampleChatData() {
        List<Chat> list = new ArrayList<>();
        list.add(new Chat("Amanda Rodriguez", "Hey, how are you?", "12:00 PM"));
        list.add(new Chat("Jordan Morris", "See you soon!", "11:45 AM"));
        list.add(new Chat("Sara Duthirty", "What's up?", "10:30 AM"));
        list.add(new Chat("William McGuire", "Got it, thanks!", "10:30 AM"));
        list.add(new Chat("Herman Delgado", "Hello! Is there any chance ...", "9:00 AM"));
        return list;
    }
}
