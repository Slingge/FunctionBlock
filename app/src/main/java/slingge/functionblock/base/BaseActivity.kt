package slingge.functionblock.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import com.trello.navi2.NaviComponent
import com.trello.navi2.component.support.NaviAppCompatActivity
import com.trello.rxlifecycle2.navi.NaviLifecycle
import slingge.functionblock.ui.rxJava.viewModel.BaseViewModel

/**
 * Created by Slingge on 2018/11/13
 */
abstract class BaseActivity<VB : ViewDataBinding> : NaviAppCompatActivity(), NaviComponent {

    protected lateinit var mBinding: VB

    private var vm: BaseViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, getLayoutId())
        mBinding.setLifecycleOwner(this)
        init()
        loadData()
    }

    abstract fun getLayoutId(): Int
    protected abstract fun init()
    abstract fun loadData()

    fun setLife(vm: BaseViewModel) {
        this.vm = vm
        vm.provider_activity = NaviLifecycle.createActivityLifecycleProvider(this)
        vm.activity = this
    }

    override fun onDestroy() {
        super.onDestroy()
        //解除ViewModel生命周期感应
        vm?.let {
            it.detachView()
            vm = null
        }
        mBinding.unbind()
    }

}