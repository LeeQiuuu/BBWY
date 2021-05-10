package com.bbwy.base.app.fragment;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bbwy.base.app.R;
import com.bbwy.base.app.activity.MyJBActivity;
import com.bbwy.base.app.activity.UserInfoActivity;
import com.bbwy.base.app.activity.WebActivity;
import com.bbwy.base.app.bean.GoEvent;
import com.bbwy.base.app.bean.JbEvent;
import com.bbwy.base.app.bean.PathEvent;
import com.bbwy.base.app.util.RxBus;
import com.bumptech.glide.Glide;
import com.king.base.BaseFragment;
import com.king.base.util.SharedPreferencesUtils;
import com.king.base.util.ToastUtils;
import com.wildma.pictureselector.PictureSelector;

import java.util.Objects;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.functions.Consumer;

public class Tab4Fragment extends BaseFragment {
    @BindView(R.id.jb)
    TextView jb;
    @BindView(R.id.money)
    TextView money;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.img)
    ImageView img;
    @Override
    public int inflaterRootView() {
        return R.layout.fragment_tab4;
    }

    @Override
    public void initUI() {

    }

    @Override
    public void initData() {
        RxBus.getInstance().subscribe(PathEvent.class, o ->  {
            loadPath();
        });
    }
    private void loadPath(){
        String path = SharedPreferencesUtils.getString(getContext(), "path");
        if (path!=null) Glide.with(getContext()).load(path).circleCrop().into(img);
    }
    private void loadName(){
        String names = SharedPreferencesUtils.getString(getContext(), "name");
        if (names!=null&&names.length()>0)name.setText(names);
    }
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden){
            long jbNum = SharedPreferencesUtils.getInt(getContext(),"jb");
            jb.setText(jbNum+"");
            double m = (double) jbNum/1000;
            money.setText(jbNum+"");
            loadPath();
            loadName();
        }
    }
    @OnClick(R.id.img)
    protected void img(){
        Intent intent = new Intent(getContext(), UserInfoActivity.class);
        startActivity(intent);
    }
    @OnClick(R.id.cjwt)
    protected void cjwt(){
        Intent intent = new Intent(getContext(), WebActivity.class);
        intent.putExtra("title","常见问题");
        intent.putExtra("url","http://baidu.com");
        startActivity(intent);
    }
    @OnClick(R.id.lxkf)
    protected void lxkf(){
        ToastUtils.showToast(getActivity().getApplicationContext(),"联系客服");
    }
    @OnClick({R.id.myJb,R.id.jbLay})
    protected void myJb(){
        Intent intent = new Intent(getContext(), MyJBActivity.class);
        startActivity(intent);
    }
    @Override
    public void onResume() {
        super.onResume();
        long jbNum = SharedPreferencesUtils.getInt(getContext(),"jb");
        jb.setText(jbNum+"");
        double m = (double) jbNum/1000;
        money.setText(m+"");
        loadPath();
        loadName();
    }
}