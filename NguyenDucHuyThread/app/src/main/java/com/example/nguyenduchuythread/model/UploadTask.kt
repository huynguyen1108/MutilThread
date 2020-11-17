package com.example.nguyenduchuythread.model

class UploadTask : BaseWorker(){
    override fun run() {
        Thread.sleep(delayTime.toLong())
        println(toString())
    }

}