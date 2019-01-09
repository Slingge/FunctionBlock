package slingge.functionblock.ui.rxJava.viewModel

import android.databinding.ObservableField
import com.slingge.paopaonet.util.async
import com.trello.rxlifecycle2.android.ActivityEvent
import io.reactivex.ObservableTransformer
import io.reactivex.Single
import slingge.functionblock.base.BaseViewModel
import slingge.functionblock.retrofitNet.*
import slingge.functionblock.ui.mvp.viewModel.UrlModel
import slingge.functionblock.ui.rxJava.remote.PaoService
import slingge.functionblock.util.ToastUtil

/**
 * Created by Slingge on 2018/11/8.
 */
class PaoViewModel(val remote: PaoService) : BaseViewModel() {

//    @Bindable
//    var url = ""

    //或者
    val urls = ObservableField<String>()

//    fun loadArticle() {
    //先使用默认id
//        remote.getArticleDetail()
//                .compose(RxSchedulers.compose())
//                .compose(RxProgress.compose())
//                .compose(provider_activity?.bindUntilEvent(ActivityEvent.DESTROY))
//                .subscribe(object : MyNetObserver<UrlModel>() {
//                    override fun onSuccess(response: UrlModel) {
////                        url = response.results[0].url
////                        notifyPropertyChanged(BR.url)
//                        //或者
//                        urls.set(response.results[0].url)
//                    }
//                })
//    }


    fun loadArticle(): Single<UrlModel> =
    //先使用默认id
            remote.getArticleDetail()
                    .async()
                    .compose(SingleCompose.compose())
                    .doOnSuccess { response: UrlModel ->
                        // urls = response.results[0].url
                        // notifyPropertyChanged(BR.url)
                        //或者
                        urls.set(response.results[0].url)
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
