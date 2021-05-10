package com.bbwy.base.app.fragment;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;
import android.widget.TextView;

import com.bbwy.base.app.R;
import com.bbwy.base.app.activity.ResultJlActivity;
import com.bbwy.base.app.activity.TiXianActivity;
import com.bbwy.base.app.bean.GoTab2Event;
import com.bbwy.base.app.util.RxBus;
import com.king.base.BaseFragment;
import com.king.base.util.SharedPreferencesUtils;
import com.king.base.util.TimeUtils;
import com.king.base.util.ToastUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;

public class Tab3Fragment extends BaseFragment {
    @BindView(R.id.num)
    TextView num;
    @BindView(R.id.money)
    TextView money;
    @BindView(R.id.note)
    TextView note;
    @BindView(R.id.count)
    TextView countT;
    @BindView(R.id.qd1)
    TextView qd1;
    @BindView(R.id.qd2)
    TextView qd2;
    @BindView(R.id.qd3)
    TextView qd3;
    @BindView(R.id.qd4)
    TextView qd4;
    @BindView(R.id.qd5)
    TextView qd5;
    @BindView(R.id.qd6)
    TextView qd6;
    @BindView(R.id.qd7)
    ImageView qd7;
    @BindView(R.id.num1)
    TextView num1;
    @BindView(R.id.num2)
    TextView num2;
    @BindView(R.id.bt1)
    TextView bt1;
    @BindView(R.id.bt2)
    TextView bt2;
    @BindView(R.id.bt3)
    TextView bt3;
    @BindView(R.id.bt4)
    TextView bt4;
    @BindView(R.id.bt5)
    TextView bt5;
    @BindView(R.id.bt6)
    TextView bt6;
    @BindView(R.id.bt7)
    TextView bt7;
    @BindView(R.id.bt8)
    TextView bt8;
    private String yestoday;
    private int videoCount;
    private String today;
    @BindView(R.id.q1)
    TextView q1;
    @BindView(R.id.q2)
    TextView q2;
    @BindView(R.id.q3)
    TextView q3;
    @BindView(R.id.q4)
    TextView q4;
    @BindView(R.id.q5)
    TextView q5;
    @BindView(R.id.q6)
    TextView q6;
    @BindView(R.id.q7)
    TextView q7;
    private boolean canSleep;
    private boolean canWuhou;
    private boolean canWanjian;
    private int tixianStatus;
    private int ydCount;
    private boolean can7;

    @Override
    public int inflaterRootView() {
        return R.layout.fragment_tab3;
    }

    @Override
    public void initUI() {
        today = TimeUtils.getCurrentDate("yyyy-MM-dd");
        videoCount = SharedPreferencesUtils.getInt(getContext(), today + "_video", 0);
        if (videoCount >= 9) {
            bt1.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.shape_finish));
            bt1.setText("立即领取");
            num1.setText("9");
        } else if (videoCount == -1) {
            bt1.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.shape_gray_15));
            bt1.setText("已完成");
            bt1.setEnabled(false);
            num1.setText("9");
        } else num1.setText(videoCount + "");
    }

    @Override
    public void initData() {
        yestoday = TimeUtils.beforeAfterDate(-1);
        int count = SharedPreferencesUtils.getInt(getContext(), yestoday + "_day", 0);
        int todayStatus = SharedPreferencesUtils.getInt(getContext(), today + "_check", 0);
        String statusStr = todayStatus == 1 ? "已领" : "今天";
        switch (count) {
            case 0:
                q1.setText(statusStr);
                if (todayStatus == 0){
                    qd1.setEnabled(true);
                }else{
                    qd1.setBackground(ContextCompat.getDrawable(getContext(),R.drawable.bg_jl_d));
                }
                break;
            case 1:
                qd1.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_jl_d));
                q1.setText("已领");
                q2.setText(statusStr);
                q3.setText("明天");
                qd2.setEnabled(true);
                countT.setText("1");
                note.setText("38");
                if (todayStatus == 0){
                    qd2.setEnabled(true);
                }else{
                    qd2.setBackground(ContextCompat.getDrawable(getContext(),R.drawable.bg_jl_d));
                }
                break;
            case 2:
                qd1.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_jl_d));
                qd2.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_jl_d));
                q1.setText("已领");
                q2.setText("已领");
                q3.setText(statusStr);
                q4.setText("明天");
                qd3.setEnabled(true);
                countT.setText("2");
                note.setText("48");
                if (todayStatus == 0){
                    q3.setEnabled(true);
                }else{
                    q3.setBackground(ContextCompat.getDrawable(getContext(),R.drawable.bg_jl_d));
                }
                break;
            case 3:
                qd1.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_jl_d));
                qd2.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_jl_d));
                qd3.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_jl_d));
                q1.setText("已领");
                q2.setText("已领");
                q3.setText("已领");
                q4.setText(statusStr);
                q5.setText("明天");
                qd4.setEnabled(true);
                countT.setText("3");
                note.setText("58");
                if (todayStatus == 0){
                    qd4.setEnabled(true);
                }else{
                    qd4.setBackground(ContextCompat.getDrawable(getContext(),R.drawable.bg_jl_d));
                }
                break;
            case 4:
                qd1.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_jl_d));
                qd2.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_jl_d));
                qd3.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_jl_d));
                qd4.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_jl_d));
                q1.setText("已领");
                q2.setText("已领");
                q3.setText("已领");
                q4.setText("已领");
                q5.setText(statusStr);
                q6.setText("明天");
                qd5.setEnabled(true);
                countT.setText("4");
                note.setText("68");
                if (todayStatus == 0){
                    q5.setEnabled(true);
                }else{
                    q5.setBackground(ContextCompat.getDrawable(getContext(),R.drawable.bg_jl_d));
                }
                break;
            case 5:
                qd1.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_jl_d));
                qd2.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_jl_d));
                qd3.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_jl_d));
                qd4.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_jl_d));
                qd5.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_jl_d));
                q1.setText("已领");
                q2.setText("已领");
                q3.setText("已领");
                q4.setText("已领");
                q5.setText("已领");
                q6.setText(statusStr);
                q7.setText("明天");
                qd6.setEnabled(true);
                countT.setText("5");
                note.setText("108");
                if (todayStatus == 0){
                    q6.setEnabled(true);
                }else{
                    q6.setBackground(ContextCompat.getDrawable(getContext(),R.drawable.bg_jl_d));
                }
                break;
            case 6:
                qd1.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_jl_d));
                qd2.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_jl_d));
                qd3.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_jl_d));
                qd4.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_jl_d));
                qd5.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_jl_d));
                qd6.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_jl_d));
                q1.setText("已领");
                q2.setText("已领");
                q3.setText("已领");
                q4.setText("已领");
                q5.setText("已领");
                q6.setText("已领");
                qd7.setEnabled(true);
                can7 = true;
                countT.setText("6");
                note.setText("18");
                if (todayStatus == 0){
                    q6.setEnabled(true);
                }else{
                    q6.setBackground(ContextCompat.getDrawable(getContext(),R.drawable.bg_jl_d));
                }
                break;
            default:
                q1.setText(statusStr);
                qd1.setEnabled(true);
                countT.setText("0");
                note.setText("28");
                if (todayStatus == 0){
                    qd1.setEnabled(true);
                }else{
                    qd1.setBackground(ContextCompat.getDrawable(getContext(),R.drawable.bg_jl_d));
                }
        }
    }

    @OnClick(R.id.qd1)
    protected void qd1() {
        qd1.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_jl_d));
        SharedPreferencesUtils.put(getContext(), today + "_day", 1);
        SharedPreferencesUtils.put(getContext(), today + "_check", 1);
        countT.setText("1");
        q1.setText("已领");
        Intent intent = new Intent(getContext(), ResultJlActivity.class);
        intent.putExtra("tag", 0);
        intent.putExtra("num", 18);
        startActivity(intent);
    }

    @OnClick(R.id.qd2)
    protected void qd2() {
        qd2.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_jl_d));
        SharedPreferencesUtils.put(getContext(), today + "_day", 2);
        SharedPreferencesUtils.put(getContext(), today + "_check", 1);
        countT.setText("2");
        q2.setText("已领");
        Intent intent = new Intent(getContext(), ResultJlActivity.class);
        intent.putExtra("tag", 0);
        intent.putExtra("num", 28 * 2);
        startActivity(intent);
    }

    @OnClick(R.id.qd3)
    protected void qd3() {
        q3.setText("已领");
        qd3.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_jl_d));
        SharedPreferencesUtils.put(getContext(), today + "_day", 3);
        SharedPreferencesUtils.put(getContext(), today + "_check", 1);
        countT.setText("3");
        Intent intent = new Intent(getContext(), ResultJlActivity.class);
        intent.putExtra("tag", 0);
        intent.putExtra("num", 38);
        startActivity(intent);
    }

    @OnClick(R.id.qd4)
    protected void qd4() {
        q4.setText("已领");
        qd4.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_jl_d));
        SharedPreferencesUtils.put(getContext(), today + "_day", 4);
        SharedPreferencesUtils.put(getContext(), today + "_check", 1);
        countT.setText("4");
        Intent intent = new Intent(getContext(), ResultJlActivity.class);
        intent.putExtra("tag", 0);
        intent.putExtra("num", 48);
        startActivity(intent);
    }

    @OnClick(R.id.qd5)
    protected void qd5() {
        q5.setText("已领");
        qd5.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_jl_d));
        SharedPreferencesUtils.put(getContext(), today + "_day", 5);
        SharedPreferencesUtils.put(getContext(), today + "_check", 1);
        countT.setText("5");
        Intent intent = new Intent(getContext(), ResultJlActivity.class);
        intent.putExtra("tag", 0);
        intent.putExtra("num", 58);
        startActivity(intent);
    }

    @OnClick(R.id.qd6)
    protected void qd6() {
        q6.setText("已领");
        qd6.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_jl_d));
        SharedPreferencesUtils.put(getContext(), yestoday + "_day", 6);
        SharedPreferencesUtils.put(getContext(), today + "_check", 1);
        countT.setText("6");
        Intent intent = new Intent(getContext(), ResultJlActivity.class);
        intent.putExtra("tag", 0);
        intent.putExtra("num", 68);
        startActivity(intent);
    }

    @OnClick(R.id.qd7)
    protected void qd7() {
        if (!can7)return;
        q7.setText("已领");
        qd7.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.bg_bx));
        SharedPreferencesUtils.put(getContext(), yestoday + "_day", 7);
        SharedPreferencesUtils.put(getContext(), today + "_check", 1);
        countT.setText("7");
        Intent intent = new Intent(getContext(), ResultJlActivity.class);
        intent.putExtra("tag", 0);
        intent.putExtra("num", 108);
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
        long jbNum = SharedPreferencesUtils.getInt(getContext(), "jb");
        num.setText(jbNum + "");
        double m = (double) jbNum / 1000;
        money.setText("≈" + m + "元");
        setData();
    }

    @OnClick(R.id.bt1)
    protected void bt1() {
        if (videoCount < 9 && videoCount != -1) {
            ToastUtils.showToast(getActivity().getApplicationContext(), "查看了视频");
            videoCount++;
            num1.setText(videoCount + "");
            SharedPreferencesUtils.put(getContext(), today + "_video", videoCount);
            if (videoCount >= 9) {
                bt1.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.shape_finish));
                bt1.setText("立即领取");
            }
        } else if (videoCount != -1) {
            bt1.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.shape_gray_15));
            bt1.setText("已完成");
            bt1.setEnabled(false);
            SharedPreferencesUtils.put(getContext(), today + "_video", -1);
            Intent intent = new Intent(getContext(), ResultJlActivity.class);
            intent.putExtra("tag", 1);
            intent.putExtra("num", 70);
            startActivity(intent);
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            setData();
        }
    }
    @OnClick(R.id.bt2)
    protected void bt2() {
        if (!canSleep)return;
        bt2.setEnabled(false);
        bt2.setText("已完成");
        bt2.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.shape_gray_15));
        SharedPreferencesUtils.put(getContext(),today+"_sleep",1);
        Intent intent = new Intent(getContext(), ResultJlActivity.class);
        intent.putExtra("tag", 1);
        intent.putExtra("num", 66);
        startActivity(intent);
    }
    @OnClick(R.id.bt3)
    protected void bt3() {
        if (ydCount<5){
            RxBus.getInstance().send(new GoTab2Event());
        }else {
            bt3.setEnabled(false);
            bt3.setText("已完成");
            bt3.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.shape_gray_15));
            SharedPreferencesUtils.put(getContext(), today + "_yd", 1);
            Intent intent = new Intent(getContext(), ResultJlActivity.class);
            intent.putExtra("tag", 1);
            intent.putExtra("num", 50);
            startActivity(intent);
        }
    }
    @OnClick(R.id.bt4)
    protected void bt4() {
        if (tixianStatus==2)return;
        if (tixianStatus==1){
            bt4.setEnabled(false);
            bt4.setText("已完成");
            bt4.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.shape_gray_15));
            SharedPreferencesUtils.put(getContext(),today+"_tixian",2);
            Intent intent = new Intent(getContext(), ResultJlActivity.class);
            intent.putExtra("tag", 1);
            intent.putExtra("num", 100);
            startActivity(intent);
        }else {
            Intent intent = new Intent(getContext(), TiXianActivity.class);
            startActivity(intent);
            SharedPreferencesUtils.put(getContext(),today+"_tixian",1);
            bt4.setText("立即领取");
            bt4.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.shape_finish));
        }
    }
    @OnClick(R.id.bt5)
    protected void bt5() {
        if (!canWuhou)return;
        bt5.setEnabled(false);
        bt5.setText("已完成");
        bt5.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.shape_gray_15));
        SharedPreferencesUtils.put(getContext(),today+"_wuhou",1);
        Intent intent = new Intent(getContext(), ResultJlActivity.class);
        intent.putExtra("tag", 1);
        intent.putExtra("num", 60);
        startActivity(intent);
    }
    @OnClick(R.id.bt6)
    protected void bt6() {
        if (!canWanjian)return;
        bt6.setEnabled(false);
        bt6.setText("已完成");
        bt6.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.shape_gray_15));
        SharedPreferencesUtils.put(getContext(),today+"_wanjian",1);
        Intent intent = new Intent(getContext(), ResultJlActivity.class);
        intent.putExtra("tag", 1);
        intent.putExtra("num", 60);
        startActivity(intent);
    }
    @OnClick(R.id.bt7)
    protected void bt7() {
        bt7.setEnabled(false);
        bt7.setText("已完成");
        bt7.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.shape_gray_15));
        SharedPreferencesUtils.put(getContext(),today+"_share",1);
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "这是步步为盈分享的内容.");
        sendIntent.setType("text/plain");
        startActivity(Intent.createChooser(sendIntent,"这是步步为盈分享的内容"));
    }
    @OnClick(R.id.bt8)
    protected void bt8() {
        bt8.setText("已完成");
        bt8.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.shape_gray_15));
        SharedPreferencesUtils.put(getContext(),today+"_rixing",1);
        Intent intent = new Intent(getContext(), ResultJlActivity.class);
        intent.putExtra("tag", 1);
        intent.putExtra("num", 100);
        startActivity(intent);
    }
    private void setData() {
        //睡前打卡
        if (SharedPreferencesUtils.getInt(getContext(),today+"_sleep",0)==1){
            bt2.setEnabled(false);
            bt2.setText("已完成");
            bt2.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.shape_gray_15));
        }else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            String now = TimeUtils.getCurrentDate("HH:mm:ss");
            try {
                Date date1 = dateFormat.parse(now);//开始时间
                Date date2 = dateFormat.parse("21:00:00");//结束时间
                if (!date1.before(date2)) {
                    bt2.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.shape_finish));
                    bt2.setText("立即领取");
                    canSleep = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //去提现
        tixianStatus = SharedPreferencesUtils.getInt(getContext(),today+"_tixian",0);
        if (tixianStatus==1){
            bt4.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.shape_finish));
            bt4.setText("立即领取");
        }else if (tixianStatus==2){
            bt4.setEnabled(false);
            bt4.setText("已完成");
            bt4.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.shape_gray_15));
        }
        //午后提升
        if (SharedPreferencesUtils.getInt(getContext(),today+"_wuhou",0)==1){
            bt5.setEnabled(false);
            bt5.setText("已完成");
            bt5.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.shape_gray_15));
        }else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            String now = TimeUtils.getCurrentDate("HH:mm:ss");
            try {
                Date date1 = dateFormat.parse(now);//开始时间
                Date date2 = dateFormat.parse("14:00:00");//结束时间1
                Date date3 = dateFormat.parse("16:00:00");//结束时间2
                if (date1.after(date2) && date1.before(date3)) {
                    bt5.setText("立即领取");
                    bt5.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.shape_finish));
                    canWuhou = true;
                } else if (date1.after(date3)) {
                    bt5.setText("已完成");
                    bt5.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.shape_gray_15));
                    bt5.setEnabled(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //晚间娱乐
        if (SharedPreferencesUtils.getInt(getContext(),today+"_wanjian",0)==1){
            bt6.setEnabled(false);
            bt6.setText("已完成");
            bt6.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.shape_gray_15));
        }else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            String now = TimeUtils.getCurrentDate("HH:mm:ss");
            try {
                Date date1 = dateFormat.parse(now);//开始时间
                Date date2 = dateFormat.parse("20:00:00");//结束时间1
                Date date3 = dateFormat.parse("24:00:00");//结束时间2
                if (date1.after(date2) && date1.before(date3)) {
                    bt6.setText("立即领取");
                    bt6.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.shape_finish));
                    canWanjian = true;
                } else if (date1.after(date3)) {
                    bt6.setText("已完成");
                    bt6.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.shape_gray_15));
                    bt6.setEnabled(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //分享微信
        if (SharedPreferencesUtils.getInt(getContext(),today+"_share",0)==1){
            bt7.setEnabled(false);
            bt7.setText("已完成");
            bt7.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.shape_gray_15));
        }
        //日行万里
        if (SharedPreferencesUtils.getInt(getContext(),today+"_rixing",0)==1){
            bt8.setEnabled(false);
            bt8.setText("已完成");
            bt8.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.shape_gray_15));
        }else if (SharedPreferencesUtils.getInt(getContext(),today+"_walk_num",0)>=10000){
            bt8.setText("立即领取");
            bt8.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.shape_finish));
            bt8.setEnabled(true);
        }
        //每日运动
        ydCount = 0;
        long ppT = SharedPreferencesUtils.getSharedPreferences(getContext()).getLong(today+"ppq", 0);
        long jsT = SharedPreferencesUtils.getSharedPreferences(getContext()).getLong(today+"jsc", 0);
        long pbT = SharedPreferencesUtils.getSharedPreferences(getContext()).getLong(today+"pb", 0);
        long lqT = SharedPreferencesUtils.getSharedPreferences(getContext()).getLong(today+"dlq", 0);
        long zqT = SharedPreferencesUtils.getSharedPreferences(getContext()).getLong(today+"tzq", 0);
        if (ppT==-1)ydCount++;
        if (jsT==-1)ydCount++;
        if (pbT==-1)ydCount++;
        if (lqT==-1)ydCount++;
        if (zqT==-1)ydCount++;
        num2.setText(ydCount+"");
        if (SharedPreferencesUtils.getInt(getContext(),today+"_yd",0)==1){
            bt3.setEnabled(false);
            bt3.setText("已完成");
            bt3.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.shape_gray_15));
        }else if (ydCount>=5){
            bt3.setText("立即领取");
            bt3.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.shape_finish));
        }

    }
}