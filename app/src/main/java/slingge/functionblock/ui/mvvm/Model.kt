package slingge.functionblock.ui.mvvm

import android.content.Context
import android.databinding.BaseObservable
import android.databinding.Bindable
import android.view.View
import kotlinx.android.synthetic.main.activity_mvvm.*
import slingge.functionblock.BR
import slingge.functionblock.R
import slingge.functionblock.util.ToastUtil

/**
 * Created by Slingge on 2018/7/24.
 */
class Model : BaseObservable() {

    @Bindable
    var name = ""
    @Bindable
    var age = 0
    @Bindable
    var imageUrl = ""
    @Bindable
    var ages = ""

    fun notify(age: Int,ages:String) {
        this.age = age
        this.ages=ages
        notifyPropertyChanged(BR.age)
        notifyPropertyChanged(BR.ages)
    }


    fun onClickListener(view: View) {
        when (view.id) {
            R.id.tv_age -> {
                ToastUtil.showToast("年龄")
            }
            R.id.tv_name -> {
                ToastUtil.showToast("名字")
            }
            R.id.image -> {
                ToastUtil.showToast("图像")
            }
            R.id.btn -> {
                age++
                notify(age,ages)
                ToastUtil.showToast("自定义年龄$ages")
            }
        }
    }

}