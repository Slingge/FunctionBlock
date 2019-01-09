package slingge.functionblock.retrofitNet


/**
 * Created by Slingge on 2019/1/9
 */
interface SingleObserverInterface<T> {

    fun <T> onSuccess(response: T)
}