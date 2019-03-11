package slingge.functionblock.retrofitNet

import slingge.functionblock.retrofitNet.exception.NetObserver
import slingge.functionblock.util.ToastUtil

abstract class MyNetObserver<T> : NetObserver<T>() {

    override fun onSuccess(response: T) {

    }

    override fun onFail(msg: String) {
        ToastUtil.showToast(msg)
    }

}
