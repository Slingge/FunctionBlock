package slingge.functionblock.ui.mvp

/**
 * Created by Slingge on 2018/7/18.
 */
class IpinfoPresenter(val netTask: NetTask<String>, val addTaskView: IpinfoContract.View) : IpinfoContract.Presenter, LoadTaskCallBack<IpinfoModel> {
    override fun onSuccess(t: String) {
        addTaskView.setIPINfo(t)
    }


    override fun getIPInfo(ip: String) {
        netTask.execte(ip, this)
    }

    override fun onStart() {
        addTaskView.showLoading()
    }

    override fun onFailed() {

    }

    override fun onFinish() {

    }


}