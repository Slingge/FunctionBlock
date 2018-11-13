package slingge.functionblock.retrofitNet


import android.app.Activity
import android.content.DialogInterface

import java.lang.ref.WeakReference
import io.reactivex.functions.Consumer
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Action
import slingge.functionblock.util.ToastUtil

object RxProgress {
    fun <T> compose(): ObservableTransformer<T, T> {
        return return ObservableTransformer { upstream ->
            upstream.doOnSubscribe {
                ToastUtil.showToast("开始")
            }.doOnTerminate {
                ToastUtil.showToast("结束？")
            }
        }
    }

    fun <T> compose(activity: Activity): ObservableTransformer<T, T> {
        return ObservableTransformer { upstream -> upstream.doOnSubscribe { }.doOnTerminate { } }
    }


}
