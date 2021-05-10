package com.bbwy.base.app.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bbwy.base.app.R;
import com.bbwy.base.app.bean.JbRecordBean;
import com.bumptech.glide.Glide;
import com.king.base.adapter.ViewHolderRecyclerAdapter;
import com.king.base.adapter.holder.ViewHolder;

import java.util.List;

/**
 * Created by LeeQiuuu on 2020/6/29.
 */
public class HomeAdapter extends ViewHolderRecyclerAdapter<Integer> {
    private Context context;
    private String dated = "";

    public HomeAdapter(Context context, List<Integer> listData, int lay) {
        super(context, listData, lay);
        this.context = context;
    }

    @Override
    public void bindViewDatas(ViewHolder holder, Integer bean, int position) {
        Glide.with(getContext()).load(bean).into((ImageView) holder.getView(R.id.img));
    }
}
