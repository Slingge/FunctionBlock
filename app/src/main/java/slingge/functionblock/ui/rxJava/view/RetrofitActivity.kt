package slingge.functionblock.ui.rxJava.view

import com.slingge.paopaonet.util.bindLifeCycle
import kotlinx.android.synthetic.main.activity_retrofit.*
import slingge.functionblock.R
import slingge.functionblock.base.BaseActivity
import slingge.functionblock.databinding.ActivityRetrofitBinding
import slingge.functionblock.retrofitNet.RetrofitUtil
import slingge.functionblock.ui.rxJava.remote.PaoService
import slingge.functionblock.ui.rxJava.viewModel.PaoViewModel

/**
 * Created by Slingge on 2018/11/7.
 */
class RetrofitActivity : BaseActivity<ActivityRetrofitBinding, PaoViewModel>() {

    override fun getLayoutId() = R.layout.activity_retrofit

    override fun getBaseViewModel() = PaoViewModel(RetrofitUtil.getRetrofitApi().create(PaoService::class.java))

    override fun init() {
        mBinding.vm = viewModel

        btn.setOnClickListener {
            viewModel?.loadArticle()!!.bindLifeCycle(this).subscribe()
        }
    }

    override fun loadData() {
    }

}