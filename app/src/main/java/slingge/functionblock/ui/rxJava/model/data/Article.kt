package slingge.functionblock.ui.rxJava.model.data

import android.databinding.BaseObservable
import slingge.functionblock.ui.rxJava.model.remote.PaoService

/**
 * Created by Slingge on 2018/11/8.
 */
class Articleval : BaseObservable() {


    var id: Int = 0
    var title: String = ""
    var readme: String = ""
    var describe: String = ""
    var click: Int = 0
    var channel: Int = 0
    var comments: Int = 0
    var stow: Int = 0
    var upvote: Int = 0
    var downvote: Int = 0
    var url: String = ""
    var pubDate: String = ""
    var thumbnail: String = ""
    var content: String = ""


}