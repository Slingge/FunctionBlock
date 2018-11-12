package slingge.functionblock.ui.mvp

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.renderscript.ScriptGroup
import com.google.gson.Gson
import com.nostra13.universalimageloader.core.ImageLoader
import kotlinx.android.synthetic.main.mvp_ipinfo_activity.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import slingge.functionblock.R
import slingge.functionblock.databinding.MvpIpinfoActivityBinding
import slingge.functionblock.ui.SlinggeActivity
import slingge.functionblock.ui.mvp.viewModel.UrlViewModel
import slingge.functionblock.ui.rxJava.model.remote.PaoService
import slingge.functionblock.ui.rxJava.viewModel.PaoViewModel
import slingge.functionblock.util.ToastUtil

/**
 * Created by Slingge on 2018/7/18.
 */
class IpInfoActivity : SlinggeActivity(), IpinfoContract.View {

    private var ipinfoContract: IpinfoContract.Presenter? = null

    private lateinit var mViewModel: UrlViewModel
    private lateinit var binding: MvpIpinfoActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.mvp_ipinfo_activity)
        int()
    }

    private fun int() {
        ipinfoContract = IpinfoPresenter(IpinfoTask, this)
        btn.setOnClickListener { v ->
//                        ipinfoContract!!.getIPInfo("")
            mViewModel.getUrl()
        }
        val remote = Retrofit.Builder()
                .baseUrl("http://guolin.tech/api/")
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create())
                .build().create(MvpService::class.java)

        mViewModel = UrlViewModel(remote)
        binding.vm = mViewModel
    }


    override fun setPresenter(presenter: IpinfoContract.Presenter) {

    }

    override fun setIPINfo(ipinfoModel: String) {
        ImageLoader.getInstance().displayImage(ipinfoModel, image)
    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun showError() {

    }


}