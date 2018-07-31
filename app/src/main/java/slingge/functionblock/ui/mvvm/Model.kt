package slingge.functionblock.ui.mvvm

import android.databinding.BaseObservable
import android.databinding.Bindable
import slingge.functionblock.BR

/**
 * Created by Slingge on 2018/7/24.
 */
class Model: BaseObservable() {

    @Bindable
    var name = ""
    @Bindable
    var age = 0
    @Bindable
    var imageUrl=""

    fun notify(age:Int){
        this.age=age
        notifyPropertyChanged(BR.age)
    }

}