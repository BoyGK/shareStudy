package com.gkpoter.sharestudy.ui.base_fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.gkpoter.sharestudy.R;
import com.gkpoter.sharestudy.ui.AboutActivity;
import com.gkpoter.sharestudy.ui.CollectActivity;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by "GKpoter" on 2017/5/4.
 */

public class RightFragment extends Fragment {

    private GridView gridView;
    private ArrayList<HashMap<String, Object>> data;
    private ImageView editSelf, setting;
    private ImageButton send;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_right, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        init();

        data = new ArrayList<HashMap<String, Object>>();
        initMenuView();

        SimpleAdapter adapter = new SimpleAdapter(getActivity(), data, R.layout.adapter_right_gridview,
                new String[]{"ItemImage", "ItemText"},
                new int[]{R.id.adapter_right_image, R.id.adapter_right_text});
        gridView.setAdapter(adapter);

        onClick();

    }

    private void onClick() {
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "设置（登录，退出，主题）", Toast.LENGTH_SHORT).show();
            }
        });
        editSelf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "个人信息编辑", Toast.LENGTH_SHORT).show();
            }
        });
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "已提交至论坛，点击论坛可查看", Snackbar.LENGTH_LONG)
                        .setAction("论坛", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(getActivity(), "3", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getActivity(), position + "", Toast.LENGTH_SHORT).show();
                switch (position) {
                    case 0:
                        startToCollect(0);
                        break;
                    case 1:
                        startToCollect(1);
                        break;
                    case 2:
                        startToCollect(2);
                        break;
                    case 3:
                        Snackbar.make(view, "论坛建设中。。。", Snackbar.LENGTH_SHORT)
                                .show();
                        break;
                    case 4:
                        Snackbar.make(view, "留言板建设中。。。", Snackbar.LENGTH_SHORT)
                                .show();
                        break;
                    case 5:
                        startActivity(new Intent(getActivity(), AboutActivity.class));
                        break;
                }
            }
        });
    }

    private void startToCollect(int id) {
        Intent intent=new Intent(getActivity(), CollectActivity.class);
        intent.putExtra("pager",id);
        startActivity(intent);
    }

    /**
     * 菜单初始化
     */
    private void initMenuView() {
        HashMap<String, Object> map;
        map = new HashMap<String, Object>();
        map.put("ItemImage", R.mipmap.arrow_up_outline);
        map.put("ItemText", "我的上传");
        data.add(map);

        map = new HashMap<String, Object>();
        map.put("ItemImage", R.mipmap.heart_outline);
        map.put("ItemText", "我的收藏");
        data.add(map);

        map = new HashMap<String, Object>();
        map.put("ItemImage", R.mipmap.arrow_down_outline);
        map.put("ItemText", "我的下载");
        data.add(map);

        map = new HashMap<String, Object>();
        map.put("ItemImage", R.mipmap.phone_outline);
        map.put("ItemText", "论坛");
        data.add(map);

        map = new HashMap<String, Object>();
        map.put("ItemImage", R.mipmap.edit);
        map.put("ItemText", "留言板");
        data.add(map);

        map = new HashMap<String, Object>();
        map.put("ItemImage", R.mipmap.user_outline);
        map.put("ItemText", "关于");
        data.add(map);
    }

    private void init() {
        gridView = (GridView) getActivity().findViewById(R.id.right_icon);
        editSelf = (ImageView) getActivity().findViewById(R.id.right_editSelf);
        setting = (ImageView) getActivity().findViewById(R.id.right_setting);
        send = (ImageButton) getActivity().findViewById(R.id.right_send);
    }
}
