package slingge.functionblock.retrofitNet

import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import slingge.functionblock.application.SApplication
import java.util.concurrent.TimeUnit

/**
 * Created by Slingge on 2018/11/13
 */
object RetrofitUtil {


    private val url = "http://gank.io/api/data/"

    private fun getClient(): OkHttpClient {
        val cache = Cache(SApplication.getInstance().cacheDir, (1024 * 1024).toLong())
        return OkHttpClient.Builder()
                .cache(cache)
                .connectTimeout(6000, TimeUnit.SECONDS)
                .readTimeout(6000, TimeUnit.SECONDS)
                //                .addInterceptor(new RequestLogInterceoptor())
                //                .addInterceptor(new ResponseLogInterceptor())
                //                .addInterceptor(new RequestLogInterceoptor())
                .build()
    }

    fun getRetrofitApi(): Retrofit {
        val retrofit = Retrofit.Builder()
                .baseUrl(url)
                .client(getClient())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        return retrofit
    }

}