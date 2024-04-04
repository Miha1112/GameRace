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

public class RaceActivity extends AppCompatActivity {
    private MovingSquaresView movingSquaresView;
    private Handler handler;
    public  static Boolean endGame = false;
    private String[] carsArr = {"redCar","yellowCar"};
    private int[] speedArr = {0,0};
    public static String winner = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_race);
        init();

        // Знаходимо елемент MovingSquaresView за його ID
        movingSquaresView = findViewById(R.id.movingSquare);

        // Ініціалізуємо Handler для автоматичного переміщення квадратів
        handler = new Handler();

        // Запускаємо періодичну задачу для переміщення квадратів кожні 500 мілісекунд
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (endGame){
                    handler.removeCallbacksAndMessages(null);
                    goToEndGame();
                }
                moveSquares(speedArr[0],speedArr[1]);
                // Повторюємо цю задачу кожні 500 мілісекунд
                handler.postDelayed(this, 10);
            }
        }, 10);
    }
    private void goToEndGame(){
        Intent intent = new Intent(this, EndRaceActivity.class);
        startActivity(intent);
        finish();

    }
    private void init(){
        winner = carsArr[(int) Math.random()];

        if (Objects.equals(winner, "redCar")){
            speedArr[0] = (int) (Math.random() * 10) / 2;
            speedArr[1] = ((speedArr[0] / 2 ) * 3);
        }else {
            speedArr[1] = (int) (Math.random() * 10) / 2;
            speedArr[0] = ((speedArr[1] / 2 ) * 3);
        }

    }

    // Метод для переміщення квадратів у MovingSquaresView
    private void moveSquares(int redSpeed, int yellowSpeed) {
        movingSquaresView.moveSquares(redSpeed,yellowSpeed);
    }
}
