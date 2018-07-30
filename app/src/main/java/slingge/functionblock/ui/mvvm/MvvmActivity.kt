package slingge.functionblock.ui.mvvm

import android.databinding.DataBindingUtil
import android.os.Bundle
import slingge.functionblock.R
import slingge.functionblock.databinding.ActivityMvvmBinding
import slingge.functionblock.ui.SlinggeActivity
import slingge.functionblock.util.ToastUtil

/**
 * Created by Slingge on 2018/7/24.
 */
class MvvmActivity : SlinggeActivity() {

    private var binding: ActivityMvvmBinding? = null

    private val model = Model()
    private var age = 16

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm)
        init()
    }

    private fun init() {
        setTitle("MVVP模式")
        model.name = "温莉洛克贝尔"
        model.age = age
        binding!!.model = model

        binding!!.btn.setOnClickListener { v ->
            age++
            model.notify(age)
        }

    }


}