package com.bbwy.base.app.activity;

import com.bbwy.base.app.R;
import com.gyf.immersionbar.ImmersionBar;
import com.king.base.BaseActivity;

import butterknife.OnClick;

public class BindActivity extends BaseActivity {
    @Override
    public void initUI() {
        setContentView(R.layout.activity_bind);
        setBarScreen();
    }

    @Override
    public void initData() {

    }
    @OnClick(R.id.left)
    protected void left() {
        finish();
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
