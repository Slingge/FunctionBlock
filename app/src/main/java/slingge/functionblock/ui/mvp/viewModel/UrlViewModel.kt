package slingge.functionblock.ui.mvp.viewModel

import android.databinding.BaseObservable
import android.databinding.Bindable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import slingge.functionblock.BR
import slingge.functionblock.ui.mvp.MvpService
import slingge.functionblock.util.ToastUtil


/**
 * Created by Slingge on 2018/11/12
 */
class UrlViewModel(val remote: MvpService) : BaseObservable() {

    @Bindable
    var imageUrl = ""

    fun getUrl() {
        remote.getUrl().enqueue(object : Callback<UrlModel> {
            override fun onFailure(p0: Call<UrlModel>, p1: Throwable) {
            }

            override fun onResponse(p0: Call<UrlModel>, p1: Response<UrlModel>?) {
                p1?.body()!!.results[0].url.let {
                    imageUrl=it
                    notifyPropertyChanged(BR.imageUrl)
                    ToastUtil.showToast(imageUrl)
                }
            }
        })
    }


}


