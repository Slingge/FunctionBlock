package slingge.functionblock.ui.rxJava.viewModel

import android.databinding.ObservableField
import com.orhanobut.logger.Logger
import com.slingge.paopaonet.util.async
import io.reactivex.ObservableTransformer
import io.reactivex.Single
import okhttp3.*
import slingge.functionblock.base.BaseViewModel
import slingge.functionblock.retrofitNet.*
import slingge.functionblock.ui.mvp.viewModel.UrlModel
import slingge.functionblock.ui.rxJava.remote.PaoService
import slingge.functionblock.util.ThreadUtil
import slingge.functionblock.util.ToastUtil
import android.os.Environment.getExternalStorageDirectory
import java.io.*


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
            remote.getArticleDetail()
                    .async()
                    .compose(SingleCompose.compose(object : SingleObserverInterface<UrlModel> {
                        override fun <T> onSuccess(response: T) {
                            Logger.e("拿到数据 \n" + (response as UrlModel).results[0].url)
                            urls.set((response as UrlModel).results[0].url)
                        }
                    }))

    /*        .doOnSuccess { response: UrlModel ->
                // urls = response.results[0].url
                // notifyPropertyChanged(BR.url)
                //或者
                urls.set(response.results[0].url)
            }*/


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



