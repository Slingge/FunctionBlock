package slingge.functionblock.retrofitNet

import com.google.gson.Gson
import com.orhanobut.logger.Logger
import io.reactivex.SingleTransformer
import slingge.functionblock.util.ToastUtil

/**
 * Created by Slingge on 2019/1/9
 */
object SingleCompose {


    fun <T> compose(SingleObserver: SingleObserverInterface<T>): SingleTransformer<T, T> {
        return return SingleTransformer { upstream ->
            upstream.doOnSubscribe {
                ToastUtil.showToast("开始")
            }.doAfterSuccess {
                ToastUtil.showToast("结束")
            }.doOnSuccess { t: T? ->
                t?.let {
                    SingleObserver.onSuccess(t)
                    Logger.e("数据：\n" + Gson().toJson(it))
                    if ((it as BaseModel).result == "0") {
                        SingleObserver.onSuccess(t)
                    } else {
                        Logger.e("数据错误", Gson().toJson(it))
                        ToastUtil.showToast("数据错误")
                    }
                }
            }.doOnError {
                ToastUtil.showToast(it.toString())
            }
        }
    }


}