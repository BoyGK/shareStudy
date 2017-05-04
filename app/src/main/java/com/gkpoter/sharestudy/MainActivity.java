package com.gkpoter.sharestudy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gkpoter.sharestudy.ui.BaseActivity;
import com.gkpoter.sharestudy.ui.LoginActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        startActivity(new Intent(this, BaseActivity.class));
        finish();
    }
}
