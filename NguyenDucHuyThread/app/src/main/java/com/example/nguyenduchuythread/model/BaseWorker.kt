package com.example.nguyenduchuythread.model

abstract class BaseWorker {
    open var id: Int = 0
    open var name: String? = null
    open var priority: Int = 0
    open var delayTime: Int = 0

    open fun run(){

    }

    override fun toString(): String {
        return """ id:$id name:$name priority:$priority delayTime:$delayTime"""
    }

//    override fun compareTo(other: BaseWorker): Int =
//        other.priority - this.priority

}