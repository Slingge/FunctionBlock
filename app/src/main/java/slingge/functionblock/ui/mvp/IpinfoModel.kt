package slingge.functionblock.ui.mvp

/**
 * Created by Slingge on 2018/7/17.
 */
class IpinfoModel {

    var code = 0
    var data = IpDataModel()

    class IpDataModel {
        var cpuntry = ""
        var city = ""
        var area = ""
    }

}