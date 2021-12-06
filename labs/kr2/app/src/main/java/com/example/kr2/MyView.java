package com.example.kr2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import java.util.ArrayList;

class Point{
    public float X;
    public float Y;

    public Point(float x, float y){
        X = x;
        Y = y;
    }
}

public class MyView extends View {
    private float a = 9;
    private float b = 8;
    private double delta = Math.PI / 2;
    private float t = 0;
    private ArrayList<Point> _points = new ArrayList<Point>();

    public MyView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paintPoint = new Paint();
        paintPoint.setColor(Color.RED);
        paintPoint.setStyle(Paint.Style.STROKE);
        paintPoint.setStrokeWidth(20);
        for(Point point : _points){
            canvas.drawPoint(point.X, point.Y, paintPoint);
        }

        float x = (float) (700 * Math.sin(a * t + delta) + canvas.getWidth() / 2);
        float y = (float) (700 * Math.sin(b * t) + canvas.getHeight() / 2);
        Point newPoint = new Point(x, y);
        _points.add(newPoint);

        t += 0.001;

        Paint paintCircle = new Paint();
        paintCircle.setColor(Color.BLACK);
        paintCircle.setStyle(Paint.Style.STROKE);
        paintCircle.setStrokeWidth(20);

        canvas.drawPoint(x, y, paintCircle);
        canvas.drawCircle(x, y, 100, paintCircle);

        invalidate();
    }
}