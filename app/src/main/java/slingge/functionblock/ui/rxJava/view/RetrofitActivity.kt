package slingge.functionblock.ui.rxJava.view

import slingge.functionblock.R
import slingge.functionblock.base.BaseActivity
import slingge.functionblock.databinding.ActivityRetrofitBinding
import slingge.functionblock.retrofitNet.RetrofitUtil
import slingge.functionblock.ui.rxJava.model.remote.PaoService
import slingge.functionblock.ui.rxJava.viewModel.PaoViewModel

/**
 * Created by Slingge on 2018/11/7.
 */
class RetrofitActivity : BaseActivity<ActivityRetrofitBinding>() {


    private lateinit var mViewModel: PaoViewModel

    override fun getLayoutId() = R.layout.activity_retrofit

    override fun init() {
        mViewModel = PaoViewModel(RetrofitUtil.getRetrofitApi().create(PaoService::class.java))
        mBinding.vm = mViewModel
        setLife(mViewModel)
    }

    override fun loadData() {
    }

}