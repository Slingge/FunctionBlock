package slingge.functionblock.ui.rxJava.model.remote

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import slingge.functionblock.ui.rxJava.model.data.Article

/**
 * Created by Slingge on 2018/11/8.
 */
interface PaoService {

    @GET("article_detail.php")
    fun getArticleDetail(@Query("id") id: Int): Single<Article>

}