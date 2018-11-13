package slingge.functionblock.ui.rxJava.model.remote

import io.reactivex.Observable
import retrofit2.http.*
import slingge.functionblock.ui.mvp.viewModel.UrlModel

/**
 * Created by Slingge on 2018/11/8.
 */
interface PaoService {

    @GET("福利/10/1")
    fun getArticleDetail(): Observable<UrlModel>
}