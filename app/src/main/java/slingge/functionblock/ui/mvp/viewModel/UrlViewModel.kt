package slingge.functionblock.ui.mvp.viewModel

import android.databinding.ObservableField
import com.nostra13.universalimageloader.core.ImageLoader
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import slingge.functionblock.databinding.MvpIpinfoActivityBinding
import slingge.functionblock.ui.mvp.MvpService


/**
 * Created by Slingge on 2018/11/12
 */
class UrlViewModel(val remote: MvpService, val binding: MvpIpinfoActivityBinding) : UrlModel() {

    val url = ObservableField<String>()

    fun getUrl() {

        remote.getUrl().enqueue(object : Callback<UrlModel> {
            override fun onFailure(p0: Call<UrlModel>, p1: Throwable) {
            }

            override fun onResponse(p0: Call<UrlModel>, p1: Response<UrlModel>?) {
                p1?.body()!!.results[0].url.let {
                    ImageLoader.getInstance().displayImage(it, binding.image)
                }
            }
        })
    }


}


