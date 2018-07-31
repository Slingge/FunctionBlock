package slingge.functionblock.ui.mvvm

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.nostra13.universalimageloader.core.ImageLoader
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
        model.imageUrl="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533011536307&di=d2834d467422f1e62f55dc00d580d7e6&imgtype=0&src=http%3A%2F%2Fimg21.mtime.cn%2Fmg%2F2011%2F12%2F11%2F202159.69791755.jpg"
        binding!!.model = model

        binding!!.btn.setOnClickListener { v ->
            age++
            model.notify(age)
        }

        ImageLoader.getInstance().displayImage(model.imageUrl,binding!!.image)
    }


}