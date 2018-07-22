package slingge.functionblock.ui.mvp

/**
 * Created by Slingge on 2018/7/18.
 */
interface IpinfoContract {

    interface Presenter {
        fun getIPInfo(ip: String)
    }

    interface View : BaseView<Presenter> {
        fun setIPINfo(ipinfoModel: String)

        fun showLoading()

        fun hideLoading()

        fun showError()

//        var isActive: Boolean
    }


}