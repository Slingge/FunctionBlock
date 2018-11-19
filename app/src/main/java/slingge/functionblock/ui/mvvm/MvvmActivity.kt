package slingge.functionblock.ui.mvvm

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import slingge.functionblock.R
import slingge.functionblock.databinding.ActivityMvvmBinding
import slingge.functionblock.base.SlinggeActivity

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
        model.imageUrl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec" +
                "=1533011536307&di=d2834d467422f1e62f55dc00d580d7e6&imgtype=0&src=http%3A%2F%2Fimg21.mtime" +
                ".cn%2Fmg%2F2011%2F12%2F11%2F202159.69791755.jpg"
        binding!!.model = model

        val linearLayoutManager = LinearLayoutManager(this)
        binding!!.recyclerView.layoutManager = linearLayoutManager

        var list = ArrayList<ItemModel>()
        list.add(ItemModel("爱德华-埃里克"))
        list.add(ItemModel("温丽-洛克贝尔"))

        val adapter = Adapter(this, list)
        binding!!.recyclerView.adapter=adapter
    }


}