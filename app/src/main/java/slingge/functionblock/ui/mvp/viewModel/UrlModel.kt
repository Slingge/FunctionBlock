package slingge.functionblock.ui.mvp.viewModel

import slingge.functionblock.retrofitNet.BaseModel
import java.util.ArrayList

/**
 * Created by Slingge on 2018/11/12.
 */
open class UrlModel : BaseModel() {


    var error = false

    var results = ArrayList<resultsModel>()

    class resultsModel {

        var url = ""
    }

}