package slingge.functionblock.base

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView

import slingge.functionblock.R
import slingge.functionblock.ui.moveFinish.SwipeBackLayout
import slingge.functionblock.view.StatusBarUtil

/**
 * Created by Slingge on 2017/1/6 0006.
 */

open class SlinggeActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            StatusBarUtil.setColor(this, this.resources.getColor(R.color.AsukaColor))
        }
        val layout = LayoutInflater.from(this).inflate(
                R.layout.base_sildingfinish, null) as SwipeBackLayout
        layout.isRightSlide = true
        layout.isLeftSlide = true
        layout.isUpSlide = false
        layout.isDownSlide = false
        layout.attachToActivity(this)
    }


    protected fun setTitle(title: String) {
        val tv_title = findViewById<View>(R.id.tv_title) as TextView
        val image_back = findViewById<View>(R.id.image_back) as ImageView
        tv_title.text = title
        image_back.setOnClickListener { finish() }
    }


    override fun startActivity(intent: Intent) {
        super.startActivity(intent)
        overridePendingTransition(R.anim.base_slide_right_in, R.anim.base_slide_remain)
    }


    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(0, R.anim.base_slide_right_out)
    }


}
