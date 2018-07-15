package slingge.functionblock.ui.util

import android.app.ProgressDialog
import android.content.Context
import slingge.functionblock.R

/**
 * Created by Slingge on 2018/6/30.
 */
object ProgressDialogUtil {

    private var progress: ProgressDialog? = null

    fun progressDialog(context: Context) {
        if (progress == null) {
            progress = ProgressDialog(context, R.style.Theme_AppCompat_DayNight_NoActionBar)
            progress!!.setMessage("加载中...")
            progress!!.setCancelable(true)
        }
        if (!progress!!.isShowing) {
            progress!!.show()
        }
    }


    fun ProgressDismiss() {
        if (progress != null && progress!!.isShowing) {
            progress!!.dismiss()
        }
    }


}