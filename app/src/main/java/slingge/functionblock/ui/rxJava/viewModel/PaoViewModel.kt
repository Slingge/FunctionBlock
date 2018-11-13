package slingge.functionblock.ui.rxJava.viewModel

import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import com.trello.rxlifecycle2.android.ActivityEvent
import slingge.functionblock.retrofitNet.NetObserver
import slingge.functionblock.retrofitNet.RxProgress
import slingge.functionblock.retrofitNet.RxSchedulers
import slingge.functionblock.ui.mvp.viewModel.UrlModel
import slingge.functionblock.ui.rxJava.model.data.Articleval
import slingge.functionblock.ui.rxJava.model.remote.PaoService

/**
 * Created by Slingge on 2018/11/8.
 */
class PaoViewModel(val remote: PaoService) : BaseViewModel()  {

   val articleDetails = ObservableField<String>()
    /*  val loading = ObservableBoolean(false)
     val content = ObservableField<String>()
     val title = ObservableField<String>()
     val error = ObservableField<Throwable>()*/

    fun loadArticle() {
        //先使用默认id
        remote.getArticleDetail()
                .compose(RxSchedulers.compose())
                .compose(RxProgress.compose())
                .compose(provider_activity?.bindUntilEvent(ActivityEvent.DESTROY))
                .subscribe(object : NetObserver<UrlModel>() {
                    override fun onSuccess(response: UrlModel) {
                        articleDetails.set(response.results[0].url)
                    }
                    override fun onFail(msg: String) {
                    }

                })
    }

}

