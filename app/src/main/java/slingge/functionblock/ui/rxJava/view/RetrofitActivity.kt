package slingge.functionblock.ui.rxJava.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import slingge.functionblock.R
import slingge.functionblock.base.BaseActivity
import slingge.functionblock.databinding.ActivityRetrofitBinding
import slingge.functionblock.retrofitNet.RetrofitUtil
import slingge.functionblock.base.SlinggeActivity
import slingge.functionblock.ui.rxJava.model.remote.PaoService
import slingge.functionblock.ui.rxJava.viewModel.PaoViewModel

/**
 * Created by Slingge on 2018/11/7.
 */
class RetrofitActivity : BaseActivity() {

    private lateinit var mViewModel: PaoViewModel
    private lateinit var mBinding: ActivityRetrofitBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_retrofit)
        init()
    }

    override fun init() {
        mViewModel = PaoViewModel(RetrofitUtil.getRetrofitApi().create(PaoService::class.java))
        mBinding.vm = mViewModel
        setLife(mViewModel)
    }


}