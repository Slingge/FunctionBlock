package slingge.functionblock.ui.rxJava.viewModel

import android.databinding.Bindable
import com.trello.rxlifecycle2.android.ActivityEvent
import slingge.functionblock.BR
import slingge.functionblock.retrofitNet.NetObserver
import slingge.functionblock.retrofitNet.RxProgress
import slingge.functionblock.retrofitNet.RxSchedulers
import slingge.functionblock.ui.mvp.viewModel.UrlModel
import slingge.functionblock.ui.rxJava.model.remote.PaoService

/**
 * Created by Slingge on 2018/11/8.
 */
class PaoViewModel(val remote: PaoService) : BaseViewModel() {

    @Bindable
    var url = ""

    fun loadArticle() {
        //先使用默认id
        remote.getArticleDetail()
                .compose(RxSchedulers.compose())
                .compose(RxProgress.compose())
                .compose(provider_activity?.bindUntilEvent(ActivityEvent.DESTROY))
                .subscribe(object : NetObserver<UrlModel>() {
                    override fun onSuccess(response: UrlModel) {
                        url = response.results[0].url
                        notifyPropertyChanged(BR.url)
                    }

                    override fun onFail(msg: String) {
                    }
                })
    }

}

