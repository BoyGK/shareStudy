package com.gkpoter.sharestudy.ui.base_fragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.gkpoter.sharestudy.R;

import java.util.ArrayList;
import java.util.HashMap;

public class UpActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private GridView gridView;
    private TextView choose_f,up_back,up_upload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_up);
        init();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setContentInsetsAbsolute(0, 0);

        ArrayList<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();
        for(int i=0;i<1;i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("ItemImage", R.mipmap.choose_p);
            data.add(map);
        }

        SimpleAdapter adapter = new SimpleAdapter(this,data,R.layout.adapter_up_gridview,
                new String[] {"ItemImage"},
                new int[] {R.id.upItemImage});
        gridView.setAdapter(adapter);

        choose_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(UpActivity.this, "选择文件...", Toast.LENGTH_SHORT).show();
            }
        });
        up_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        up_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(UpActivity.this, "上传...", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void init() {
        toolbar = (Toolbar) findViewById(R.id.up_toolbar);
        gridView = (GridView) findViewById(R.id.up_gridview);
        choose_f= (TextView) findViewById(R.id.up_choose_f);
        up_back= (TextView) findViewById(R.id.up_back);
        up_upload= (TextView) findViewById(R.id.up_upload);
    }
}
