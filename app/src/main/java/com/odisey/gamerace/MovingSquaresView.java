package com.odisey.gamerace;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import static com.odisey.gamerace.RaceActivity.endGame;


public class MovingSquaresView extends View {
    private Paint yellowPaint;
    private Paint redPaint;
    private int yellowSquareY = 0;
    private int redSquareY = 0;
    private final int STEP_SIZE = 15;

    public MovingSquaresView(Context context) {
        super(context);
        init();
    }

    public MovingSquaresView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        yellowPaint = new Paint();
        yellowPaint.setColor(Color.YELLOW);

        redPaint = new Paint();
        redPaint.setColor(Color.RED);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight();

        int squareSize = width / 6;

        canvas.drawRect(50, height - squareSize - yellowSquareY, squareSize+50, height - yellowSquareY, yellowPaint);

        canvas.drawRect(width - squareSize - 150, height - squareSize - redSquareY, width-150, height - redSquareY, redPaint);
    }

    public void moveSquares(int redSpeed, int yellowSpeed) {
        int width = getWidth() /6;
        int height = getHeight();
        if (height - width - yellowSquareY <= 150){
            endGame = true;
        }else if (height - width - redSquareY <= 150){
            endGame = true;
        }
        yellowSquareY += yellowSpeed;
        redSquareY += redSpeed;
        invalidate();
    }
}
