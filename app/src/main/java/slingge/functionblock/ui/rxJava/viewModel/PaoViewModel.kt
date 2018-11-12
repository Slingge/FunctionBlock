package slingge.functionblock.ui.rxJava.viewModel

import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import slingge.functionblock.ui.rxJava.model.data.Article
import slingge.functionblock.ui.rxJava.model.remote.PaoService

/**
 * Created by Slingge on 2018/11/8.
 */
class PaoViewModel(val remote: PaoService) {


    val articleDetails = ObservableField<String>()
    val loading= ObservableBoolean(false)
    val content = ObservableField<String>()
    val title = ObservableField<String>()
    val error = ObservableField<Throwable>()

    fun loadArticle() {
        //先使用默认id
        remote.getArticleDetail(8773)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
               /* .subscribe({ t: Article? ->
                    articleDetail.set(t?.toString())
                }, { t: Throwable? ->
                    articleDetail.set(t?.message ?: "error")
                })*/
    }

}