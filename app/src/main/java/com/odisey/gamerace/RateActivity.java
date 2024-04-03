package com.odisey.gamerace;

import static com.odisey.gamerace.MainActivity.rate;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RateActivity extends AppCompatActivity {
    public String userCar = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rate);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
    }

    private void init(){
        SeekBar seekBarRate = findViewById(R.id.seekBar);
        TextView rateText = findViewById(R.id.rateText);
        ImageButton redCar = findViewById(R.id.redCar);
        ImageButton yellowCar = findViewById(R.id.yelowCar);
        seekBarRate.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                rate = progress;
                rateText.setText(Integer.toString(rate));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        redCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redCar.setAlpha(1);
                yellowCar.setAlpha(0.5f);
                userCar = "redCar";
            }
        });
        yellowCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yellowCar.setAlpha(1);
                redCar.setAlpha(0.5f);
                userCar = "yellowCar";
            }
        });
    }
}