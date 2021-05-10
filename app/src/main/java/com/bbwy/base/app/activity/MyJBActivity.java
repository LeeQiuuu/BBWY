package com.bbwy.base.app.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.bbwy.base.app.R;
import com.bbwy.base.app.adapter.JbRecordAdapter;
import com.bbwy.base.app.adapter.TxRecordAdapter;
import com.bbwy.base.app.bean.JbRecordBean;
import com.gyf.immersionbar.ImmersionBar;
import com.king.base.BaseActivity;
import com.king.base.util.SharedPreferencesUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by LeeQiuuu on 2020/6/23.
 */
public class MyJBActivity extends BaseActivity {
    @BindView(R.id.allNum)
    TextView num;
    @BindView(R.id.money)
    TextView money;
    @BindView(R.id.recycle)
    RecyclerView recyclerView;
    private JbRecordAdapter adapter;
    @Override
    public void initUI() {
        setContentView(R.layout.activity_my_jb);
        setBarScreen();
    }

    @Override
    public void initData() {
        long jbNum = SharedPreferencesUtils.getInt(getContext(), "jb");
        num.setText(jbNum + "");
        double m = (double) jbNum / 1000;
        money.setText(jbNum + "");

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        JbRecordBean bean = new JbRecordBean();
        bean.num = "10";
        bean.time = "2019-01-03 12:00";
        bean.content = "幸运金币";
        JbRecordBean bean4 = new JbRecordBean();
        bean4.num = "10";
        bean4.time = "2019-01-03 18:30";
        bean4.content = "乒乓球运动";
        JbRecordBean bean1 = new JbRecordBean();
        bean1.num = "0.6";
        bean1.time = "2020-04-12 10:00";
        bean1.content = "完成第一阶段";
        JbRecordBean bean2 = new JbRecordBean();
        bean2.num = "3.0";
        bean2.time = "2020-06-13 08:21";
        bean2.content = "幸运金币";
        List<JbRecordBean> list = new ArrayList<>();
        list.add(bean);
        list.add(bean4);
        list.add(bean1);
        list.add(bean2);

        adapter = new JbRecordAdapter(this, list, R.layout.item_jb_record);
        recyclerView.setAdapter(adapter);
    }

    @OnClick(R.id.left)
    protected void left() {
        finish();
    }

    @OnClick(R.id.record)
    protected void record() {
        Intent intent = new Intent(this, RecordActivity.class);
        startActivity(intent);
    }
    @OnClick(R.id.tx)
    protected void tx() {
        Intent intent = new Intent(this, TiXianActivity.class);
        startActivity(intent);
    }
    /**
     * 全屏显示
     */
    protected void setBarScreen() {
        ImmersionBar immersionBar = ImmersionBar.with(this)
                .fitsSystemWindows(true)
                .transparentStatusBar();
        immersionBar.statusBarDarkFont(true, 0.2f);
        immersionBar.init();
    }
}