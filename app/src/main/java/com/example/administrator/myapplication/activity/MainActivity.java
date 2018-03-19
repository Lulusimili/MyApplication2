package com.example.administrator.myapplication.activity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.fragment.FirstFragment;
import com.example.administrator.myapplication.fragment.FourthFragment;
import com.example.administrator.myapplication.fragment.SecondFragment;
import com.example.administrator.myapplication.fragment.ThirdFragment;
import com.example.administrator.myapplication.ui.BottomBar;
import com.example.administrator.myapplication.ui.PopupMenu;

import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {
    private List<Fragment> fragments;
    private Fragment mFragment=null;
    private BottomBar bottomBar;
    private ImageView mCenterImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mFragment=fragments.get(0);
        showFragment(mFragment);
        setOnClickFrameLayoutListener();
    }

    /**
     * 初始化界面
     */
    private void initView(){
        fragments=new ArrayList<>();
        fragments.add(new FirstFragment());
        fragments.add(new SecondFragment());
        fragments.add(new ThirdFragment());
        fragments.add(new FourthFragment());
        bottomBar=(BottomBar)findViewById(R.id.bottomBar);

        mCenterImage = (ImageView)findViewById (R.id.center_img);
    }

    /**
     * 设置底部选择按钮监听
     */
    private void setOnClickFrameLayoutListener(){
        bottomBar.setOnBottomBarOnclick(new BottomBar.OnBottomBarClick() {
            @Override
            public void onFirstClick() {
                mFragment=fragments.get(0);
                showFragment(mFragment);
            }

            @Override
            public void onSecondClick() {
                mFragment=fragments.get(1);
                showFragment(mFragment);

            }

            @Override
            public void onThirdClick() {
                mFragment=fragments.get(2);
                showFragment(mFragment);
            }

            @Override
            public void onFourthClick() {
                mFragment=fragments.get(3);
                showFragment(mFragment);
            }

            @Override
            public void onCenterClick() {
                PopupMenu.getInstance().show(getApplicationContext(), mCenterImage);
            }
        });

    }

    /**
     * 选择显示的fragment
     * @param fragment
     */
    private void showFragment(Fragment fragment) {
        if(fragment!=null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container,fragment)
                    .commit();
        }
    }
}
