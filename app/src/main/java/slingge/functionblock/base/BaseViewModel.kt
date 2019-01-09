package slingge.functionblock.base

import android.app.Activity

/**
 * Created by Slingge on 2018/11/13
 */
abstract class BaseViewModel  /*: BaseObservable() */{

    var activity: Activity? = null

    fun detachView() {
        activity?.let {
            activity = null
        }
    }


}