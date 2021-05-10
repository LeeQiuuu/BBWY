package com.bbwy.base.app.activity;

import android.view.animation.Animation;

import com.bbwy.base.app.R;
import com.gyf.immersionbar.ImmersionBar;
import com.king.base.SplashActivity;


/**
 * @author Jenly <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */

public class WelcomeActivity extends SplashActivity {

    @Override
    public int getContentViewId() {
        return R.layout.activity_welcome;
    }

    @Override
    public void initData() {
        super.initData();
        setBarScreen();
    }

    @Override
    public Animation.AnimationListener getAnimationListener() {
        return new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivityFinish(MainActivity.class);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        };
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
