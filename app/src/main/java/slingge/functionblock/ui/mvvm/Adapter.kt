package slingge.functionblock.ui.mvvm

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import slingge.functionblock.R
import slingge.functionblock.databinding.ItemMvvmBinding

/**
 * Created by Slingge on 2018/8.11.
 */
class Adapter(val context: Context, var list: ArrayList<ItemModel>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ItemMvvmBinding>(LayoutInflater.from(context), R.layout.item_mvvm, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val model = list[position]
        holder!!.getBinding().itemModel = model
    }


    class ViewHolder(val itemMvvmBinding: ItemMvvmBinding) : RecyclerView.ViewHolder(itemMvvmBinding.root) {
        fun getBinding(): ItemMvvmBinding {
            return itemMvvmBinding!!
        }

    }


}