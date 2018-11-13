package com.ma.app_android;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ma.app_android.base.BaseActivity;
import com.ma.app_android.util.L;

import java.util.ArrayList;
import java.util.List;

import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.PageNavigationView;
import me.majiajie.pagerbottomtabstrip.listener.SimpleTabItemSelectedListener;

public class MainActivity extends BaseActivity {

    private final int[] COLORS = {0xFF455A64, 0xFF00796B, 0xFF795548, 0xFF5B4947, 0xFFF57C00};
    private EditText mEdtIndex;
    private Button mBtnAddMessageNumber;
    private Button mBtnSubtraMessageNumber;
    private Button mBtnRemoveItem;
    private PageNavigationView mTab;
    private Button mBtnAddItem;
    private TextView mViewPager;
    private NavigationController mNavigationController;

    private final List<Integer> mMessageNumberList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initNavigation();

    }

    private void initView() {
        mBtnAddMessageNumber = findViewById(R.id.btn_addMessageNumber);
        mBtnSubtraMessageNumber = findViewById(R.id.btn_subtraMessageNumber);
        mBtnRemoveItem = findViewById(R.id.btn_remove_item);
        mBtnAddItem = findViewById(R.id.btn_add_item);
        mViewPager = findViewById(R.id.viewPager);
        mTab = findViewById(R.id.tab);
    }
    private void initNavigation() {
        mNavigationController = mTab.material()
                .addItem(R.drawable.ic_ondemand_video_black_24dp, "Movies & TV", COLORS[0])
                .addItem(R.drawable.ic_audiotrack_black_24dp, "Music", COLORS[1])
                .addItem(R.drawable.ic_book_black_24dp, "Books", COLORS[2])
                .addItem(R.drawable.ic_news_black_24dp, "Newsstand", COLORS[3])
                .enableAnimateLayoutChanges()
                .build();
        mNavigationController.addSimpleTabItemSelectedListener(new SimpleTabItemSelectedListener() {
            @Override
            public void onSelected(int index, int old) {
                // 选中时触发
                L.d(index+"");
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


    private void showToast(String text) {
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
    }

}
