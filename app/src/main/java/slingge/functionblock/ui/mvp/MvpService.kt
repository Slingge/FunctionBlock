package slingge.functionblock.ui.mvp

import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import slingge.functionblock.ui.mvp.viewModel.UrlModel


/**
 * Created by Slingge on 2018/11/12
 */
interface MvpService {


    @GET("福利/10/1")
    fun getUrl(): Call<UrlModel>


}