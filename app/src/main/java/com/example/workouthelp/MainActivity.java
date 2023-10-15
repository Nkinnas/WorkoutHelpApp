package com.example.workouthelp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button buttonPush = findViewById(R.id.pushButton);
        buttonPush.setOnClickListener(v -> {
            // This will navigate to the details activity and send "push" as an extra
            navigateToDetails("PUSH");
        });

        // Initialize and set onClickListener for PULL button
        Button buttonPull = findViewById(R.id.pullButton);
        buttonPull.setOnClickListener(v -> {
            navigateToDetails("PULL");
        });

        // Initialize and set onClickListener for LEGS button
        Button buttonLegs = findViewById(R.id.legsButton);
        buttonLegs.setOnClickListener(v -> {
            navigateToDetails("LEGS");
        });




    }

    private void navigateToDetails(String workoutType) {
        Intent intent = new Intent(MainActivity.this, WorkoutDetailsActivity.class);
        intent.putExtra("workoutType", workoutType);
        startActivity(intent);
    }
}