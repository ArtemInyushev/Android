package com.example.lab5;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
public class MyView extends View {
    int x = 0; // Координата по горизонталі лівого верхнього кута прямокутника
    int y = 0; // Координата по вертикалі лівого верхнього кута прямокутника
    int widthRect = 300; // Ширина прямокутника
    int heightRect = 200; // Висота прямокутника
    int strokeWidth = 20; // Товщина лінії прямокутника
    int vx = 10; // Швидкість прямокутника по горизонталі
    int vy = 10; // Швидкість прямокутника по вертикалі

    public MyView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(strokeWidth);
        x = x + vx;
        y = y + vy;
        if (x > canvas.getWidth() - widthRect) {
            vx = vx * -1;
            strokeWidth+=30;
        }
        if (x < 0) {
            vx = vx * -1;
            strokeWidth+=30;
        }
        if (y > canvas.getHeight() - heightRect) {
            vy = vy * -1;
            strokeWidth+=30;
        }
        if (y < 0) {
            vy = vy * -1;
            strokeWidth+=30;
        }
        canvas.drawRect(x,y,widthRect + x,heightRect+y,paint);
        invalidate();
    }
}
