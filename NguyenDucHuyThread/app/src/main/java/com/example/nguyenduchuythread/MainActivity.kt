package com.example.nguyenduchuythread

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.nguyenduchuythread.model.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listTask = mutableListOf<BaseWorker>()

        val executor: ExecutorService = Executors.newFixedThreadPool(NUM_OF_THREAD)
        for (i in 0..50){
            var task: BaseWorker
            when (i) {
                in 0..10 -> {
                    task = DoActionTask()
                    task.id = i
                    task.name = task.javaClass.name
                    task.delayTime = Random.nextInt(0, 1000)
                    task.priority = Random.nextInt(0, 50)
                }
                in 11..20 -> {
                    task = GetDataTask()
                    task.id = i
                    task.name = task.javaClass.name
                    task.delayTime = Random.nextInt(0, 1000)
                    task.priority = Random.nextInt(0, 50)
                }
                in 21..30 -> {
                    task = InsertDataLocalTask()
                    task.id = i
                    task.name = task.javaClass.name
                    task.delayTime = Random.nextInt(0, 1000)
                    task.priority = Random.nextInt(0, 50)
                }
                in 31..40 -> {
                    task = SendRequestTask()
                    task.id = i
                    task.name = task.javaClass.name
                    task.delayTime = Random.nextInt(0, 1000)
                    task.priority = Random.nextInt(0, 50)
                }
                else -> {
                    task = UploadTask()
                    task.id = i
                    task.name = task.javaClass.name
                    task.delayTime = Random.nextInt(0, 1000)
                    task.priority = Random.nextInt(0, 50)
                }
            }
            listTask.add(task)
        }

        listTask.sortByDescending { it.priority }

        for (i in 0 until listTask.size){
            executor.execute { listTask[i].run() }
        }
        executor.shutdown()
    }

    companion object{
        const val NUM_OF_THREAD = 5
    }
}