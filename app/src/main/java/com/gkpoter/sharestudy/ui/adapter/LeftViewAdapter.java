package com.gkpoter.sharestudy.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.gkpoter.sharestudy.R;

import java.util.List;

/**
 * Created by "GKpoter" on 2017/5/17.
 */

public class LeftViewAdapter extends BaseAdapter {

    private List<String> data;
    private Context context;
    public LeftViewAdapter(List<String> data, Context context) {
        this.data=data;
        this.context=context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.adapter_left_listview,null);
            viewHolder = new ViewHolder();
            /**
             * 添加子view
             */
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }

        return view;
    }

    public class ViewHolder{

    }
}
