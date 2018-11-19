package slingge.functionblock.ui.rxJava.viewModel

import android.databinding.Bindable
import android.databinding.ObservableField
import com.trello.rxlifecycle2.android.ActivityEvent
import io.reactivex.ObservableTransformer
import slingge.functionblock.BR
import slingge.functionblock.base.BaseViewModel
import slingge.functionblock.retrofitNet.NetObserver
import slingge.functionblock.retrofitNet.RxSchedulers
import slingge.functionblock.ui.mvp.viewModel.UrlModel
import slingge.functionblock.ui.rxJava.remote.PaoService
import slingge.functionblock.util.ToastUtil

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
                .compose(compose())
                .compose(provider_activity?.bindUntilEvent(ActivityEvent.DESTROY))
                .subscribe(object : NetObserver<UrlModel>() {
                    override fun onSuccess(response: UrlModel) {
                        url=response.results[0].url
                        notifyPropertyChanged(BR.url)
                    }

                    override fun onFail(msg: String) {
                    }
                })
    }

    fun <T> compose(): ObservableTransformer<T, T> {
        return return ObservableTransformer { upstream ->
            upstream.doOnSubscribe {
                ToastUtil.showToast("开始加载")
            }.doOnTerminate {
                ToastUtil.showToast("结束加载")
            }
        }

    }
}