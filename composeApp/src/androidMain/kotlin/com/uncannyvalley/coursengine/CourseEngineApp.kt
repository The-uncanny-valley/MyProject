package com.uncannyvalley.coursengine

import android.app.Application
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier

class CourseEngineApp : Application() {

    override fun onCreate() {
        super.onCreate()

        Napier.base(DebugAntilog())
    }
}