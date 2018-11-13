package slingge.functionblock.ui.rxJava.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import slingge.functionblock.R
import slingge.functionblock.databinding.ActivityRetrofitBinding
import slingge.functionblock.retrofitNet.RetrofitUtil
import slingge.functionblock.ui.SlinggeActivity
import slingge.functionblock.ui.rxJava.model.remote.PaoService
import slingge.functionblock.ui.rxJava.viewModel.PaoViewModel

/**
 * Created by Slingge on 2018/11/7.
 */
class RetrofitActivity : SlinggeActivity() {

    private lateinit var mViewModel: PaoViewModel
    private lateinit var mBinding: ActivityRetrofitBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_retrofit)
        init()
    }


    private fun init() {
        mViewModel = PaoViewModel(RetrofitUtil.getRetrofitApi().create(PaoService::class.java),this)
        mBinding.vm = mViewModel
    }


}