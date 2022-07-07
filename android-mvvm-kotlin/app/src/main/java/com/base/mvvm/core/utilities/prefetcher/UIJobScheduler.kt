package com.base.mvvm.core.utilities.prefetcher

import android.os.Handler
import android.os.Looper
import android.view.Choreographer
import java.util.*

object UIJobScheduler {
    private const val MAX_JOB_TIME_MS: Float = 4f

    private var elapsed = 0L
    private val jobQueue = ArrayDeque<() -> Unit>()
    private val isOverMaxTime get() = elapsed > MAX_JOB_TIME_MS * 1_000_000
    private val handler = Handler(Looper.getMainLooper())

    fun submitJob(job: () -> Unit) {
        jobQueue.add(job)
        if (jobQueue.size == 1) {
            handler.post { processJobs() }
        }
    }

    private fun processJobs() {
        while (!jobQueue.isEmpty() && !isOverMaxTime) {
            val start = System.nanoTime()
            jobQueue.poll().invoke()
            elapsed += System.nanoTime() - start
        }
        if (jobQueue.isEmpty()) {
            elapsed = 0
        } else if (isOverMaxTime) {
            onNextFrame {
                elapsed = 0
                processJobs()
            }
        }
    }

    private fun onNextFrame(callback: () -> Unit) =
        Choreographer.getInstance().postFrameCallback { callback() }
}