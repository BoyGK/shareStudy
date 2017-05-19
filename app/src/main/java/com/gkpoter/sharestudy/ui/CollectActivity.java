package com.gkpoter.sharestudy.ui;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.gkpoter.sharestudy.R;
import com.gkpoter.sharestudy.myview.DepthPageTransformer;
import com.gkpoter.sharestudy.ui.collect_fragment.CollectFragment;
import com.gkpoter.sharestudy.ui.collect_fragment.DownloadFragment;
import com.gkpoter.sharestudy.ui.collect_fragment.UploadFragment;

public class CollectActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tab;
    private ImageView goback;

    private Fragment[] fragments;
    private FragmentPagerAdapter adapter;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect);
        init();
        initViewPager();
        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void init() {
        viewPager= (ViewPager) findViewById(R.id.collect_viewpager);
        tab= (TabLayout) findViewById(R.id.collect_tab);
        goback= (ImageView) findViewById(R.id.collect_goback);
    }

    private void initViewPager(){
        fragments=new Fragment[3];
        fragmentManager=getSupportFragmentManager();
        fragments[0]=new UploadFragment();
        fragments[1]=new CollectFragment();
        fragments[2]=new DownloadFragment();
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

            }
            @Override
            public void onPageScrollStateChanged(int i) {}
        });
        viewPager.setPageTransformer(true, new DepthPageTransformer());
        tab.setupWithViewPager(viewPager);
        tab.getTabAt(0).setText("上传");
        tab.getTabAt(1).setText("收藏");
        tab.getTabAt(2).setText("下载");
        viewPager.setCurrentItem(getIntent().getIntExtra("pager",0));
    }
}
