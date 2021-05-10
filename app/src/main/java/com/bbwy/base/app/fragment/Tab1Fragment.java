package com.bbwy.base.app.fragment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.RelativeSizeSpan;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bbwy.base.app.R;
import com.bbwy.base.app.activity.ResultJlActivity;
import com.bbwy.base.app.activity.TiXianActivity;
import com.bbwy.base.app.adapter.HomeAdapter;
import com.bbwy.base.app.adapter.JbRecordAdapter;
import com.bbwy.base.app.bean.GoEvent;
import com.bbwy.base.app.util.RunUtils;
import com.bbwy.base.app.util.RxBus;
import com.king.base.BaseFragment;
import com.king.base.util.SharedPreferencesUtils;
import com.king.base.util.TimeUtils;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.netopen.hotbitmapgg.view.NewCreditSesameView;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class Tab1Fragment extends BaseFragment implements HomeAdapter.OnItemClickListener{
    @BindView(R.id.sesame_view)
    NewCreditSesameView newCreditSesameView;
    @BindView(R.id.note)
    TextView note;
    @BindView(R.id.num)
    TextView num;
    @BindView(R.id.gl)
    TextView gl;
    @BindView(R.id.kll)
    TextView kll;
    @BindView(R.id.time)
    TextView time;
    @BindView(R.id.num1)
    RelativeLayout num1;
    @BindView(R.id.num2)
    RelativeLayout num2;
    @BindView(R.id.num3)
    RelativeLayout num3;
    @BindView(R.id.num4)
    RelativeLayout num4;
    @BindView(R.id.hand)
    ImageView hand;
    private SensorManager mSensorManager;
    private MySensorEventListener mListener;
    private int mStepCounter = 0;   // 自系统开机以来STEP_COUNTER检测到的步数
    private int todayNum;
    private GifDrawable walk;
    @BindView(R.id.img)
    GifImageView gif;
    private int level;
    private int levelDef;
    @BindView(R.id.recycle)
    RecyclerView recyclerView;
    private HomeAdapter adapter;

    @Override
    public int inflaterRootView() {
        return R.layout.fragment_tab1;
    }

    @OnClick(R.id.goLay)
    protected void goLay() {
        RxBus.getInstance().send(new GoEvent());
    }

    @Override
    public void initUI() {
        mSensorManager = (SensorManager) getContext().getSystemService(Context.SENSOR_SERVICE);
        mListener = new MySensorEventListener();
        mSensorManager.registerListener(mListener, mSensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER),
                SensorManager.SENSOR_DELAY_NORMAL);

        try {
            walk = new GifDrawable(getActivity().getAssets(), "walk.gif");
        } catch (IOException e) {
            e.printStackTrace();
        }
        gif.setImageDrawable(walk);
        walk.start();
        floatAnim(num1, 0);
        floatAnim(hand, 0);
        floatAnim(num2, 100);
        floatAnim(num3, 300);
        floatAnim(num4, 0);
    }

    @Override
    public void initData() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        List<Integer> list = new ArrayList<>();
        list.add(R.drawable.bg_activit);
        list.add(R.drawable.bg_activit);
        list.add(R.drawable.bg_activit);
        list.add(R.drawable.bg_activit);
        list.add(R.drawable.bg_activit);
        list.add(R.drawable.bg_activit);
        adapter = new HomeAdapter(getContext(), list, R.layout.item_home);
        adapter.setOnItemClickListener(this);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        String today = TimeUtils.getCurrentDate("yyyy-MM-dd");

        if (!hidden) {
            if (newCreditSesameView != null) newCreditSesameView.setNum(todayNum);
            setData();
        }

    }


    class MySensorEventListener implements SensorEventListener {
        @Override
        public void onSensorChanged(SensorEvent event) {
            if (event.sensor.getType() == Sensor.TYPE_STEP_COUNTER) {
                mStepCounter = (int) event.values[0];
            }
            String today = TimeUtils.getCurrentDate("yyyy-MM-dd");
            if (SharedPreferencesUtils.getInt(getContext(), today) == 0) {
                SharedPreferencesUtils.put(getContext(), today, mStepCounter);
            }

            if (todayNum ==0){
                todayNum = mStepCounter - SharedPreferencesUtils.getInt(getContext(), today);
                level = 1;
                levelDef = 1500;
                newCreditSesameView.setNum(todayNum);
                setData();
            }
            todayNum = mStepCounter - SharedPreferencesUtils.getInt(getContext(), today);
            for (int i = 1; i < 100; i++) {
                if ((i * (i - 1) * 500 / 2 + 1500) * 4 > todayNum) {
                    level = i;
                    break;
                } else if ((i * (i - 1) * 500 / 2 + 1500) * 4 <= todayNum && ((i + 1) * (i + 1 - 1) * 500 / 2 + 1500) * 4 > todayNum) {
                    level = i;
                    break;
                }
            }
            levelDef = (level * (level - 1) * 500 / 2 + 1500);
            SharedPreferencesUtils.put(getContext(), today + "_walk_num", todayNum);
            Log.e("eee", "设备检测到您今日走了步" + todayNum);
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    }

    private void setData() {
        String today = TimeUtils.getCurrentDate("yyyy-MM-dd");
        int m = todayNum / 100;
        int h = 0;
        h = m / 60;
        m = m % 60;
        String hh = h > 9 ? h + "" : "0" + h;
        String mm = m > 9 ? m + "" : "0" + m;

        DecimalFormat fnum = new DecimalFormat("##0.0");
        String times = hh + "时" + mm + "分";
        String gls = fnum.format(RunUtils.getDistanceByStep(todayNum)) + "公里";
        String klls = fnum.format(RunUtils.getCalorieByStep(todayNum)) + "卡路里";
        SpannableString spannableString = new SpannableString(gls);
        RelativeSizeSpan sizeSpan01 = new RelativeSizeSpan(1.8f);
        spannableString.setSpan(sizeSpan01, 0, spannableString.length() - 2, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        gl.setText(spannableString);

        SpannableString spannableString2 = new SpannableString(klls);
        RelativeSizeSpan sizeSpan02 = new RelativeSizeSpan(1.8f);
        spannableString2.setSpan(sizeSpan02, 0, spannableString2.length() - 3, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        kll.setText(spannableString2);

        SpannableString spannableString3 = new SpannableString(times);
        RelativeSizeSpan sizeSpan03 = new RelativeSizeSpan(1.8f);
        RelativeSizeSpan sizeSpan04 = new RelativeSizeSpan(1.8f);
        spannableString3.setSpan(sizeSpan03, 0, 2, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString3.setSpan(sizeSpan04, 3, 5, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        time.setText(spannableString3);


        num.setText(todayNum + "");
        if (todayNum < levelDef) {
            note.setText("满"+levelDef+"步领50金币");
        } else if (todayNum < levelDef*2) {
            note.setText("满"+levelDef*2+"步领80金币");
            if (SharedPreferencesUtils.getInt(getContext(), today + "1_level"+level, 0) == 0) {
                num1.setVisibility(View.VISIBLE);
                hand.setVisibility(View.VISIBLE);
            }
        } else if (todayNum < levelDef*3) {
            note.setText("满"+levelDef*3+"步领100金币");
            if (SharedPreferencesUtils.getInt(getContext(), today + "2_level"+level, 0) == 0) num2.setVisibility(View.VISIBLE);
        } else if (todayNum < levelDef*4) {
            note.setText("满"+levelDef*4+"步领150金币");
            if (SharedPreferencesUtils.getInt(getContext(), today + "3_level"+level, 0) == 0) num3.setVisibility(View.VISIBLE);
        } else {
            if (SharedPreferencesUtils.getInt(getContext(), today + "4_level"+level, 0) == 0) num4.setVisibility(View.VISIBLE);
        }
    }

    @OnClick(R.id.num1)
    protected void num1() {
        String today = TimeUtils.getCurrentDate("yyyy-MM-dd");
        num1.setVisibility(View.GONE);
        hand.setVisibility(View.GONE);
        SharedPreferencesUtils.put(getContext(), today + "1_level"+level, 1);
        Intent intent = new Intent(getContext(), ResultJlActivity.class);
        intent.putExtra("tag", 1);
        intent.putExtra("num", 50);
        startActivity(intent);
    }

    @OnClick(R.id.num2)
    protected void num2() {
        String today = TimeUtils.getCurrentDate("yyyy-MM-dd");
        num2.setVisibility(View.GONE);
        SharedPreferencesUtils.put(getContext(), today + "2_level"+level, 1);
        Intent intent = new Intent(getContext(), ResultJlActivity.class);
        intent.putExtra("tag", 1);
        intent.putExtra("num", 80);
        startActivity(intent);
    }

    @OnClick(R.id.num3)
    protected void num3() {
        String today = TimeUtils.getCurrentDate("yyyy-MM-dd");
        num3.setVisibility(View.GONE);
        SharedPreferencesUtils.put(getContext(), today + "3_level"+level, 1);
        Intent intent = new Intent(getContext(), ResultJlActivity.class);
        intent.putExtra("tag", 1);
        intent.putExtra("num", 100);
        startActivity(intent);
    }

    @OnClick(R.id.num4)
    protected void num4() {
        String today = TimeUtils.getCurrentDate("yyyy-MM-dd");
        num4.setVisibility(View.GONE);
        SharedPreferencesUtils.put(getContext(), today + "4_level"+level, 1);
        Intent intent = new Intent(getContext(), ResultJlActivity.class);
        intent.putExtra("tag", 1);
        intent.putExtra("num", 150);
        startActivity(intent);
    }

    @SuppressLint("WrongConstant")
    private void floatAnim(View view, int delay) {
        List<Animator> animators = new ArrayList<>();
        ObjectAnimator translationXAnim = ObjectAnimator.ofFloat(view, "translationX", -6.0f, 6.0f, -6.0f);
        translationXAnim.setDuration(1500);
        translationXAnim.setRepeatCount(ValueAnimator.INFINITE);//无限循环
        translationXAnim.setRepeatMode(ValueAnimator.INFINITE);//
        translationXAnim.start();
        animators.add(translationXAnim);
        ObjectAnimator translationYAnim = ObjectAnimator.ofFloat(view, "translationY", -3.0f, 3.0f, -3.0f);
        translationYAnim.setDuration(1000);
        translationYAnim.setRepeatCount(ValueAnimator.INFINITE);
        translationYAnim.setRepeatMode(ValueAnimator.INFINITE);
        translationYAnim.start();
        animators.add(translationYAnim);

        AnimatorSet btnSexAnimatorSet = new AnimatorSet();
        btnSexAnimatorSet.playTogether(animators);
        btnSexAnimatorSet.setStartDelay(delay);
        btnSexAnimatorSet.start();
    }
    @Override
    public void onItemClick(View v, int position) {
        Intent intent = new Intent(getContext(), TiXianActivity.class);
        startActivity(intent);
    }

}