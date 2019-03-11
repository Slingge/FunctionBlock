package slingge.functionblock.retrofitNet.exception

import android.net.ParseException

import com.google.gson.JsonParseException
import org.json.JSONException

import java.io.InterruptedIOException
import java.net.ConnectException
import java.net.UnknownHostException

import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import retrofit2.HttpException
import slingge.functionblock.retrofitNet.BaseModel
import slingge.functionblock.util.ToastUtil

abstract class NetObserver<T> : Observer<T> {

    override fun onSubscribe(d: Disposable) {
    }

    override fun onNext(t: T) {
        if (t is BaseModel) {
            onSuccess(t)
        } else {
            onSuccess(t)
        }
    }


    override fun onError(e: Throwable) {
        if (e is HttpException) {     //   HTTP错误
            onError("网络错误", e)
        } else if (e is ConnectException || e is UnknownHostException) {   //   连接错误
            onError("连接失败", e)
        } else if (e is InterruptedIOException) {   //  连接超时
            onError("请求超时", e)
        } else if (e is JsonParseException
                || e is JSONException
                || e is ParseException) {   //  解析错误
            onError("数据解析错误", e)
        } else {
            onError("请求连接失败", e)
        }
        ToastUtil.showToast("网络错误")
    }

    override fun onComplete() {
    }


    private fun onError(msg: String, e: Throwable) {
        if (true) {
            onFail(e.toString())
        } else {
            onFail(msg)
        }
    }

    abstract fun onSuccess(response: T)

    abstract fun onFail(msg: String)


}
