package slingge.functionblock.ui.recyclerView.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import slingge.functionblock.R;
import slingge.functionblock.ui.recyclerView.bean.ItemModel;


/**
 * Created by Slingge on 2017/1/10 0010.
 */

public class CollDataAdapter extends ListBaseAdapter<ItemModel> {

    private Context context;

    public CollDataAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_text, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        ItemModel item = list.get(position);
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.text.setText(item.title);
    }


    private class ViewHolder extends RecyclerView.ViewHolder {
        private TextView text;

        public ViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.info_text);
        }
    }


}
