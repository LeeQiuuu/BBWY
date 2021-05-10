package com.bbwy.base.app.activity;

import android.Manifest;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.widget.Toast;


import com.bbwy.base.app.R;
import com.bbwy.base.app.bean.GoEvent;
import com.bbwy.base.app.bean.GoTab2Event;
import com.bbwy.base.app.fragment.Tab1Fragment;
import com.bbwy.base.app.fragment.Tab2Fragment;
import com.bbwy.base.app.fragment.Tab3Fragment;
import com.bbwy.base.app.fragment.Tab4Fragment;
import com.bbwy.base.app.util.RxBus;
import com.bbwy.base.app.view.BottomBar;
import com.gyf.immersionbar.ImmersionBar;
import com.king.base.BaseActivity;
import com.wildma.pictureselector.PermissionUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import butterknife.BindView;

public class MainActivity extends BaseActivity {
    @BindView(R.id.bottom_bar)
    BottomBar bottomBar;
    private Tab1Fragment homeFragment;
    private long firstTime;

    @Override
    public void initUI() {
        setContentView(R.layout.activity_main);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void initData() {
        String[] s = new String[3];
        s[0] = Manifest.permission.CAMERA;
        s[1] = Manifest.permission.READ_EXTERNAL_STORAGE;
        s[2] = Manifest.permission.WRITE_EXTERNAL_STORAGE;
        // PermissionManager.requestPermission(TContextWrap.of(this),s);
        PermissionUtils.checkPermissionFirst(this,1,s);
        initView();
        RxBus.getInstance().subscribe(GoEvent.class, o ->  {
            bottomBar.setIndex(2);
        });
        RxBus.getInstance().subscribe(GoTab2Event.class, o ->  {
            bottomBar.setIndex(1);
        });
        setBarScreen();
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void initView() {
        bottomBar.setContainer(R.id.fragment_vp)
                .setTitleBeforeAndAfterColor("#999999", "#8BC5FA")
                .addItem(Tab1Fragment.class,
                        "走路",
                        R.drawable.tab_1,
                        R.drawable.tab_1_c)
                .addItem(Tab2Fragment.class,
                        "运动",
                        R.drawable.tab_2,
                        R.drawable.tab_2_c)
                .addItem(Tab3Fragment.class,
                        "赚钱",
                        R.drawable.tab_3,
                        R.drawable.tab_3_c)
                .addItem(Tab4Fragment.class,
                        "收入",
                        R.drawable.tab_4,
                        R.drawable.tab_4_c)
                .build();
    }

    private void CopyAssets(String assetDir, String dir) {
        String[] files;
        try {
            files = this.getResources().getAssets().list(assetDir);
        } catch (IOException e1) {
            return;
        }
        File mWorkingPath = new File(dir);
        //if this directory does not exists, make one.
        if (!mWorkingPath.exists()) {
            if (!mWorkingPath.mkdirs()) {

            }
        }

        for (int i = 0; i < files.length; i++) {
            try {
                String fileName = files[i];
                //we make sure file name not contains '.' to be a folder.
                if (!fileName.contains(".")) {
                    if (0 == assetDir.length()) {
                        CopyAssets(fileName, dir + fileName + "/");
                    } else {
                        CopyAssets(assetDir + "/" + fileName, dir + fileName + "/");
                    }
                    continue;
                }
                File outFile = new File(mWorkingPath, fileName);
                if (outFile.exists())
                    outFile.delete();
                InputStream in = null;
                if (0 != assetDir.length())
                    in = getAssets().open(assetDir + "/" + fileName);
                else
                    in = getAssets().open(fileName);
                OutputStream out = new FileOutputStream(outFile);

                // Transfer bytes from in to out
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }

                in.close();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void onBackPressed() {
        long secondTime = System.currentTimeMillis();
        if (secondTime - firstTime > 2000) {
            Toast.makeText(MainActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            firstTime = secondTime;
        } else{
            finish();
        }
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