package slingge.functionblock.ui.mvp

import com.zhy.http.okhttp.OkHttpUtils
import com.zhy.http.okhttp.callback.StringCallback
import okhttp3.Call
import slingge.functionblock.util.ToastUtil
import java.lang.Exception

/**
 * Created by Slingge on 2018/7/17.
 */
object IpinfoTask : NetTask<String> {

    override fun execte(ip: String, loadTaskCallBack: LoadTaskCallBack<IpinfoModel>) {
        loadTaskCallBack.onStart()

        OkHttpUtils.get().url("http://guolin.tech/api/bing_pic").build().execute(object : StringCallback() {
            override fun onError(call: Call?, e: Exception?, id: Int) {
                loadTaskCallBack.onFailed()
            }

            override fun onResponse(response: String, id: Int) {
                ToastUtil.showToast(response)
                loadTaskCallBack.onSuccess(response)
            }
        })
    }


}