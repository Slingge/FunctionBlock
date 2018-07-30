package slingge.functionblock.ui.mvvm

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.BindingAdapter
import android.widget.ImageView
import com.nostra13.universalimageloader.core.ImageLoader
import slingge.functionblock.BR

/**
 * Created by Slingge on 2018/7/24.
 */
class Model: BaseObservable() {

    @Bindable
    var name = ""
    @Bindable
    var age = 0

    var imageUrl=""

    fun notify(age:Int){
        this.age=age
        notifyPropertyChanged(BR.age)
    }


    @Bindable("imageUrl")
    fun loadImage(iv: ImageView, url: String) {
        ImageLoader.getInstance().displayImage(url, iv)
    }

}