package com.example.lab5;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

class Point{
    public float X;
    public float Y;

    public Point(float x, float y){
        X = x;
        Y = y;
    }
}

public class MyView extends View {
    private int iteration = 0;

    public MyView(Context context) {
        super(context);
    }

    private void SierpinskiFunc(Point[] points, Canvas canvas, int depth){
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        boolean finish = false;
        if(depth >= iteration) {
            paint.setStyle(Paint.Style.FILL);
            finish = true;
        }
        else{
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(5);
            depth++;
        }
        Path path = new Path();
        path.moveTo(points[0].X, points[0].Y);
        path.lineTo(points[1].X, points[1].Y);
        path.lineTo(points[2].X, points[2].Y);
        path.lineTo(points[0].X, points[0].Y);
        path.close();

        canvas.drawPath(path, paint);

        if(finish) return;
        Point middleLeft = new Point((points[0].X + points[1].X) / 2,
                                     (points[0].Y + points[1].Y) /2);
        Point middleRight = new Point((points[0].X + points[2].X) / 2,
                                      (points[0].Y + points[2].Y) /2);
        Point middleBottom = new Point((points[1].X + points[2].X) / 2,
                                       (points[1].Y + points[2].Y) /2);

        SierpinskiFunc(new Point[]{ points[0], middleLeft, middleRight }, canvas, depth);
        SierpinskiFunc(new Point[]{ middleLeft, points[1], middleBottom }, canvas, depth);
        SierpinskiFunc(new Point[]{ middleRight, middleBottom, points[2] }, canvas, depth);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float mainX = canvas.getWidth() / 2;
        float mainY = (float) (mainX * Math.sqrt(3)) + 100;
        Point[] points = new Point[]{
                new Point(mainX, 100),
                new Point(0, mainY),
                new Point(mainX * 2, mainY),
        };
        SierpinskiFunc(points, canvas, 0);
        iteration++;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(iteration >= 10) return;
        invalidate();
    }
}
