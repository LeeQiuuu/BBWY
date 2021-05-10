package com.bbwy.base.app.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bbwy.base.app.R;
import com.bbwy.base.app.adapter.TxRecordAdapter;
import com.bbwy.base.app.bean.JbRecordBean;
import com.gyf.immersionbar.ImmersionBar;
import com.king.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by LeeQiuuu on 2020/6/23.
 */
public class RecordActivity extends BaseActivity {
    @BindView(R.id.recycle)
    RecyclerView recyclerView;
    private TxRecordAdapter adapter;

    @Override
    public void initUI() {
        setContentView(R.layout.activity_record);
    }

    @Override
    public void initData() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        JbRecordBean bean = new JbRecordBean();
        bean.num = "10";
        bean.time = "2019-01-03 12:00";
        JbRecordBean bean1 = new JbRecordBean();
        bean1.num = "0.6";
        bean1.time = "2020-04-12 10:00";
        JbRecordBean bean2 = new JbRecordBean();
        bean2.num = "3.0";
        bean2.time = "2020-06-13 08:21";
        List<JbRecordBean> list = new ArrayList<>();
        list.add(bean);
        list.add(bean1);
        list.add(bean2);
        adapter = new TxRecordAdapter(this, list, R.layout.item_tx_record);
        recyclerView.setAdapter(adapter);
        setBarScreen();
    }

    @OnClick(R.id.left)
    protected void left() {
        finish();
    }

    @OnClick(R.id.record)
    protected void record() {
        Intent intent = new Intent(getContext(), WebActivity.class);
        intent.putExtra("title", "常见问题");
        intent.putExtra("url", "http://baidu.com");
        startActivity(intent);
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