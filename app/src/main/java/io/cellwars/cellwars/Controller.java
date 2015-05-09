package io.cellwars.cellwars;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class Controller implements View.OnTouchListener {

    private final World world;

    private float x;
    private float y;

    public Controller(World world) {
        this.world = world;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        this.x = event.getX();
        this.y = event.getY();
        return true;
    }

}
