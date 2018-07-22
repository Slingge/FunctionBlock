package slingge.functionblock.ui.mvp


/**
 * Created by Slingge on 2018/7/17.
 */
interface LoadTaskCallBack<T> {

    fun onSuccess(t: String)

    fun onStart()

    fun onFailed()

    fun onFinish()

}