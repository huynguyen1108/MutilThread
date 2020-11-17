package com.example.nguyenduchuythread.model

class SendRequestTask : BaseWorker() {
    override fun run() {
        Thread.sleep(delayTime.toLong())
        println(toString())
    }
}