package com.odisey.gamerace;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Objects;
import java.util.Random;

public class RaceActivity extends AppCompatActivity {
    private MovingSquaresView movingSquaresView;
    private Handler handler;
    public  static Boolean endGame = false;
    private float[] speedArr = {0,0};
    public static int winner = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_race);
        init();

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
            speedArr[0] = (float) ((Math.random() * 30) / 2);
            speedArr[1] = ((speedArr[0] * 3) / 2 );
        }else {
            speedArr[1] = (float) ((Math.random() * 30));
            speedArr[0] = (float) (speedArr[1] * 0.8);
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
