package com.bbwy.base.app.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.bbwy.base.app.R;
import com.gyf.immersionbar.ImmersionBar;
import com.king.base.BaseActivity;
import com.king.base.util.SharedPreferencesUtils;
import com.king.base.util.ToastUtils;
import com.wildma.pictureselector.PictureBean;
import com.wildma.pictureselector.PictureSelector;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class ResultJlActivity extends BaseActivity {
    private Disposable mDisposable;
    @BindView(R.id.count)
    TextView count;
    @BindView(R.id.close)
    ImageView close;
    @BindView(R.id.light)
    ImageView light;
    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.num)
    TextView num;
    @BindView(R.id.money)
    TextView money;
    @BindView(R.id.result)
    TextView result;
    @BindView(R.id.bt)
    TextView bt;
    @Override
    public void initUI() {
        setContentView(R.layout.activity_result_jl);
    }

    @Override
    public void initData() {
        startTime();
        Animation rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate_anim);
        LinearInterpolator lin = new LinearInterpolator();
        rotateAnimation.setInterpolator(lin);
        light.startAnimation(rotateAnimation);
        int type = getIntent().getIntExtra("tag",0);
        int number = getIntent().getIntExtra("num",0);
        result.setText("恭喜获得"+number+"金币");
        SharedPreferencesUtils.put(getContext(), "jb", SharedPreferencesUtils.getInt(getContext(),"jb")+number);
        if (type ==1)img.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_jbjl));
        int all = SharedPreferencesUtils.getInt(getContext(), "jb");
        num.setText(all+"");
        money.setText( "≈"+(double) all/1000);
        anin(bt);
        setBarScreen();
    }
    public void startTime() {
        Observable.interval(0, 1, TimeUnit.SECONDS)
                .take(4)//设置总共发送的次数
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
                        count.setText(3-value+"");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        count.setVisibility(View.GONE);
                        close.setVisibility(View.VISIBLE);
                    }
                });
    }
    @OnClick(R.id.close)
    protected void close(){
        finish();
    }
    @OnClick(R.id.bt)
    protected void bt(){
        ToastUtils.showToast(getApplicationContext(),"点击了翻倍");
    }
    @OnClick(R.id.gg)
    protected void gg(){
        Intent intent = new Intent(getContext(), WebActivity.class);
        intent.putExtra("title", "柳州螺蛳粉");
        intent.putExtra("url", "http://baidu.com");
        startActivity(intent);
    }
    private void anin(View view){
        AnimatorSet animatorSetsuofang = new AnimatorSet();//组合动画
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(view, "scaleX", 1, 1.1f,1);//后几个参数是放大的倍数
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(view, "scaleY", 1, 1.1f,1);
        scaleX.setRepeatCount(ValueAnimator.INFINITE);//永久循环
        scaleY.setRepeatCount(ValueAnimator.INFINITE);
        animatorSetsuofang.setDuration(3000);//时间
        animatorSetsuofang.play(scaleX).with(scaleY);//两个动画同时开始
        animatorSetsuofang.start();//开始
    }
    /**
     * 全屏显示
     */
    protected void setBarScreen() {
        ImmersionBar immersionBar = ImmersionBar.with(this)
                .fitsSystemWindows(false)
                .transparentStatusBar();
        immersionBar.statusBarDarkFont(true, 0.2f);
        immersionBar.init();
    }
}