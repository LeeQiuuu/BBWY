package com.bbwy.base.app.fragment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.text.format.Time;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bbwy.base.app.R;
import com.bbwy.base.app.activity.ResultJlActivity;
import com.bbwy.base.app.bean.JbEvent;
import com.bbwy.base.app.util.RxBus;
import com.king.base.BaseFragment;
import com.king.base.util.SharedPreferencesUtils;
import com.king.base.util.TimeUtils;
import com.king.base.util.ToastUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class Tab2Fragment extends BaseFragment {
    @BindView(R.id.bt1)
    TextView pp;
    @BindView(R.id.bt2)
    TextView js;
    @BindView(R.id.bt3)
    TextView pb;
    @BindView(R.id.bt4)
    TextView wj;
    @BindView(R.id.bt5)
    TextView lq;
    @BindView(R.id.bt6)
    TextView zq;
    @BindView(R.id.ppLay)
    RelativeLayout ppLay;
    @BindView(R.id.jsLay)
    RelativeLayout jsLay;
    @BindView(R.id.pbLay)
    RelativeLayout pbLay;
    @BindView(R.id.zqLay)
    RelativeLayout zqLay;
    @BindView(R.id.lqLay)
    RelativeLayout lqLay;
    @BindView(R.id.tqLay)
    RelativeLayout tqLay;

    @BindView(R.id.ppTime)
    TextView ppTime;
    @BindView(R.id.jsTime)
    TextView jsTime;
    @BindView(R.id.pbTime)
    TextView pbTime;
    @BindView(R.id.zqTime)
    TextView zqTime;
    @BindView(R.id.lqTime)
    TextView lqTime;
    @BindView(R.id.tqTime)
    TextView tqTime;
    private boolean hasRuning;
    @BindView(R.id.img)
    GifImageView gif;
    private GifDrawable gifPP, gifJS, gifTQ, gifLQ, gifQC, gifPB;
    private Disposable mDisposable;
    private int position;
    private String today ;

    @Override
    public int inflaterRootView() {
        return R.layout.fragment_tab2;
    }

    @Override
    public void initUI() {

    }

    @Override
    public void initData() {
        today = TimeUtils.getCurrentDate("yyyy-MM-dd");
        long now = new Date().getTime();
        long ppT = SharedPreferencesUtils.getSharedPreferences(getContext()).getLong(today+"ppq", 0);
        long jsT = SharedPreferencesUtils.getSharedPreferences(getContext()).getLong(today+"jsc", 0);
        long pbT = SharedPreferencesUtils.getSharedPreferences(getContext()).getLong(today+"pb", 0);
        long wjT = SharedPreferencesUtils.getSharedPreferences(getContext()).getLong(today+"wjqw", 0);
        long lqT = SharedPreferencesUtils.getSharedPreferences(getContext()).getLong(today+"dlq", 0);
        long zqT = SharedPreferencesUtils.getSharedPreferences(getContext()).getLong(today+"tzq", 0);
        if (ppT != 0) {
            if (ppT== -1){
                finishs(pp);
            }
            else if (now - ppT >= 60*1000) {
                finishs(pp);
                floatAnim(ppLay,300);
                ppLay.setVisibility(View.VISIBLE);
                ppTime.setVisibility(View.GONE);
            } else {
                runing(pp);
                hasRuning = true;
                position = 1;
                ppLay.setVisibility(View.VISIBLE);
                floatAnim(ppLay,0);
                startTime(60-((now - ppT) / 1000));
                try {
                    gifPP = new GifDrawable(getActivity().getAssets(), "pp.gif");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                gif.setImageDrawable(gifPP);
                gifPP.start();
            }
        }
        if (jsT != 0) {
            if (jsT== -1){
                finishs(js);
            }
            else if (now - jsT >= 60*1000*5) {
                finishs(js);
                floatAnim(jsLay,0);
                jsTime.setVisibility(View.GONE);
            } else {
                runing(js);
                hasRuning = true;
                position = 2;
                jsLay.setVisibility(View.VISIBLE);
                floatAnim(jsLay,0);
                try {
                    gifJS = new GifDrawable(getActivity().getAssets(), "js.gif");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                gif.setImageDrawable(gifJS);
                gifJS.start();
                startTime(60*5-((now - jsT) / 1000));
            }
        }
        if (pbT != 0) {
            if (pbT== -1){
                finishs(pb);
            }
            else if (now - pbT >= 60*1000*15) {
                finishs(pb);
                floatAnim(pbLay,100);
                pbTime.setVisibility(View.GONE);
            } else {
                runing(pb);
                hasRuning = true;
                position = 3;
                pbLay.setVisibility(View.VISIBLE);
                floatAnim(pbLay,0);
                try {
                    gifPB = new GifDrawable(getActivity().getAssets(), "pb.gif");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                gif.setImageDrawable(gifPB);
                gifPB.start();
                startTime(60*15-((now - pbT) / 1000));
            }
        }
        if (wjT != 0) {
            if (wjT== -1){
                finishs(wj);
            }
            else if (now - wjT >= 10*1000) {
                finishs(wj);
                floatAnim(zqLay,300);
                zqTime.setVisibility(View.GONE);
            } else {
                runing(wj);
                hasRuning = true;
                position = 4;
                zqLay.setVisibility(View.VISIBLE);
                floatAnim(zqLay,0);
                startTime(10-((now - wjT) / 1000));
            }
        }
        if (lqT != 0) {
            if (lqT== -1){
                finishs(lq);
            }
            else if (now - lqT >= 60*1000*20) {
                finishs(lq);
                floatAnim(lqLay,100);
                lqTime.setVisibility(View.GONE);
            } else {
                runing(lq);
                hasRuning = true;
                position = 5;
                lqLay.setVisibility(View.VISIBLE);
                floatAnim(lqLay,0);
                startTime(60*20-((now - lqT) / 1000));
                try {
                    gifLQ = new GifDrawable(getActivity().getAssets(), "lq.gif");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                gif.setImageDrawable(gifLQ);
                gifLQ.start();
            }
        }
        if (zqT != 0) {
            if (zqT== -1){
                finishs(zq);
            }
            else if (now - zqT >= 60*1000*30) {
                finishs(zq);
                floatAnim(tqLay,200);
                zqTime.setVisibility(View.GONE);
            } else {
                runing(zq);
                hasRuning = true;
                position = 6;
                tqLay.setVisibility(View.VISIBLE);
                floatAnim(tqLay,0);
                startTime(60*30-((now - zqT) / 1000));
                try {
                    gifTQ = new GifDrawable(getActivity().getAssets(), "tq.gif");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                gif.setImageDrawable(gifTQ);
                gifTQ.start();
            }
        }
    }

    private void finishs(TextView textView) {
        textView.setText("已完成");
        textView.setEnabled(false);
        textView.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.shape_gray_15));
        gif.setImageDrawable(ContextCompat.getDrawable(getContext(),R.drawable.bg_tab2));
    }

    private void runing(TextView textView) {
        textView.setText("进行中");
        textView.setEnabled(false);
        textView.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.shape_red_15));
    }

    @OnClick(R.id.bt1)
    protected void pp()  {
        if (!isCurrentInTimeScope(5,0,24,0)){
            ToastUtils.showToast(getActivity().getApplicationContext(),"当前不在活动时间范围");
            return;
        }
        if (hasRuning) {
            ToastUtils.showToast(getActivity().getApplicationContext(), "有其他活动在进行");
            return;
        }
        try {
            gifPP = new GifDrawable(getActivity().getAssets(), "pp.gif");
        } catch (IOException e) {
            e.printStackTrace();
        }
        gif.setImageDrawable(gifPP);
        gifPP.start();
        startTime(60);
        position = 1;
        ppLay.setVisibility(View.VISIBLE);
        floatAnim(ppLay,0);
        SharedPreferencesUtils.put(getContext(), today+"ppq", new Date().getTime());
    }

    @OnClick(R.id.bt2)
    protected void js()   {
        if (!isCurrentInTimeScope(5,0,24,0)){
            ToastUtils.showToast(getActivity().getApplicationContext(),"当前不在活动时间范围");
            return;
        }
        if (hasRuning) {
            ToastUtils.showToast(getActivity().getApplicationContext(), "有其他活动在进行");
            return;
        }
        try {
            gifJS = new GifDrawable(getActivity().getAssets(), "js.gif");
        } catch (IOException e) {
            e.printStackTrace();
        }
        gif.setImageDrawable(gifJS);
        gifJS.start();
        startTime(60 * 5);
        position = 2;
        jsLay.setVisibility(View.VISIBLE);
        floatAnim(jsLay,0);
        SharedPreferencesUtils.put(getContext(), today+"jsc", new Date().getTime());
    }

    @OnClick(R.id.bt3)
    protected void pb()   {
        if (!isCurrentInTimeScope(5,0,24,0)){
            ToastUtils.showToast(getActivity().getApplicationContext(),"当前不在活动时间范围");
            return;
        }
        if (hasRuning) {
            ToastUtils.showToast(getActivity().getApplicationContext(), "有其他活动在进行");
            return;
        }
        try {
            gifPB = new GifDrawable(getActivity().getAssets(), "pb.gif");
        } catch (IOException e) {
            e.printStackTrace();
        }
        gif.setImageDrawable(gifPB);
        gifPB.start();
        startTime(60 * 15);
        position = 3;
        pbLay.setVisibility(View.VISIBLE);
        floatAnim(pbLay,0);
        SharedPreferencesUtils.put(getContext(), today+"pb", new Date().getTime());
    }

    @OnClick(R.id.bt4)
    protected void zq()  {
        if (!isCurrentInTimeScope(5,0,24,0)){
            ToastUtils.showToast(getActivity().getApplicationContext(),"当前不在活动时间范围");
            return;
        }
        if (hasRuning) {
            ToastUtils.showToast(getActivity().getApplicationContext(), "有其他活动在进行");
            return;
        }
      /*  GifDrawable gifPP =  new  GifDrawable(getActivity().getAssets(),".gif");
        gif.setImageDrawable(gifPP);
        gifPP.start();*/
        startTime(10);
        position = 4;
        zqLay.setVisibility(View.VISIBLE);
        floatAnim(zqLay,0);
        SharedPreferencesUtils.put(getContext(), today+"wjqw", new Date().getTime());
    }

    @OnClick(R.id.bt5)
    protected void lq()   {
        if (!isCurrentInTimeScope(5,0,24,0)){
            ToastUtils.showToast(getActivity().getApplicationContext(),"当前不在活动时间范围");
            return;
        }
        if (hasRuning) {
            ToastUtils.showToast(getActivity().getApplicationContext(), "有其他活动在进行");
            return;
        }
        try {
            gifLQ = new GifDrawable(getActivity().getAssets(), "lq.gif");
        } catch (IOException e) {
            e.printStackTrace();
        }
        gif.setImageDrawable(gifLQ);
        gifLQ.start();
        startTime(60 * 20);
        position = 5;
        lqLay.setVisibility(View.VISIBLE);
        floatAnim(lqLay,0);
        SharedPreferencesUtils.put(getContext(), today+"dlq", new Date().getTime());
    }

    @OnClick(R.id.bt6)
    protected void tq()   {
        if (!isCurrentInTimeScope(5,0,24,0)){
            ToastUtils.showToast(getActivity().getApplicationContext(),"当前不在活动时间范围");
            return;
        }
        if (hasRuning) {
            ToastUtils.showToast(getActivity().getApplicationContext(), "有其他活动在进行");
            return;
        }
        try {
            gifTQ = new GifDrawable(getActivity().getAssets(), "tq.gif");
        } catch (IOException e) {
            e.printStackTrace();
        }
        gif.setImageDrawable(gifTQ);
        gifTQ.start();
        startTime(60 * 30);
        position = 6;
        tqLay.setVisibility(View.VISIBLE);
        floatAnim(tqLay,0);
        SharedPreferencesUtils.put(getContext(), today+"tzq", new Date().getTime());
    }

    public void startTime(long time) {
        hasRuning = true;
        Observable.interval(0, 1, TimeUnit.SECONDS)
                .take(time)//设置总共发送的次数
                .map(new Function<Long, Long>() {
                    @Override
                    public Long apply(Long aLong) throws Exception {
                        //aLong从0开始
                        return aLong;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mDisposable = d;
                    }

                    @Override
                    public void onNext(Long value) {
                        //Log.d("Timer",""+value);
                        switch (position) {
                            case 1:
                                ppTime.setText(formatLongToTimeStr(time - value));
                                runing(pp);
                                break;
                            case 2:
                                jsTime.setText(formatLongToTimeStr(time - value));
                                runing(js);
                                break;
                            case 3:
                                pbTime.setText(formatLongToTimeStr(time - value));
                                runing(pb);
                                break;
                            case 4:
                                zqTime.setText(formatLongToTimeStr(time - value));
                                runing(wj);
                                break;
                            case 5:
                                lqTime.setText(formatLongToTimeStr(time - value));
                                runing(lq);
                                break;
                            case 6:
                                tqTime.setText(formatLongToTimeStr(time - value));
                                runing(zq);
                                break;
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        closeTimer();
                        hasRuning = false;
                        switch (position) {
                            case 1:
                                ppTime.setVisibility(View.GONE);
                                if (gifPP != null) gifPP.stop();
                                finishs(pp);
                                break;
                            case 2:
                                jsTime.setVisibility(View.GONE);
                                if (gifJS != null) gifJS.stop();
                                finishs(js);
                                break;
                            case 3:
                                pbTime.setVisibility(View.GONE);
                                finishs(pb);
                                break;
                            case 4:
                                zqTime.setVisibility(View.GONE);
                                if (gifQC != null) gifQC.stop();
                                finishs(wj);
                                break;
                            case 5:
                                lqTime.setVisibility(View.GONE);
                                if (gifLQ != null) gifLQ.stop();
                                finishs(lq);
                                break;
                            case 6:
                                tqTime.setVisibility(View.GONE);
                                if (gifTQ != null) gifTQ.stop();
                                finishs(zq);
                                break;

                        }
                    }
                });
    }

    /**
     * 关闭定时器
     */
    public void closeTimer() {
        if (mDisposable != null) {
            mDisposable.dispose();
        }
    }

    public String formatLongToTimeStr(Long l) {
        int minute = 0;
        int second = 0;
        second = l.intValue();
        if (second > 60) {
            minute = second / 60;   //取整
            second = second % 60;   //取余
        }
        String m =  minute>9?minute+"":"0"+minute;
        String s =  second>9?second+"":"0"+second;
        String strtime = m+ ":" + s;
        return strtime;
    }
    @OnClick(R.id.ppLay)
    protected void ppLay(){
        if (ppTime.getVisibility()==View.VISIBLE)return;
        SharedPreferencesUtils.put(getContext(), today+"ppq", Long.valueOf(-1));
        ppLay.setVisibility(View.GONE);
        Intent intent = new Intent(getContext(), ResultJlActivity.class);
        intent.putExtra("tag",1);
        intent.putExtra("num",20);
        startActivity(intent);
    }
    @OnClick(R.id.jsLay)
    protected void jsLay(){
        if (jsTime.getVisibility()==View.VISIBLE)return;
        SharedPreferencesUtils.put(getContext(), today+"jsc", Long.valueOf(-1));
        jsLay.setVisibility(View.GONE);
        Intent intent = new Intent(getContext(), ResultJlActivity.class);
        intent.putExtra("tag",1);
        intent.putExtra("num",30);
        startActivity(intent);
    }
    @OnClick(R.id.pbLay)
    protected void pbLay(){
        if (pbTime.getVisibility()==View.VISIBLE)return;
        SharedPreferencesUtils.put(getContext(), today+"pb", Long.valueOf(-1));
        pbLay.setVisibility(View.GONE);
        Intent intent = new Intent(getContext(), ResultJlActivity.class);
        intent.putExtra("tag",1);
        intent.putExtra("num",60);
        startActivity(intent);
    }
    @OnClick(R.id.zqLay)
    protected void zqLay(){
        if (zqTime.getVisibility()==View.VISIBLE)return;
        SharedPreferencesUtils.put(getContext(), today+"wjqw", Long.valueOf(-1));
        zqLay.setVisibility(View.GONE);
        Intent intent = new Intent(getContext(), ResultJlActivity.class);
        intent.putExtra("tag",1);
        intent.putExtra("num",20);
        startActivity(intent);
    }
    @OnClick(R.id.lqLay)
    protected void lqLay(){
        if (lqTime.getVisibility()==View.VISIBLE)return;
        SharedPreferencesUtils.put(getContext(), today+"dlq", Long.valueOf(-1));
        lqLay.setVisibility(View.GONE);
        Intent intent = new Intent(getContext(), ResultJlActivity.class);
        intent.putExtra("tag",1);
        intent.putExtra("num",70);
        startActivity(intent);
    }
    @OnClick(R.id.tqLay)
    protected void tqLay(){
        if (tqTime.getVisibility()==View.VISIBLE)return;
        SharedPreferencesUtils.put(getContext(), today+"tzq", Long.valueOf(-1));
        tqLay.setVisibility(View.GONE);
        Intent intent = new Intent(getContext(), ResultJlActivity.class);
        intent.putExtra("tag",1);
        intent.putExtra("num",80);
        startActivity(intent);
    }
    public static boolean isCurrentInTimeScope(int beginHour, int beginMin, int endHour, int endMin) {
        boolean result = false;
        final long aDayInMillis = 1000 * 60 * 60 * 24;
        final long currentTimeMillis = System.currentTimeMillis();

        Time now = new Time();
        now.set(currentTimeMillis);

        Time startTime = new Time();
        startTime.set(currentTimeMillis);
        startTime.hour = beginHour;
        startTime.minute = beginMin;

        Time endTime = new Time();
        endTime.set(currentTimeMillis);
        endTime.hour = endHour;
        endTime.minute = endMin;

        if (!startTime.before(endTime)) {
// 跨天的特殊情况（比如22:00-8:00）
            startTime.set(startTime.toMillis(true) - aDayInMillis);
            result = !now.before(startTime) && !now.after(endTime); // startTime <= now <= endTime
            Time startTimeInThisDay = new Time();
            startTimeInThisDay.set(startTime.toMillis(true) + aDayInMillis);
            if (!now.before(startTimeInThisDay)) {
                result = true;
            }
        } else {
// 普通情况(比如 8:00 - 14:00)
            result = !now.before(startTime) && !now.after(endTime); // startTime <= now <= endTime
        }
        return result;
    }
    @SuppressLint("WrongConstant")
    private void floatAnim(View view, int delay){
        view.setVisibility(View.VISIBLE);
        List<Animator> animators = new ArrayList<>();
        ObjectAnimator translationXAnim = ObjectAnimator.ofFloat(view, "translationX", -6.0f,6.0f,-6.0f);
        translationXAnim.setDuration(1500);
        translationXAnim.setRepeatCount(ValueAnimator.INFINITE);//无限循环
        translationXAnim.setRepeatMode(ValueAnimator.INFINITE);//
        translationXAnim.start();
        animators.add(translationXAnim);
        ObjectAnimator translationYAnim = ObjectAnimator.ofFloat(view, "translationY", -3.0f,3.0f,-3.0f);
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
}