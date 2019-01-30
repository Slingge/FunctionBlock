package slingge.functionblock.ui.rxJava.remote

import io.reactivex.Single
import retrofit2.http.*
import slingge.functionblock.ui.mvp.viewModel.UrlModel

/**
 * Created by Slingge on 2018/11/8.
 */
interface PaoService {

//    @GET("福利/10/1")
//    fun getArticleDetail(): Observable<UrlModel>

    @GET("福利/10/1")
    fun getArticleDetail(): Single<UrlModel>
}