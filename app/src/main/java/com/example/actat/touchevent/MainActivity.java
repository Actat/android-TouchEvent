package com.example.actat.touchevent;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private int layoutWidth = 0;
    private int layoutHeight = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        String action = "";
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                action = "ACTION_DOWN";
                break;
            case MotionEvent.ACTION_UP:
                action = "ACTION_UP";
                break;
        }

        Log.v("MotionEvent", /* "action = " + action + ", " + */ "x = " + String.valueOf(event.getX()) + ". " + "y = " + String.valueOf(event.getY()) + "\t" + "width = " + String.valueOf(layoutWidth) + ", height = " + String.valueOf(layoutHeight) + "\n");

        return super.onTouchEvent(event);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        ConstraintLayout layout = findViewById(R.id.activity_main);
        layoutWidth = layout.getWidth();
        layoutHeight = layout.getHeight();
    }
}
