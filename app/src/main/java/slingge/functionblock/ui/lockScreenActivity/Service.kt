package slingge.functionblock.ui.lockScreenActivity

import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.IBinder
import android.content.IntentFilter
import slingge.functionblock.util.ToastUtil


/**
 * Created by Slingge on 2018/8/6
 */
class Service : Service() {


    override fun onCreate() {
        super.onCreate()
        val mScreenOnFilter = IntentFilter()
        mScreenOnFilter.addAction(Intent.ACTION_SCREEN_OFF)
        mScreenOnFilter.addAction(Intent.ACTION_SCREEN_ON)
        registerReceiver(mScreenActionReceiver, mScreenOnFilter)
    }

    private val mScreenActionReceiver = object : BroadcastReceiver() {
        override fun onReceive(p0: Context?, p1: Intent?) {
            val action = p1!!.action
            if (action == Intent.ACTION_SCREEN_OFF) {//锁屏
                ToastUtil.showToast("锁屏")
                val LockIntent = Intent(this@Service, LockScreenActivity::class.java)
                LockIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS)
                startActivity(LockIntent)
            }
        }
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }
}