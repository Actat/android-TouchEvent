package com.example.actat.touchevent;

import android.graphics.Rect;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private float dp = 0;
    private int layoutWidth = 0;
    private int layoutHeight = 0;
    private int statusBarHeight = 0;
    private int contentViewTop = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp = getResources().getDisplayMetrics().density;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        String action = "";
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                action = "ACTION_DOWN  ";
                break;
            case MotionEvent.ACTION_UP:
                action = "ACTION_UP    ";
                break;
            case MotionEvent.ACTION_MOVE:
                action = "ACTION_MOVE  ";
                break;
            case MotionEvent.ACTION_CANCEL:
                action = "ACTION_CANCEL";
                break;
        }

        Log.v("MotionEvent", "action = " + action + "\t" +  "x = " + String.valueOf(event.getX()) + "  \t" + "y = " + String.valueOf(event.getY()) + "  \t" + "width = " + String.valueOf(layoutWidth) + ", height = " + String.valueOf(layoutHeight) + "  \t" + "statusbarHeight = " + String.valueOf(statusBarHeight) + "  \t" + "contentTop = " + String.valueOf(contentViewTop) + "\n");

        return super.onTouchEvent(event);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        ConstraintLayout layout = findViewById(R.id.activity_main);
        layoutWidth = layout.getWidth();
        layoutHeight = layout.getHeight();

        final Rect rect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        statusBarHeight = rect.top;
        contentViewTop = (int)(getWindow().findViewById(Window.ID_ANDROID_CONTENT).getTop() * dp);
    }
}
