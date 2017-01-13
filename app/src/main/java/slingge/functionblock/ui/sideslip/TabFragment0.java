package slingge.functionblock.ui.sideslip;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import slingge.functionblock.R;
import slingge.functionblock.util.ToastUtil;

/**
 * Created by Slingge on 2017/1/12 0012.
 */

public class TabFragment0 extends LazyFragment {

    private String content;
    private View view;
    private RecyclerView recyclerView;

    private List<ModelBean> beanList;
    private RecyclerAdapter adapter;

    private String des[] = {"Asuka", "寒霜3", "EVA-01", "COD6", "Eva-01", "su-30", "KO Kotobuki Tsumugi", "su-35"
            , "Z1", "COD10", "破 Asuka"};

    private int resId[] = {R.drawable.ic_item5, R.drawable.ic_item6, R.drawable.ic_item11, R.drawable.ic_item10, R.drawable.ic_item4,
            R.drawable.ic_item2, R.drawable.ic_item7, R.drawable.ic_item8, R.drawable.ic_item9, R.drawable.ic_item3, R.drawable.ic_item1,
    };


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.sidleslip_tabfragment, container, false);
        content = getArguments().getString("content");
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        return view;
    }


    @Override
    public void loadData() {

        ToastUtil.showToast(getActivity(), content);
        initData();
    }


    private void initData() {

        beanList = new ArrayList<>();
        for (int i = 0; i < resId.length; i++) {
            ModelBean bean = new ModelBean();
            bean.setResId(resId[i]);
            bean.setTitle(des[i]);
            beanList.add(bean);
        }
        adapter = new RecyclerAdapter(getActivity(), beanList);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new RecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, Object object) {
//                startActivity(new Intent(getActivity(), TwoActivity.class));
            }
        });
    }


}
