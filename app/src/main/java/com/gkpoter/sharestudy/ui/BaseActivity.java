package com.gkpoter.sharestudy.ui;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gkpoter.sharestudy.R;
import com.gkpoter.sharestudy.myview.DepthPageTransformer;
import com.gkpoter.sharestudy.ui.base_fragment.LeftFragment;
import com.gkpoter.sharestudy.ui.base_fragment.RightFragment;
import com.gkpoter.sharestudy.ui.base_fragment.UpActivity;

public class BaseActivity extends AppCompatActivity{

    private ViewPager viewPager;
    private TextView tv1,tv2;
    private ImageView iv;

    private Fragment[] fragments;
    private FragmentPagerAdapter adapter;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        init();
        initViewPager();
        onClick();
    }

    private void onClick() {
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0);
            }
        });
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BaseActivity.this, UpActivity.class);
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(
                        BaseActivity.this, iv, "base_middle").toBundle());
            }
        });
    }

    private void init() {
        tv1= (TextView) findViewById(R.id.base_left);
        tv2= (TextView) findViewById(R.id.base_right);
        iv= (ImageView) findViewById(R.id.base_middle);
        viewPager= (ViewPager) findViewById(R.id.base_viewpager);
    }

    private void initViewPager(){
        fragments=new Fragment[2];
        fragmentManager=getSupportFragmentManager();
        fragments[0]=new LeftFragment();
        fragments[1]=new RightFragment();
        adapter=new FragmentPagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int i) {
                return fragments[i];
            }

            @Override
            public int getCount() {
                return fragments.length;
            }
        };
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {}
            @Override
            public void onPageSelected(int i) {
                if(i==0){
                    tv1.setTextColor(Color.BLUE);
                    tv2.setTextColor(Color.BLACK);
                }else{
                    tv2.setTextColor(Color.BLUE);
                    tv1.setTextColor(Color.BLACK);
                }
            }
            @Override
            public void onPageScrollStateChanged(int i) {}
        });
        viewPager.setPageTransformer(true, new DepthPageTransformer());
    }
}
