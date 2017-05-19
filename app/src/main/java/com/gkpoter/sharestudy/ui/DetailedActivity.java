package com.gkpoter.sharestudy.ui;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.gkpoter.sharestudy.R;
import com.gkpoter.sharestudy.myview.ScrollViewListView;
import com.gkpoter.sharestudy.ui.adapter.DetailedPictureAdapter;

import java.util.ArrayList;
import java.util.List;

public class DetailedActivity extends AppCompatActivity {

    private ScrollViewListView listView;
    private DetailedPictureAdapter adapter;
    private List<String> list;

    private ImageView goBack;
    private ImageView download;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        init();

        list=new ArrayList<>();
        adapter=new DetailedPictureAdapter(getData(),this);
        listView.setAdapter(adapter);

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "loading...", Snackbar.LENGTH_SHORT)
                        .show();
            }
        });
    }

    private void init() {
        listView= (ScrollViewListView) findViewById(R.id.detailed_listView);
        goBack= (ImageView) findViewById(R.id.detailed_goback);
        download= (ImageView) findViewById(R.id.detailed_download);
    }

    private List<String> getData(){
        for(int i=0;i<4;i++){
            list.add(i+"");
        }
        return list;
    }
}
