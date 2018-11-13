package slingge.functionblock.base

import android.os.Bundle
import android.os.PersistableBundle
import com.trello.navi2.NaviComponent
import com.trello.navi2.component.support.NaviAppCompatActivity
import com.trello.rxlifecycle2.navi.NaviLifecycle
import slingge.functionblock.ui.rxJava.viewModel.BaseViewModel

/**
 * Created by Slingge on 2018/11/13
 */
abstract class BaseActivity : NaviAppCompatActivity(), NaviComponent {

    private var vm: BaseViewModel? = null

    val provider = NaviLifecycle.createActivityLifecycleProvider(this)

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        init()
    }

    protected abstract fun init()

    fun setLife(vm: BaseViewModel) {
        this.vm = vm
        vm?.let {
            it.provider_activity = provider
            it.activity = this
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        //解除ViewModel生命周期感应
        vm?.let {
            it.detachView()
            vm = null
        }


    }

}