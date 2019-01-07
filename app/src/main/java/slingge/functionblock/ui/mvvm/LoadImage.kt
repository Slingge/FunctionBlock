package slingge.functionblock.ui.mvvm

import android.databinding.BindingAdapter
import android.text.TextUtils
import android.widget.ImageView

import com.nostra13.universalimageloader.core.ImageLoader

/**
 * 加载网络图片
 * Created by Slingge on 2018/8/1 0001.
 */
object LoadImage {


    @BindingAdapter("bind:imageUrl")
    @JvmStatic
    fun loadImage(imageView: ImageView, url: String?) {
        url?.let {//url不为空或者null，执行
            ImageLoader.getInstance().displayImage(it, imageView)
        }
    }

}
