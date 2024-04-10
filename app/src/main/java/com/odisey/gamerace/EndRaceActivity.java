package com.odisey.gamerace;

import static com.odisey.gamerace.MainActivity.endGame;
import static com.odisey.gamerace.MainActivity.rate;
import static com.odisey.gamerace.MainActivity.score;
import static com.odisey.gamerace.RaceActivity.winner;
import static com.odisey.gamerace.RateActivity.userCar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

public class EndRaceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_end_race);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ActivityCloser.addActivity(this);
        init();
    }
    private void init(){
        endGame = false;
        TextView winnerName = findViewById(R.id.winnerName);
        TextView rateText = findViewById(R.id.rateWinCount);

        if (winner == 0){
            winnerName.setText("Красный победил");
            ImageView winnerImg = findViewById(R.id.winnerImage);
            winnerImg.setImageResource(R.drawable.redwin);
        }else {
            winnerName.setText("Желтый победил");
            ImageView winnerImg = findViewById(R.id.winnerImage);
            winnerImg.setImageResource(R.drawable.yellowwin);
        }
        System.out.println("Winner is: " + winner + " user car: " + userCar);
        if (winner == userCar){
            rateText.setText("+ " + rate);
            score+=rate;
        }else {
            rateText.setText("- " + rate);
            score-=rate;
        }


        Button btn = findViewById(R.id.menuBtn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toMenu();
            }
        });

    }
    private void toMenu(){
        Intent intent = new Intent(this, StartScrean.class);
        startActivity(intent);
        finish();
    }
}