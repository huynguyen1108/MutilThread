package com.example.nguyenduchuythread.model

class InsertDataLocalTask : BaseWorker() {
    override fun run() {
        Thread.sleep(delayTime.toLong())
        println(toString())
    }
}