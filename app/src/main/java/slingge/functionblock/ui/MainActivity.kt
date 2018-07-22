package slingge.functionblock.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

import slingge.functionblock.R
import slingge.functionblock.ui.androidHeros.HerosCatalogActivity
import slingge.functionblock.ui.animGraphical.GraphicalActivity
import slingge.functionblock.ui.eventDistribution.EventDistributionActivity
import slingge.functionblock.ui.layout.LayoutViewActivity
import slingge.functionblock.ui.mvp.IpInfoActivity
import slingge.functionblock.ui.webView.WebViewActivity
import slingge.functionblock.ui.recyclerView.RecyclerViewActivity
import slingge.functionblock.ui.sideslip.SideslipMainActivity
import slingge.functionblock.ui.specialEffects.ClickEffects


class MainActivity : SlinggeActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        tv_layout.setOnClickListener(this)
        tv_recyclerView.setOnClickListener(this)
        tv_effects.setOnClickListener(this)
        tv_slid.setOnClickListener(this)
        tv_anim.setOnClickListener(this)
        tv_event.setOnClickListener(this)
        tv_webView.setOnClickListener(this)
        tv_heros.setOnClickListener(this)
        tv_control.setOnClickListener(this)
        tv_mvp.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.tv_layout -> startActivity(Intent(this, LayoutViewActivity::class.java))
            R.id.tv_recyclerView -> startActivity(Intent(this, RecyclerViewActivity::class.java))
            R.id.tv_effects -> startActivity(Intent(this, ClickEffects::class.java))
            R.id.tv_slid -> startActivity(Intent(this, SideslipMainActivity::class.java))
            R.id.tv_anim -> startActivity(Intent(this, GraphicalActivity::class.java))
            R.id.tv_event -> startActivity(Intent(this, EventDistributionActivity::class.java))
            R.id.tv_webView -> startActivity(Intent(this, WebViewActivity::class.java))
            R.id.tv_control -> startActivity(Intent(this, ControlActivity::class.java))
            R.id.tv_heros -> startActivity(Intent(this, HerosCatalogActivity::class.java))
            R.id.tv_mvp -> startActivity(Intent(this, IpInfoActivity::class.java))
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) { //RESULT_OK = -1
            val bundle = data.extras
            val scanResult = bundle!!.getString("result")
            Toast.makeText(this@MainActivity, scanResult, Toast.LENGTH_LONG).show()
        }
    }


}
