package com.odisey.gamerace;

import static com.odisey.gamerace.MainActivity.score;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Stack;

public class StartScrean extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_start_screan);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ActivityCloser.addActivity(this);

        Button startBtn = findViewById(R.id.btn_start);
        Button exitBtn = findViewById(R.id.btn_exit);
        TextView scoreText = findViewById(R.id.mainTopText);
        scoreText.setText(Integer.toString(score));

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toRateActivity();
            }
        });

        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCloser.closeAllActivities();
                System.exit(0);
            }
        });
    }
    private void toRateActivity(){
        Intent intent = new Intent(this,RateActivity.class);
        startActivity(intent);
        ActivityCloser.closeAllActivities();
        finish();
    }
}