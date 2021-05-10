package com.bbwy.base.app.activity;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bbwy.base.app.R;
import com.gyf.immersionbar.ImmersionBar;
import com.king.base.BaseActivity;
import com.king.base.util.SharedPreferencesUtils;
import com.king.base.util.ToastUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by LeeQiuuu on 2020/6/23.
 */
public class TiXianActivity extends BaseActivity {
    @BindView(R.id.num)
    TextView num;
    @BindView(R.id.needNum)
    TextView needNum;
    @BindView(R.id.lay1)
    RelativeLayout lay1;
    @BindView(R.id.lay2)
    RelativeLayout lay2;
    @BindView(R.id.lay3)
    RelativeLayout lay3;
    @BindView(R.id.lay4)
    RelativeLayout lay4;
    @BindView(R.id.lay5)
    RelativeLayout lay5;
    @BindView(R.id.lay6)
    RelativeLayout lay6;
    @BindView(R.id.img1)
    ImageView img1;
    @BindView(R.id.img2)
    ImageView img2;
    @BindView(R.id.img3)
    ImageView img3;
    @BindView(R.id.img4)
    ImageView img4;
    @BindView(R.id.img5)
    ImageView img5;
    @BindView(R.id.img6)
    ImageView img6;
    @Override
    public void initUI() {
        setContentView(R.layout.activity_tixian);
    }

    @Override
    public void initData() {
        setBarScreen();
        long jbNum = SharedPreferencesUtils.getInt(getContext(),"jb");
        num.setText(jbNum+"");
    }
    @OnClick(R.id.record)
    protected void record(){
        Intent intent = new Intent(this,RecordActivity.class);
        startActivity(intent);
    }
    @OnClick(R.id.bind)
    protected void bind(){
        Intent intent = new Intent(this,BindActivity.class);
        startActivity(intent);
    }
    @OnClick(R.id.left)
    protected void left() {
        finish();
    }
    @OnClick(R.id.lay1)
    protected void lay1(){
        needNum.setText("8000");
        img1.setVisibility(View.VISIBLE);
        img2.setVisibility(View.GONE);
        img3.setVisibility(View.GONE);
        img4.setVisibility(View.GONE);
        img5.setVisibility(View.GONE);
        img6.setVisibility(View.GONE);
        lay1.setBackground(ContextCompat.getDrawable(this,R.drawable.shape_blue_4));
        lay2.setBackground(ContextCompat.getDrawable(this,R.drawable.shape_gray_4));
        lay3.setBackground(ContextCompat.getDrawable(this,R.drawable.shape_gray_4));
        lay4.setBackground(ContextCompat.getDrawable(this,R.drawable.shape_gray_4));
        lay5.setBackground(ContextCompat.getDrawable(this,R.drawable.shape_gray_4));
        lay6.setBackground(ContextCompat.getDrawable(this,R.drawable.shape_gray_4));
    }
    @OnClick(R.id.lay2)
    protected void lay2(){
        needNum.setText("10000");
        img1.setVisibility(View.GONE);
        img2.setVisibility(View.VISIBLE);
        img3.setVisibility(View.GONE);
        img4.setVisibility(View.GONE);
        img5.setVisibility(View.GONE);
        img6.setVisibility(View.GONE);
        lay1.setBackground(ContextCompat.getDrawable(this,R.drawable.shape_gray_4));
        lay2.setBackground(ContextCompat.getDrawable(this,R.drawable.shape_blue_4));
        lay3.setBackground(ContextCompat.getDrawable(this,R.drawable.shape_gray_4));
        lay4.setBackground(ContextCompat.getDrawable(this,R.drawable.shape_gray_4));
        lay5.setBackground(ContextCompat.getDrawable(this,R.drawable.shape_gray_4));
        lay6.setBackground(ContextCompat.getDrawable(this,R.drawable.shape_gray_4));
    }
    @OnClick(R.id.lay3)
    protected void lay3(){
        needNum.setText("20000");
        img1.setVisibility(View.GONE);
        img2.setVisibility(View.GONE);
        img3.setVisibility(View.VISIBLE);
        img4.setVisibility(View.GONE);
        img5.setVisibility(View.GONE);
        img6.setVisibility(View.GONE);
        lay1.setBackground(ContextCompat.getDrawable(this,R.drawable.shape_gray_4));
        lay2.setBackground(ContextCompat.getDrawable(this,R.drawable.shape_gray_4));
        lay3.setBackground(ContextCompat.getDrawable(this,R.drawable.shape_blue_4));
        lay4.setBackground(ContextCompat.getDrawable(this,R.drawable.shape_gray_4));
        lay5.setBackground(ContextCompat.getDrawable(this,R.drawable.shape_gray_4));
        lay6.setBackground(ContextCompat.getDrawable(this,R.drawable.shape_gray_4));
    }
    @OnClick(R.id.lay4)
    protected void lay4(){
        needNum.setText("50000");
        img1.setVisibility(View.GONE);
        img2.setVisibility(View.GONE);
        img3.setVisibility(View.GONE);
        img4.setVisibility(View.VISIBLE);
        img5.setVisibility(View.GONE);
        img6.setVisibility(View.GONE);
        lay1.setBackground(ContextCompat.getDrawable(this,R.drawable.shape_gray_4));
        lay2.setBackground(ContextCompat.getDrawable(this,R.drawable.shape_gray_4));
        lay3.setBackground(ContextCompat.getDrawable(this,R.drawable.shape_gray_4));
        lay4.setBackground(ContextCompat.getDrawable(this,R.drawable.shape_blue_4));
        lay5.setBackground(ContextCompat.getDrawable(this,R.drawable.shape_gray_4));
        lay6.setBackground(ContextCompat.getDrawable(this,R.drawable.shape_gray_4));
    }
    @OnClick(R.id.lay5)
    protected void lay5(){
        needNum.setText("100000");
        img1.setVisibility(View.GONE);
        img2.setVisibility(View.GONE);
        img3.setVisibility(View.GONE);
        img4.setVisibility(View.GONE);
        img5.setVisibility(View.VISIBLE);
        img6.setVisibility(View.GONE);
        lay1.setBackground(ContextCompat.getDrawable(this,R.drawable.shape_gray_4));
        lay2.setBackground(ContextCompat.getDrawable(this,R.drawable.shape_gray_4));
        lay3.setBackground(ContextCompat.getDrawable(this,R.drawable.shape_gray_4));
        lay4.setBackground(ContextCompat.getDrawable(this,R.drawable.shape_gray_4));
        lay5.setBackground(ContextCompat.getDrawable(this,R.drawable.shape_blue_4));
        lay6.setBackground(ContextCompat.getDrawable(this,R.drawable.shape_gray_4));
    }
    @OnClick(R.id.lay6)
    protected void lay6(){
        needNum.setText("300000");
        img1.setVisibility(View.GONE);
        img2.setVisibility(View.GONE);
        img3.setVisibility(View.GONE);
        img4.setVisibility(View.GONE);
        img5.setVisibility(View.GONE);
        img6.setVisibility(View.VISIBLE);
        lay1.setBackground(ContextCompat.getDrawable(this,R.drawable.shape_gray_4));
        lay2.setBackground(ContextCompat.getDrawable(this,R.drawable.shape_gray_4));
        lay3.setBackground(ContextCompat.getDrawable(this,R.drawable.shape_gray_4));
        lay4.setBackground(ContextCompat.getDrawable(this,R.drawable.shape_gray_4));
        lay5.setBackground(ContextCompat.getDrawable(this,R.drawable.shape_gray_4));
        lay6.setBackground(ContextCompat.getDrawable(this,R.drawable.shape_blue_4));
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