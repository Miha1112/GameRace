package com.odisey.gamerace;

import static com.odisey.gamerace.MainActivity.endGame;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.TextAppearanceSpan;
import android.text.style.UpdateAppearance;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Objects;
import java.util.Random;

public class RaceActivity extends AppCompatActivity {
    private MovingSquaresView movingSquaresView;
    private Handler handler;
    private float[] speedArr = {0,0};
    public static int winner = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_race);
        ActivityCloser.addActivity(this);
        init();
        ImageView finish = findViewById(R.id.finisingImg);
        finish.setColorFilter(Color.WHITE);

        movingSquaresView = findViewById(R.id.movingSquare);

        handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (endGame){
                    System.out.println("TRY END GAME");
                    goToEndGame();
                    handler.removeCallbacks(this);
                    return;
                }
                moveSquares(speedArr[0],speedArr[1]);
                System.out.println("Red speed: " + speedArr[0] + " yelow speed: " + speedArr[1]);
                handler.postDelayed(this, 30);
            }
        }, 30);
    }
    private void goToEndGame(){
        Intent intent = new Intent(this, EndRaceActivity.class);
        startActivity(intent);
        finish();

    }
    private void init(){
        winner = (int) Math.round(Math.random());
        System.out.println("WINNER IS: " + winner);

        if (winner == 0){
            speedArr[0] = (float) ((Math.random() * 20) / 2);
            speedArr[1] = (float) (speedArr[0] * (Math.random() - 0.1));
        }else {
            speedArr[1] = (float) ((Math.random() * 20));
            speedArr[0] = (float) (speedArr[1] * (Math.random() - 0.1));
        }

        if (speedArr[0] <=1 || speedArr[1] <= 1){
            //reload speed value
            System.out.println("RELOAD SPEED VALUE");
            init();
        }

    }

    private void moveSquares(float redSpeed, float yellowSpeed) {
        movingSquaresView.moveSquares(redSpeed,yellowSpeed);
    }
}
