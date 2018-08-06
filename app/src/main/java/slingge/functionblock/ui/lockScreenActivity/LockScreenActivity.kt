package slingge.functionblock.ui.lockScreenActivity

import android.app.Activity
import android.app.KeyguardManager
import android.os.Bundle
import android.view.KeyEvent
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_lockscreen.*
import slingge.functionblock.R
import slingge.functionblock.ui.SlinggeActivity

/**
 * Created by Slingge on 2018/8/6
 */
 class LockScreenActivity:SlinggeActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val win = window
        win.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
                or WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD
                or WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
                or WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON)
        setContentView(R.layout.activity_lockscreen)

        val keyguardManager = getSystemService(Activity.KEYGUARD_SERVICE) as KeyguardManager
        val keyguardLock = keyguardManager.newKeyguardLock("")
        keyguardLock.disableKeyguard()

        init()
    }

    private fun init() {
        tv_backdl.setOnClickListener { v -> finish() }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        val key = event.keyCode
        when (key) {
            KeyEvent.KEYCODE_BACK -> {
                return true
            }
            KeyEvent.KEYCODE_MENU -> {
                return true
            }
        }
        return super.onKeyDown(keyCode, event)
    }


}