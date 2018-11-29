package com.project.taewon.sampledagger.di

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Global executor pools for the whole application.
 *
 */
@Singleton
open class AppExecutors(
    private val mainThread: Executor
) {
    @Inject
    constructor() : this(
        MainThreadExecutor()
    )

    fun mainThread(): Executor {
        return mainThread
    }

    private class MainThreadExecutor : Executor {
        private val mainThreadHandler = Handler(Looper.getMainLooper())
        override fun execute(command: Runnable) {
            mainThreadHandler.post(command)
        }
    }
}
