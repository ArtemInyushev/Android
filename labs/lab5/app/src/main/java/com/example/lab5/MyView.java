package com.example.lab5;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import java.util.Random;

public class MyView extends View {
    private float circleRadius = 400;
    private float step = -400;
    private float vstep = 1;
    private float[] speeds = new float[]{1, 2, 4, 5, 8, 10, 20};
    private boolean leftSide = true;

    public MyView(Context context) {
        super(context);
    }

    private float calculateX2Coordinate(float x1, float y1, float y2, boolean left){
        // (x1 - x2)^2 + (y1 - y2)^2 = length^2
        double tmp = Math.pow(circleRadius, 2) - Math.pow((y1 - y2), 2);
        double x2 = 0;
        if(left){
            x2 = x1 - Math.sqrt(tmp);
        }
        else{
            x2 = x1 + Math.sqrt(tmp);
        }
        return (float) x2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float circleMiddleX = canvas.getWidth() / 2;
        float circleMiddleY = canvas.getHeight() / 2;

        Paint paintCircle = new Paint();
        paintCircle.setColor(Color.YELLOW);
        paintCircle.setStyle(Paint.Style.STROKE);
        paintCircle.setStrokeWidth(20);
        canvas.drawCircle(circleMiddleX, circleMiddleY, circleRadius, paintCircle);


        float squareMiddleY = circleMiddleY + step;
        float squareMiddleX = calculateX2Coordinate(circleMiddleX, circleMiddleY, squareMiddleY, leftSide);
        if(Math.abs(squareMiddleY - circleMiddleY) == circleRadius){
            leftSide = !leftSide;
            int rnd = new Random().nextInt(speeds.length);
            vstep = speeds[rnd];
        }
        if(leftSide){
            step -= vstep;
        }
        else {
            step += vstep;
        }

        Paint paintMiddleSquarePoint = new Paint();
        paintMiddleSquarePoint.setColor(Color.RED);
        paintMiddleSquarePoint.setStyle(Paint.Style.STROKE);
        paintMiddleSquarePoint.setStrokeWidth(20);
        canvas.drawPoint(squareMiddleX, squareMiddleY, paintMiddleSquarePoint);


        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20);

        canvas.drawRect(squareMiddleX - 150,squareMiddleY - 150,
                       squareMiddleX + 150,squareMiddleY + 150, paint);
        invalidate();
    }
}
