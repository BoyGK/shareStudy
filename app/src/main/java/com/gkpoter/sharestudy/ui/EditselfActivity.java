package com.gkpoter.sharestudy.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.gkpoter.sharestudy.R;

public class EditselfActivity extends AppCompatActivity {

    private ImageView goback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editself);

        init();

        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void init() {
        goback= (ImageView) findViewById(R.id.edit_goback);
    }
}
