package io.cellwars.cellwars;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class World extends View {

    private Controller controller;
    private Paint paint;
    private Bitmap bitmap;

    private Player player;
    private List<Player> players = new ArrayList<Player>();

    public World(Context context, int width, int height) {
        super(context);

        this.controller = new Controller(this);
        setOnTouchListener(controller);

        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.WHITE);
        this.bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

        this.players.add(new Player(width / 2, height / 2));
        this.players.add(new Player(width / 2 + 100, height / 2 + 100));
        this.player = players.get(0);

        final Handler handler = new Handler();
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                update();

                handler.postDelayed(this, 10);
            }
        });
    }

    public void update() {
        invalidate();

        float relX = getScrollX() + controller.getX() - player.getX();
        float relY = getScrollY() + controller.getY() - player.getY();

        double angle = Math.atan2(relY, relX);

        float speed = player.calculateSpeed();

        player.moveX((float) Math.cos(angle) * speed);
        player.moveY((float) Math.sin(angle) * speed);

        // player.setRadius(player.getRadius() + 0.05f);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(bitmap, 0, 0, paint);
        canvas.drawPaint(paint);

        for (Player player : players)
            player.draw(canvas);

        int modX = (int) (player.getX() - canvas.getWidth() / 2);
        int modY = (int) (player.getY() - canvas.getHeight() / 2);

        scrollTo(modX, modY);
    }

}
