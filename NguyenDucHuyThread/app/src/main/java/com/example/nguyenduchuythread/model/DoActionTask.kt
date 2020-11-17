package com.example.nguyenduchuythread.model

class DoActionTask : BaseWorker() {
    override fun run() {
        Thread.sleep(delayTime.toLong())
        println(toString())
    }
}