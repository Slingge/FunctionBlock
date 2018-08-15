package slingge.functionblock.ui.mvvm;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;


import java.util.List;

import slingge.functionblock.R;
import slingge.functionblock.databinding.ItemMvvmBinding;

/**
 * Created by Slingge on 2018/8/15.
 */
public class Adapter2 extends RecyclerView.Adapter<Adapter2.ViewHolder> {

    private List<ItemModel> list;

    public Adapter2(List<ItemModel> list) {
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemMvvmBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_mvvm, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ItemModel model = list.get(position);
        holder.getBinding().setItemModel(model);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ItemMvvmBinding binding;

        public ViewHolder(ItemMvvmBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public ItemMvvmBinding getBinding() {
            return binding;
        }
    }


}
