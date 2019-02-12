package slingge.functionblock.util

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.widget.Toast

import slingge.functionblock.application.SApplication


/**
 * Created by Administrator on 2016/9/27 0027.
 */
object ToastUtil {

    private var mToast: Toast? = null

    /**
     * 上下文.
     */

    /**
     * 显示Toast.
     */
    val SHOW_TOAST = 0

    /**
     * 主要Handler类，在线程中可用
     * what：0.提示文本信息
     */
    @SuppressLint("HandlerLeak")
    private val baseHandler = object : Handler() {

        override fun handleMessage(msg: Message) {
            when (msg.what) {
                SHOW_TOAST -> showToast(SApplication.getInstance(), msg.data.getString("TEXT"))
                else -> {
                }
            }
        }
    }

    /**
     * 描述：Toast提示文本.
     *
     * @param text 文本
     */
    fun showToast(context: Context?, text: String?) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }

    /**
     * 描述：Toast提示文本.
     *
     * @param text 文本
     */
    fun showToast(text: String) {
        if (mToast != null) {
            mToast!!.cancel()
        }
            mToast = Toast.makeText(SApplication.getInstance(), text, Toast.LENGTH_SHORT)
        mToast!!.duration = Toast.LENGTH_SHORT
        mToast!!.show()
    }

    /**
     * 描述：Toast提示文本.
     *
     * @param resId 文本的资源ID
     */
    fun showToast(context: Context, resId: Int) {
        Toast.makeText(SApplication.getInstance(), "" + context.resources.getText(resId), Toast.LENGTH_SHORT).show()
    }

    /**
     * 描述：在线程中提示文本信息.
     *
     * @param resId 要提示的字符串资源ID，消息what值为0,
     */
    fun showToastInThread(context: Context, resId: Int) {
        val msg = baseHandler.obtainMessage(SHOW_TOAST)
        val bundle = Bundle()
        bundle.putString("TEXT", context.resources.getString(resId))
        msg.data = bundle
        baseHandler.sendMessage(msg)
    }

    /**
     * 描述：在线程中提示文本信息.
     */
    fun showToastInThread(context: Context, text: String) {
        val msg = baseHandler.obtainMessage(SHOW_TOAST)
        val bundle = Bundle()
        bundle.putString("TEXT", text)
        msg.data = bundle
        baseHandler.sendMessage(msg)
    }

}
