package slingge.functionblock.retrofitNet

import android.util.Log
import io.reactivex.SingleTransformer
import slingge.functionblock.util.ToastUtil

/**
 * Created by Slingge on 2019/1/9
 */
object SingleCompose {


    fun <T> compose(SingleObserver:SingleObserverInterface<T>): SingleTransformer<T, T> {
        return return SingleTransformer { upstream ->
            upstream.doOnSubscribe {
                ToastUtil.showToast("开始")
            }.doAfterSuccess {
                ToastUtil.showToast("结束")
            }.doOnSuccess {t:T?->
                t?.let {
                    SingleObserver.onSuccess(t)
                    if((it as BaseModel).result=="0"){
                        SingleObserver.onSuccess(t)
                    }else{
                        Log.e("数据错误","数据错误")
                        ToastUtil.showToast("数据错误")
                    }
                }
            }.doOnError {
                ToastUtil.showToast(it.toString())
            }
        }
    }



}