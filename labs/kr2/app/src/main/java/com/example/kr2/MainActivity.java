package com.example.kr2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(new MyView(this)); // task1

        setContentView(R.layout.activity_main); // task2
        startMerge(); // task2
    }

    private void startMerge() {
        double ratio = 0.5;
        mergeImages(
                BitmapFactory.decodeResource(getResources(), R.drawable.glass),
                BitmapFactory.decodeResource(getResources(), R.drawable.car),
                ratio
        );
    }
    private void mergeImages(Bitmap source1, Bitmap source2, double ratio) {
        Bitmap result = Bitmap.createBitmap(source1.getWidth(),
                source1.getHeight(), source1.getConfig());
        for (int x = 0; x < source1.getWidth(); x++) {
            for (int y = 0; y < source1.getHeight(); y++) {
                int color1 = source1.getPixel(x, y);
                int color2 = source2.getPixel(x, y);

                result.setPixel(x, y, Color.argb(
                        (int) (Color.alpha((color1)) * ratio +
                                Color.alpha((color2)) * (1 - ratio)),
                        (int) (Color.red((color1)) * ratio + Color.red((color2))
                                * (1 - ratio)),
                        (int) (Color.green((color1)) * ratio +
                                Color.green((color2)) * (1 - ratio)),
                        (int) (Color.blue((color1)) * ratio +
                                Color.blue((color2)) * (1 - ratio))
                ));
            }
        }
        ImageView mergedView = (ImageView) findViewById(R.id.mergedImage);
        mergedView.setImageBitmap(result);
    }
}