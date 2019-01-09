package slingge.functionblock.retrofitNet

import android.util.Log
import io.reactivex.SingleTransformer
import slingge.functionblock.util.ToastUtil

/**
 * Created by Slingge on 2019/1/9
 */
object SingleCompose {


    fun <T> compose(): SingleTransformer<T, T> {
        return return SingleTransformer { upstream ->
            upstream.doOnSubscribe {
                ToastUtil.showToast("开始")
            }.doAfterSuccess {
                ToastUtil.showToast("结束")
            }.doOnSuccess { t: T ->
                Log.e("faefawefwef","请求成功")
            }.doOnError {
                Log.e("faefawefwef","请求失败")
                ToastUtil.showToast(it.toString())
            }
        }
    }


}