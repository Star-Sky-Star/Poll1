package com.star.poll;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    protected ViewFlipper mPoll;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mPoll = (ViewFlipper) findViewById(R.id.poll);

        Animation animationIn = AnimationUtils.loadAnimation(this, R.anim.in);
        Animation animationOut = AnimationUtils.loadAnimation(this, R.anim.out);

        mPoll.setInAnimation(animationIn);
        mPoll.setOutAnimation(animationOut);
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                mPoll.showNext();
                mHandler.postDelayed(this,2500);
            }
        });


    }


}
