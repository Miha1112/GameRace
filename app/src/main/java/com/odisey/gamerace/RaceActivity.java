package com.odisey.gamerace;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Objects;

public class RaceActivity extends AppCompatActivity {
    private int winnerSpeed = 0;
    private int looserSpeed = 0;
    private String winnerCar = "";
    private final String[] carsArray = {"redCar", "yellowCar"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_race);
        System.out.println("try call init method");
        init();

    }

    private void init() {
        // Get random winner
        winnerCar = carsArray[(int) Math.random()];
        System.out.println("WINNER IS: " + winnerCar);

        // Initialize cars
        ImageView redCar = findViewById(R.id.redCar);
        ImageView yellowCar = findViewById(R.id.yellowCar);

        // Set speed to cars
        winnerSpeed = (int) (Math.random() * 10) + 5; // Speed between 5 and 15
        looserSpeed = (int) ((winnerSpeed / 2) * Math.random() * 3); // Some variation in speed

        // Start moving winner car
        if (Objects.equals(winnerCar, "redCar")) {
            moveCar(redCar, winnerSpeed);
            moveCar(yellowCar, looserSpeed);
        } else {
            moveCar(redCar, looserSpeed);
            moveCar(yellowCar, winnerSpeed);
        }
    }

    private void moveCar(ImageView car, int speed) {
        System.out.println("Try move car: " + car.getY());
        while (car.getY() > 100) {
            System.out.println("CAR MOVED URAAA!!!!!!!!!");
            float newY = car.getY() - speed;
            car.setY(newY);
        }
    }
}
