package io.cellwars.cellwars;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

public class Player {

    private float x;
    private float y;
    private int color;
    private float radius;

    public Player(float x, float y) {
        this.x = x;
        this.y = y;
        this.radius = 25;

        Random rand = new Random();
        this.color = Color.argb(100, rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
    }

    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(color);

        canvas.drawCircle(x, y, radius, paint);

        Paint black = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);

        canvas.drawText(x + ", " + y, x, y, black);
    }

    public float calculateSpeed() {
        return 100 / radius;
    }

    public float getX() {
        return x;
    }

    public void moveX(float x) {
        this.x += x;
    }

    public float getY() {
        return y;
    }

    public void moveY(float y) {
        this.y += y;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

}
