package slingge.functionblock.ui.mvp

/**
 * Created by Slingge on 2018/7/17.
 */
interface NetTask<T> {
    fun execte(data: T, loadTaskCallBack: LoadTaskCallBack<IpinfoModel>)
}