package com.bbwy.base.app.activity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.ImageView;

import com.bbwy.base.app.R;
import com.bbwy.base.app.bean.PathEvent;
import com.bbwy.base.app.util.RxBus;
import com.bumptech.glide.Glide;
import com.gyf.immersionbar.ImmersionBar;
import com.king.base.BaseActivity;
import com.king.base.util.SharedPreferencesUtils;
import com.wildma.pictureselector.PictureBean;
import com.wildma.pictureselector.PictureSelector;

import butterknife.BindView;
import butterknife.OnClick;

public class UserInfoActivity extends BaseActivity {
    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.sex)
    EditText sex;
    @BindView(R.id.img)
    ImageView img;
    @Override
    public void initUI() {
        setContentView(R.layout.activity_info);
    }

    @Override
    public void initData() {
        String names = SharedPreferencesUtils.getString(this, "name");
        String sexs = SharedPreferencesUtils.getString(this, "sex");
        String path = SharedPreferencesUtils.getString(this, "path");
        if (name != null) name.setText(names);
        if (sex != null) sex.setText(sexs);
        if (path!=null) Glide.with(this).load(path).circleCrop().into(img);
        setBarScreen();
    }
    @OnClick(R.id.left)
    protected void left(){
        SharedPreferencesUtils.put(this,"name",name.getText().toString());
        SharedPreferencesUtils.put(this,"sex",sex.getText().toString());
        finish();
    }
    @OnClick(R.id.img)
    protected void img(){
        PictureSelector
                .create(this, PictureSelector.SELECT_REQUEST_CODE)
                .selectPicture(false);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /*结果回调*/
        if (requestCode == PictureSelector.SELECT_REQUEST_CODE) {
            if (data != null) {
                PictureBean pictureBean = data.getParcelableExtra(PictureSelector.PICTURE_RESULT);
                SharedPreferencesUtils.put(this, "path", pictureBean.getPath());
                RxBus.getInstance().send(new PathEvent());
                if (pictureBean.isCut()) {
                    Glide.with(this).load(pictureBean.getPath()).circleCrop().into(img);
                } else {
                    Glide.with(this).load(pictureBean.getUri()).circleCrop().into(img);
                }
            }
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            SharedPreferencesUtils.put(this,"name",name.getText().toString());
            SharedPreferencesUtils.put(this,"sex",sex.getText().toString());
        }
        return super.onKeyDown(keyCode, event);

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