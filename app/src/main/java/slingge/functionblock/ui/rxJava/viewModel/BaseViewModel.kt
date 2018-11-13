package slingge.functionblock.ui.rxJava.viewModel

import android.app.Activity
import com.trello.rxlifecycle2.LifecycleProvider
import com.trello.rxlifecycle2.android.ActivityEvent
import com.trello.rxlifecycle2.android.FragmentEvent

/**
 * Created by Slingge on 2018/11/13
 */
abstract class BaseViewModel {

    var provider_fragment: LifecycleProvider<FragmentEvent>? = null
    var provider_activity: LifecycleProvider<ActivityEvent>? = null
    var activity: Activity? = null


    fun detachView() {
        activity?.let {
            activity = null
        }
    }


}