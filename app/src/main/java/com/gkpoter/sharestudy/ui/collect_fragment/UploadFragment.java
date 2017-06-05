package com.gkpoter.sharestudy.ui.collect_fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.gkpoter.sharestudy.R;
import com.gkpoter.sharestudy.ui.DetailedActivity;
import com.gkpoter.sharestudy.ui.adapter.CollectAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by "GKpoter" on 2017/5/19.
 */

public class UploadFragment extends Fragment {

    private ListView listView;
    private CollectAdapter adapter;
    private List<String> list;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_upload, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        init();

        list=new ArrayList<>();
        adapter=new CollectAdapter(getData(),getActivity());
        listView.setAdapter(adapter);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getActivity(), DetailedActivity.class));
            }
        });

    }

    private void init() {
        listView= (ListView) getActivity().findViewById(R.id.upload_listView);
        swipeRefreshLayout= (SwipeRefreshLayout) getActivity().findViewById(R.id.upload_refresh);
        swipeRefreshLayout.setColorSchemeColors(Color.BLUE);
    }

    private List<String> getData(){
        for(int i=0;i<10;i++){
            list.add(i+"");
        }
        return list;
    }
}
