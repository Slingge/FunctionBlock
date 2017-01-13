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

public class TabFragment6 extends LazyFragment {

    private String content;
    private View view;
    private RecyclerView recyclerView;

    private List<ModelBean> beanList;
    private RecyclerAdapter adapter;

    private String des[] = {"寒霜3", "Eva-01", "Z1", "EVA-01", "Asuka", "COD10", "破 Asuka"
            , "su-35", "KO Kotobuki Tsumugi", "COD6", "su-30"};

    private int resId[] = {R.drawable.ic_item2, R.drawable.ic_item10, R.drawable.ic_item3,
            R.drawable.ic_item5, R.drawable.ic_item8, R.drawable.ic_item6, R.drawable.ic_item4, R.drawable.ic_item7, R.drawable.ic_item1, R.drawable.ic_item9,
            R.drawable.ic_item11,};


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.sidleslip_tabfragment, container, false);
        content = getArguments().getString("content");
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        return view;
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

    @Override
    public void loadData() {
        initData();
        ToastUtil.showToast(getActivity(), content);
    }
}
