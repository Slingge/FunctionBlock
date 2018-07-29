package slingge.functionblock.ui.mvvm

import android.databinding.DataBindingUtil
import android.os.Bundle
import slingge.functionblock.R
import slingge.functionblock.databinding.ActivityMvvmBinding
import slingge.functionblock.ui.SlinggeActivity

/**
 * Created by Slingge on 2018/7/24.
 */
class MvvmActivity : SlinggeActivity() {

    private var binding: ActivityMvvmBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm)
        init()
    }

    private fun init() {
        setTitle("MVVP模式")
        val model = Model()
        model.name = "温莉洛克贝尔"
        model.age = "16"
        binding!!.model = model
    }


}