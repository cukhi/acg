package com.example.acg3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Random;

public class Figura extends View {

    public Figura(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        int width = getWidth();
        int width2 = width/2;
        int height = getHeight();
        int size = (width2 < height ? width2 : height) - 10;
        int x, y, dx, dy;
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        Random random = new Random();

        paint.setColor(Color.GRAY);
        canvas.drawRect(0,0,width-1,height-1,paint);

        CharSequence description = getContentDescription();
        if (description == null)
            description = "Brak";
        for (int i = 0; i < 10; i++){

            paint.setARGB(
                    255,
                    random.nextInt(256),
                    random.nextInt(256),
                    random.nextInt(256)
            );
            Log.d("Description", description.toString());
            if (description.equals("kolo")){
                dx = random.nextInt(size);
                x = random.nextInt(width2 - dx);
                y = random.nextInt(height - dx);
                canvas.drawCircle(x,y,dx,paint);

            } else if (description.equals("elipsa")) {
                dx = random.nextInt(size);
                dy = random.nextInt(size);
                x = random.nextInt(width2 - dx);
                y = random.nextInt(height-dy);
                RectF rect = new RectF(x,y,x+dx,y+dy);
                canvas.drawOval(rect, paint);
            } else if (description.equals("prostokat")) {
                dx = random.nextInt(size);
                dy = random.nextInt(size);
                x = random.nextInt(width2 - dx);
                y = random.nextInt(height-dy);
                RectF rect = new RectF(x,y,x+dx,y+dy);
                canvas.drawRect(rect, paint);
            } else if (description.equals("prostokatOkragly")) {
                dx = random.nextInt(size);
                dy = random.nextInt(size);
                x = random.nextInt(width2 - dx);
                y = random.nextInt(height - dy);
                RectF rect = new RectF(x,y,x+dx,y+dy);
                canvas.drawArc(rect,random.nextInt(360), random.nextInt(360),false, paint);
            } else if (description.equals("linia")) {
                dx = random.nextInt(width2);
                dy = random.nextInt(height);
                x = random.nextInt(width2);
                y = random.nextInt(height);
                canvas.drawLine(x,y,dx,dy,paint);
            }





        }
        paint.setTextSize(getResources().getDimension(R.dimen.wys_napisu));
        paint.setTextAlign(Paint.Align.RIGHT);
        paint.setColor(Color.BLUE);
        canvas.drawText( (String)description, width - 20, height/2, paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1);
        canvas.drawRect(0,0,width-1,height-1,paint);


        super.onDraw(canvas);
    }
}