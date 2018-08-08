package com.example.propertyanimatordemo;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.graphics.Interpolator;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    AccelerateInterpolator accelerateInterpolator;
    FrameLayout frameLayout;
    View it_view,it_view1,it_view2,it_view3;
    View cp_view;
    View mEnsurePower,mEnsureReset;
    ImageView ac_icon,ac_icon1,ac_icon2;
    TextView ac_tv0,ac_tv;
    Button btn_property,btn_cancle,btn_back_off;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.action_wrapped);

        frameLayout = findViewById(R.id.action_fl);

        btn_property = findViewById(R.id.btn_on);
        btn_property.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animAction();
            }
        });

        btn_cancle = findViewById(R.id.btn_cancle);
        btn_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancleAnimAction();
            }
        });
        initItem();
        mEnsurePower = findViewById(R.id.global_ensure_power);
        mEnsureReset = findViewById(R.id.global_ensure_power);

//        getSupportActionBar().hide();

        ac_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eneSureOffAnimAction();
            }
        });
        ac_icon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enReboot();
            }
        });

        btn_back_off = findViewById(R.id.btn_back);
        btn_back_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancleEneSureOffAnimAction();
            }
        });
        getFrameView();
    }

    private void enReboot() {
        accelerateInterpolator = new AccelerateInterpolator();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            it_view1.setTranslationY(0);
            it_view1.setTranslationX(0);
            it_view1.setPivotX(192);
            it_view1.setPivotY(0);
            it_view1.animate()
                    .setInterpolator(accelerateInterpolator)
                    .scaleX(1.5f)
                    .scaleY(1.5f)
                    .translationX(-132)
                    .translationY(144)
                    .setDuration(240)
                    .withEndAction(new Runnable() {
                        @Override
                        public void run() {
//                            Drawable drawable = null;
//                            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
//                                drawable = getDrawable(R.drawable.tct_ensure_power);
//                            }
//                            ac_icon.setImageDrawable(drawable);
//                            ac_tv0.setText("确认关机");
//                            it_view1.setVisibility(View.GONE);
                            mEnsurePower.setVisibility(View.VISIBLE);
                        }
                    })
                    .start();


            it_view.setTranslationX(0);
            it_view.setTranslationY(0);
            it_view.animate()
                    .alpha(0)
                    .setInterpolator(accelerateInterpolator)
                    .translationX(-288)
                    .translationY(-288)
                    .setDuration(240)
                    .start();

//        it_view2.setAlpha(0);
            it_view2.setTranslationX(0);
            it_view2.animate()
                    .setInterpolator(accelerateInterpolator)
                    .alpha(0)
                    .translationX(-288)
                    .setDuration(240)
                    .start();

//        it_view3.setAlpha(0);
            it_view3.setTranslationX(0);
            it_view3.animate()
                    .setInterpolator(accelerateInterpolator)
                    .alpha(0)
                    .translationX(288)
                    .setDuration(240)
                    .start();
        }
    }

    private void getFrameView() {
        for(int i = 0;i< frameLayout.getChildCount();i++){
            cp_view = frameLayout.getChildAt(i);
            if(cp_view == it_view){
                Log.d("attttt","saddaddsi---" +i );
            }
        }

    }

    private void cancleEneSureOffAnimAction() {
        accelerateInterpolator = new AccelerateInterpolator();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//            it_view.setTranslationY(0);
//            it_view.setTranslationX(0);
//            it_view.setPivotX(0);
//            it_view.setPivotY(0);
            mEnsurePower.setVisibility(View.GONE);
            it_view.setVisibility(View.VISIBLE);
            it_view.animate()
                    .setInterpolator(accelerateInterpolator)
                    .scaleX(1f)
                    .scaleY(1f)
                    .translationX(0)
                    .translationY(0)
                    .setDuration(240)
//                    .withEndAction(new Runnable() {
//                        @Override
//                        public void run() {
//                            Drawable drawable = null;
//                            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
//                                drawable = getDrawable(R.drawable.wt_ic_lock_power_off);
//                            }
//                            ac_icon.setImageDrawable(drawable);
//                            ac_tv0.setText("关机");
//                        }
//                    })
                    .start();


//            it_view1.setTranslationX(0);
//            it_view1.setTranslationY(0);
            it_view1.animate()
                    .setInterpolator(accelerateInterpolator)
                    .alpha(1f)
                    .translationX(0)
                    .translationY(0)
                    .setDuration(240)
                    .start();

//        it_view2.setAlpha(0);
//            it_view2.setTranslationX(0);
//            it_view2.setTranslationY(0);
            it_view2.animate()
                    .setInterpolator(accelerateInterpolator)
                    .alpha(1f)
                    .translationX(0)
                    .setDuration(240)
                    .start();

//        it_view3.setAlpha(0);
//            it_view3.setTranslationX(0);
//            it_view3.setTranslationY(0);
            it_view3.animate()
                    .setInterpolator(accelerateInterpolator)
                    .alpha(1f)
                    .translationX(0)
                    .setDuration(240)
                    .start();
        }
    }

    private void eneSureOffAnimAction() {

        accelerateInterpolator = new AccelerateInterpolator();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            it_view.setTranslationY(0);
            it_view.setTranslationX(0);
            it_view.setPivotX(0);
            it_view.setPivotY(0);
            it_view.animate()
                    .setInterpolator(accelerateInterpolator)
                    .scaleX(1.5f)
                    .scaleY(1.5f)
                    .translationX(132)
                    .translationY(144)
                    .setDuration(240)
                    .withEndAction(new Runnable() {
                        @Override
                        public void run() {
//                            Drawable drawable = null;
//                            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
//                                drawable = getDrawable(R.drawable.tct_ensure_power);
//                            }
//                            ac_icon.setImageDrawable(drawable);
//                            ac_tv0.setText("确认关机");
//                            it_view.setVisibility(View.GONE);
                            mEnsurePower.setVisibility(View.VISIBLE);
                        }
                    })
                    .start();


            it_view1.setTranslationX(0);
            it_view1.setTranslationY(0);
            it_view1.animate()
                    .alpha(0)
                    .setInterpolator(accelerateInterpolator)
                    .translationX(288)
                    .translationY(-288)
                    .setDuration(240)
                    .start();

//        it_view2.setAlpha(0);
            it_view2.setTranslationX(0);
            it_view2.animate()
                    .setInterpolator(accelerateInterpolator)
                    .alpha(0)
                    .translationX(-288)
                    .setDuration(240)
                    .start();

//        it_view3.setAlpha(0);
            it_view3.setTranslationX(0);
            it_view3.animate()
                    .setInterpolator(accelerateInterpolator)
                    .alpha(0)
                    .translationX(288)
                    .setDuration(240)
                    .start();
        }
    }

    private void cancleAnimAction() {
        it_view.setTranslationX(0);
        it_view.setTranslationY(0);
//        it_view.setAlpha(0);
        it_view.animate()
                .alpha(0)
                .setInterpolator(accelerateInterpolator)
                .translationX(-288)
                .translationY(-288)
                .setDuration(240)
                .start();

//        it_view1.setAlpha(0);
        it_view1.setTranslationX(0);
        it_view1.setTranslationY(0);
        it_view1.animate()
                .alpha(0)
                .setInterpolator(accelerateInterpolator)
                .translationX(288)
                .translationY(-288)
                .setDuration(240)
                .start();

//        it_view2.setAlpha(0);
        it_view2.setTranslationX(0);
        it_view2.setTranslationY(0);
        it_view2.animate()
                .alpha(0)
                .setInterpolator(accelerateInterpolator)
                .translationX(-288)
                .translationY(288)
                .setDuration(240)
                .start();

//        it_view3.setAlpha(0);
        it_view3.setTranslationX(0);
        it_view3.setTranslationY(0);
        it_view3.animate()
                .alpha(0)
                .setInterpolator(accelerateInterpolator)
                .translationX(288)
                .translationY(288)
                .setDuration(240)
                .start();
    }

    private void createTranSlation() {
        TranslateAnimation translateAnimation1 = new TranslateAnimation(0,-300,0,0);
        translateAnimation1.setDuration(1000);
        it_view.startAnimation(translateAnimation1);
    }

    private void animAction() {
        it_view.setTranslationX(-288);
        it_view.setTranslationY(-288);
        it_view.setAlpha(0);
        it_view.animate()
                .setInterpolator(accelerateInterpolator)
                .alpha(1f)
                .translationX(0)
                .translationY(0)
                .setDuration(240)
                .start();

        it_view1.setAlpha(0);
        it_view1.setTranslationX(288);
        it_view1.setTranslationY(-288);
        it_view1.animate()
                .alpha(1f)
                .setInterpolator(accelerateInterpolator)
                .translationX(0)
                .translationY(0)
                .setDuration(240)
                .start();

        it_view2.setAlpha(0);
        it_view2.setTranslationX(-288);
        it_view2.setTranslationY(288);
        it_view2.animate()
                .alpha(1f)
                .setInterpolator(accelerateInterpolator)
                .translationX(0)
                .translationY(0)
                .setDuration(240)
                .start();

        it_view3.setAlpha(0);
        it_view3.setTranslationX(288);
        it_view3.setTranslationY(288);
        it_view3.animate()
                .alpha(1f)
                .setInterpolator(accelerateInterpolator)
                .translationX(0)
                .translationY(0)
                .setDuration(240)
                .start();
    }

    private void initItem() {
        it_view = getLayoutInflater().inflate(R.layout.item_msg,null);
        ac_icon = it_view.findViewById(R.id.action_img);
        ac_tv0 = it_view.findViewById(R.id.action_msg);
        frameLayout.addView(it_view);
        setPosition(it_view,0);

        it_view1 = getLayoutInflater().inflate(R.layout.item_msg,null);
        ac_icon1 = it_view1.findViewById(R.id.action_img);
        ac_tv = it_view1.findViewById(R.id.action_msg);
        ac_tv.setText("重启");
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            Drawable drawable = getDrawable(R.drawable.wt_ic_lock_power_reboot);
            ac_icon1.setImageDrawable(drawable);
        }
        frameLayout.addView(it_view1);
        setPosition(it_view1,1);

//        if(null != it_view){
            it_view2 = getLayoutInflater().inflate(R.layout.item_msg,null);
            ac_icon2 = it_view2.findViewById(R.id.action_img);
            ac_tv = it_view2.findViewById(R.id.action_msg);
            ac_tv.setText("飞行模式");
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                Drawable drawable = getDrawable(R.drawable.wt_ic_lock_airplane_mode_off);
                ac_icon2.setImageDrawable(drawable);
            }
//        }
        frameLayout.addView(it_view2);
        setPosition(it_view2,2);

        it_view3 = getLayoutInflater().inflate(R.layout.item_msg,null);
        ac_icon2 = it_view3.findViewById(R.id.action_img);
        ac_tv = it_view3.findViewById(R.id.action_msg);
        ac_tv.setText("响铃模式");
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            Drawable drawable = getDrawable(R.drawable.wt_ic_lock_sound);
            ac_icon2.setImageDrawable(drawable);
        }
//        }
        frameLayout.addView(it_view3);
        setPosition(it_view3,3);
    }

    private void setPosition(View it_view, int i) {
        FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) it_view.getLayoutParams();
        if(0 == i){
            lp.rightMargin = 360;
        }else if(1 == i){
            lp.leftMargin = 360;
        }else if(2 == i){
            lp.topMargin = 288;
            lp.rightMargin = 360;
        }else {
            lp.topMargin = 288;
            lp.leftMargin = 360;
        }
        it_view.setLayoutParams(lp);
    }
}
