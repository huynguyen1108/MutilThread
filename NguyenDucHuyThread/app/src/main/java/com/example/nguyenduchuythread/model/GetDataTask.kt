package com.example.nguyenduchuythread.model

class GetDataTask : BaseWorker() {
    override fun run() {
        Thread.sleep(delayTime.toLong())
        println(toString())
    }
}