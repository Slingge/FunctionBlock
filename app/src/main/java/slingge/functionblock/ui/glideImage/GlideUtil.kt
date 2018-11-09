package slingge.functionblock.ui.glideImage

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import slingge.functionblock.R


/**
 * Created by Slingge on 2018/10/23
 */
object GlideUtil {

    val options = RequestOptions()
            .placeholder(R.mipmap.ic_launcher)
            .error(R.mipmap.ic_launcher)
            .skipMemoryCache(false)
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)

    //通用
    fun glideLoad(context: Context, url: String, imageView: ImageView) {
        Glide.with(context)
                .load(url)
                .apply(options)
                .into(imageView)
    }

    val optionsHeader = RequestOptions()
            .placeholder(R.drawable.ic_header)
            .error(R.drawable.ic_header)
            .skipMemoryCache(false)
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
    //头像
    fun glideHeaderLoad(context: Context, url: String, imageView: ImageView) {
        Glide.with(context)
                .load(url)
                .apply(optionsHeader)
                .into(imageView)
    }


    val Rounde = 6
    val roundedCorners = RoundedCorners(Rounde)
    //圆角
    fun glideRoundLoad(context: Context, url: String, imageView: ImageView) {
        Glide.with(context)
                .load(url)
                .apply(RequestOptions.bitmapTransform(roundedCorners).placeholder(R.mipmap.ic_launcher)
                        .error(R.mipmap.ic_launcher)
                        .skipMemoryCache(false)
                        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC))
                .into(imageView)
    }


}