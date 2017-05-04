package com.gkpoter.sharestudy.ui;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.gkpoter.sharestudy.R;
import com.gkpoter.sharestudy.ui.login_fragment.LoginFragment;
import com.gkpoter.sharestudy.ui.login_fragment.RegisterFragment;


/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity{

    private ViewPager viewPager;

    private Fragment[] fragments;
    private FragmentPagerAdapter adapter;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViewPager();
    }

    private void initViewPager(){
        viewPager= (ViewPager) findViewById(R.id.login_viewpager);
        fragments=new Fragment[2];
        fragmentManager=getSupportFragmentManager();
        fragments[0]=new LoginFragment();
        fragments[1]=new RegisterFragment();
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
                Toast.makeText(LoginActivity.this, i + "", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onPageScrollStateChanged(int i) {}
        });
    }

}

