package com.bbwy.base.app.adapter;

import android.content.Context;
import android.view.View;

import com.bbwy.base.app.R;
import com.bbwy.base.app.bean.JbRecordBean;
import com.king.base.adapter.ViewHolderRecyclerAdapter;
import com.king.base.adapter.holder.ViewHolder;

import java.util.List;

/**
 * Created by LeeQiuuu on 2020/6/28.
 */
public class TxRecordAdapter extends ViewHolderRecyclerAdapter<JbRecordBean> {
    private Context context;
    private String dated = "";

    public TxRecordAdapter(Context context, List<JbRecordBean> listData,int id) {
        super(context, listData, id);
        this.context = context;
    }

    @Override
    public void bindViewDatas(ViewHolder holder, JbRecordBean bean, int position) {
        holder.setText(R.id.time,bean.time);
        holder.setText(R.id.num,"+"+bean.num);
    }
}
