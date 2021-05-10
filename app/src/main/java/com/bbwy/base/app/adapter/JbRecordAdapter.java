package com.bbwy.base.app.adapter;

import android.content.Context;
import android.view.View;

import com.bbwy.base.app.R;
import com.bbwy.base.app.bean.JbRecordBean;
import com.king.base.adapter.ViewHolderRecyclerAdapter;
import com.king.base.adapter.holder.ViewHolder;

import java.util.List;


public class JbRecordAdapter extends ViewHolderRecyclerAdapter<JbRecordBean> {
    private Context context;
    private String dated = "";

    public JbRecordAdapter(Context context, List<JbRecordBean> listData,int lay) {
        super(context, listData, lay);
        this.context = context;
    }

    @Override
    public void bindViewDatas(ViewHolder holder, JbRecordBean bean, int position) {
        String date = bean.time.split(" ")[0];
        String time = bean.time.split(" ")[1];
        if (dated.equals(date)) {
            holder.getView(R.id.date).setVisibility(View.GONE);
            holder.getView(R.id.view).setVisibility(View.INVISIBLE);
        } else {
            holder.getView(R.id.date).setVisibility(View.VISIBLE);
            holder.getView(R.id.view).setVisibility(View.VISIBLE);
            holder.setText(R.id.date, date);
        }
        holder.setText(R.id.content, bean.content);
        holder.setText(R.id.title, time);
        holder.setText(R.id.num, "+" + bean.num);
        dated = date;

    }
}
