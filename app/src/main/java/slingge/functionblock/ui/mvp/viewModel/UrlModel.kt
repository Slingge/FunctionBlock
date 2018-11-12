package slingge.functionblock.ui.mvp.viewModel

import java.util.ArrayList

/**
 * Created by Slingge on 2018/11/12.
 */
open class UrlModel {


    var error = false

    var results = ArrayList<resultsModel>()

    class resultsModel {

        var url = ""
    }

}