package slingge.functionblock.ui.mvp

import android.os.Bundle
import com.google.gson.Gson
import com.nostra13.universalimageloader.core.ImageLoader
import kotlinx.android.synthetic.main.mvp_ipinfo_activity.*
import slingge.functionblock.R
import slingge.functionblock.ui.SlinggeActivity
import slingge.functionblock.util.ToastUtil

/**
 * Created by Slingge on 2018/7/18.
 */
class IpInfoActivity : SlinggeActivity(), IpinfoContract.View {

    private var ipinfoContract: IpinfoContract.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mvp_ipinfo_activity)
        int()
    }

    private fun int() {
        ipinfoContract = IpinfoPresenter(IpinfoTask, this)
        btn.setOnClickListener { v ->
            ipinfoContract!!.getIPInfo("")
        }
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