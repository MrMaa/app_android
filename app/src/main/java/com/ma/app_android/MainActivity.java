package com.ma.app_android;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;

import com.ma.app_android.base.BaseActivity;
import com.ma.app_android.ui.fragment.First;
import com.ma.app_android.ui.fragment.Forth;
import com.ma.app_android.ui.fragment.Second;
import com.ma.app_android.ui.fragment.Third;

import java.util.ArrayList;
import java.util.List;

import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.PageNavigationView;
import me.majiajie.pagerbottomtabstrip.listener.SimpleTabItemSelectedListener;

public class MainActivity extends BaseActivity {
    private Fragment mTab01;
    private Fragment mTab02;
    private Fragment mTab03;
    private Fragment mTab04;

    private final int[] COLORS = {0xFF455A64, 0xFF00796B, 0xFF795548, 0xFF5B4947, 0xFFF57C00};
    private PageNavigationView mTab;
    private NavigationController mNavigationController;

    private final List<Integer> mMessageNumberList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toobar);
        setSupportActionBar(toolbar);
        initView();

        initNavigation();

    }

    private void initView() {
        mTab = findViewById(R.id.tab);
    }
    private void initNavigation() {
        mNavigationController = mTab.material()
                .addItem(R.drawable.ic_ondemand_video_black_24dp, "First", COLORS[0])
                .addItem(R.drawable.ic_audiotrack_black_24dp, "Second", COLORS[1])
                .addItem(R.drawable.ic_book_black_24dp, "Third", COLORS[2])
                .addItem(R.drawable.ic_news_black_24dp, "Forth", COLORS[3])
                .enableAnimateLayoutChanges()
                .build();
        mNavigationController.addSimpleTabItemSelectedListener(new SimpleTabItemSelectedListener() {
            @Override
            public void onSelected(int index, int old) {
                // 选中时触发
                setSelect(index);
//                L.d(index+"");
            }
        });
//        MyViewPagerAdapter pagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager(), Math.max(5, mNavigationController.getItemCount()));
//        mViewPager.setAdapter(pagerAdapter);
//
//        mNavigationController.setupWithViewPager(mViewPager);

        // 初始化消息数字为0
        for (int i = 0; i < 4; i++) {
            mMessageNumberList.add(0);
        }
    }

    private void setSelect(int i)
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        hideFragment(transaction);

        switch (i)
        {
            case 0:
                if (mTab01 == null){
                    mTab01 = new First();
                    transaction.add(R.id.id_content, mTab01);
                } else{
                    transaction.show(mTab01);
                }
                break;
            case 1:
                if (mTab02 == null){
                    mTab02 = new Second();transaction.add(R.id.id_content, mTab02);
                } else{
                    transaction.show(mTab02);
                }
                break;
            case 2:
                if (mTab03 == null){
                    mTab03 = new Third();
                    transaction.add(R.id.id_content, mTab03);
                } else{
                    transaction.show(mTab03);
                }
                break;
            case 3:
                if (mTab04 == null){
                    mTab04 = new Forth();
                    transaction.add(R.id.id_content, mTab04);
                } else{
                    transaction.show(mTab04);
                }
                break;

            default:
                break;
        }
        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction) {
        if (mTab01 != null){
            transaction.hide(mTab01);
        }
        if (mTab02 != null){
            transaction.hide(mTab02);
        }
        if (mTab03 != null){
            transaction.hide(mTab03);
        }
        if (mTab04 != null){
            transaction.hide(mTab04);
        }
    }


    private void showToast(String text) {
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
    }

}
