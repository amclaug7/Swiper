package com.example.andrew.swiper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.View;
import android.view.MotionEvent;
import android.util.Log;

public class ThirdActivity extends AppCompatActivity implements GestureDetector.OnGestureListener{
    public static final String TA = "Third Activity";
    private GestureDetector detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        //setup touch event handling
        View view = findViewById(android.R.id.content);
        Log.w(TA, "view = " + view);
        detector = new GestureDetector(this, this);
    }

    public boolean onTouchEvent(MotionEvent event){
        detector.onTouchEvent(event);
        return true;
    }

    public boolean onFling(MotionEvent e1, MotionEvent e2, final float velocityX, final float velocityY){
        Log.w(TA, "Inside onFling");
        return true;
    }

    public boolean onDown(MotionEvent e){
        Log.w(TA, "Inside onDown");
        return true;
    }

    public void onLongPress(MotionEvent e){
        Log.w(TA, "Inside onLongPress");
    }

    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY){
        Log.w(TA, "Inside onScroll");

        if(distanceX > 10){
            Intent myIntent = new Intent(this, MainActivity.class);
            this.startActivity(myIntent);
            overridePendingTransition(R.anim.slide_from_right, 0);
        }
        else if(distanceX < 10){
            Intent myIntent = new Intent(this, SecondActivity.class);
            this.startActivity(myIntent);
            overridePendingTransition(R.anim.slide_from_left, 0);
        }
        return true;
    }

    public void onShowPress(MotionEvent e){
        Log.w(TA, "Inside onShowPress");
    }

    public boolean onSingleTapUp(MotionEvent e){
        Log.w(TA, "Inside onSingleTapUp");
        return true;
    }
}
