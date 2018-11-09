package slingge.functionblock.ui.glideImage

import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory
import com.bumptech.glide.load.engine.cache.LruResourceCache
import com.bumptech.glide.module.AppGlideModule

import android.content.Context

import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.Registry
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.cache.ExternalCacheDiskCacheFactory
import com.bumptech.glide.request.RequestOptions


/**
 * Created by Slingge on 2018/10/23
 */
@GlideModule
class GlobalGlideConfig : AppGlideModule() {

    internal var diskSize = 1024 * 1024 * 100
    internal var memorySize = Runtime.getRuntime().maxMemory().toInt()

    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        super.registerComponents(context, glide, registry)
    }

    override fun isManifestParsingEnabled(): Boolean {
        return false
    }

    override fun applyOptions(context: Context, builder: GlideBuilder) {
        super.applyOptions(context, builder)

        /**
         * DiskCacheStrategy.NONE： 表示不缓存任何内容。
         * DiskCacheStrategy.DATA： 表示只缓存原始图片。
         * DiskCacheStrategy.RESOURCE： 表示只缓存转换过后的图片。
         * DiskCacheStrategy.ALL ： 表示既缓存原始图片，也缓存转换过后的图片。
         * DiskCacheStrategy.AUTOMATIC： 表示让Glide根据图片资源智能地选择使用哪一种缓存策略（默认选项）。
         */
        builder.setDefaultRequestOptions(RequestOptions().diskCacheStrategy(DiskCacheStrategy.RESOURCE))

        /**
         * 优先外部存储作为磁盘缓存目录，防止内部存储文件过大
         * 外部存储目录默认地址为：/sdcard/Android/data/com.sina.weibolite/cache/image_manager_disk_cache
         */
        builder.setDiskCache(ExternalCacheDiskCacheFactory(context))

        // 定义缓存大小和位置
        builder.setDiskCache(InternalCacheDiskCacheFactory(context, diskSize.toLong()))  //内存中
        builder.setDiskCache(ExternalCacheDiskCacheFactory(context, "cache", diskSize)) //sd卡中

        // 默认内存和图片池大小

        // 自定义内存和图片池大小
        builder.setMemoryCache(LruResourceCache(memorySize.toLong()))
        builder.setBitmapPool(LruBitmapPool(memorySize.toLong()))

        // 定义图片格式
        builder.setDecodeFormat(DecodeFormat.PREFER_ARGB_8888)
        builder.setDecodeFormat(DecodeFormat.PREFER_RGB_565) // 默认


    }


}
