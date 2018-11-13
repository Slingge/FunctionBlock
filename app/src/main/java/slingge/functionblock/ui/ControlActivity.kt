package slingge.functionblock.ui

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import kotlinx.android.synthetic.main.activity_control.*
import slingge.functionblock.R
import slingge.functionblock.base.SlinggeActivity
import slingge.functionblock.util.ToastUtil

/**
 * Created by Slingge on 2018/7/12.
 */
class ControlActivity : SlinggeActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_control)
        init()
    }


    private fun init() {
        btn_snackbar.setOnClickListener(this)
        btn_enter.setOnClickListener(this)
    }


    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.btn_snackbar -> {
                showSnackbar()
            }
            R.id.btn_enter -> {
                textlayout.error = "用户名错误"
                textlayout.isErrorEnabled = true
                textlayout2.error = "密码正确"
                textlayout2.isErrorEnabled = false
            }
        }
    }


    private fun showSnackbar() {
        Snackbar.make(cl_main, "标题", Snackbar.LENGTH_LONG).setAction("点击事件") { v ->
            ToastUtil.showToast("toast")
        }.setDuration(Snackbar.LENGTH_LONG).show()
    }


}



