package com.example.lab5;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
public class MyView extends View {
    int x = 0;

    public MyView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20);
        int widthRect = 300;
        x = x + 10;
        if (x > canvas.getWidth() - widthRect)
            x = canvas.getWidth() - widthRect;
        canvas.drawRect(x,200,widthRect + x,500,paint);
        invalidate();
    }
}
