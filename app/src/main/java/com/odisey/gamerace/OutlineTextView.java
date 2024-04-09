package com.odisey.gamerace;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;


public class OutlineTextView extends androidx.appcompat.widget.AppCompatTextView {
    private int strokeColor= Color.WHITE;
    private int strokeWidth=2;

    public OutlineTextView(Context context) {
        super(context);
    }

    public OutlineTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.OutlineTextView);
        strokeColor = a.getColor(R.styleable.OutlineTextView_textStrokeColor, strokeColor);
        strokeWidth = a.getDimensionPixelSize(R.styleable.OutlineTextView_textStrokeWidth, strokeWidth);
        a.recycle();
    }

    public void onDraw(Canvas canvas) {
        final ColorStateList textColor = getTextColors();
        TextPaint paint = this.getPaint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeMiter(10);
        this.setTextColor(strokeColor);
        paint.setStrokeWidth(strokeWidth);
        super.onDraw(canvas);
        paint.setStyle(Paint.Style.FILL);
        setTextColor(textColor);
        super.onDraw(canvas);
    }
}
