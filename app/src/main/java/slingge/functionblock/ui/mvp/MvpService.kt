package slingge.functionblock.ui.mvp

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET


/**
 * Created by Slingge on 2018/11/12
 */
interface MvpService {


    @GET("bing_pic")
    fun getUrl(): okhttp3.Callback


}