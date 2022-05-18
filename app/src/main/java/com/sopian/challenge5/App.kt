package com.sopian.challenge5

import android.app.Application
import com.google.android.material.color.DynamicColors
import com.sopian.challenge5.di.app.AppComponent
import com.sopian.challenge5.di.app.DaggerAppComponent
import com.sopian.challenge5.di.core.CoreComponent
import com.sopian.challenge5.di.core.DaggerCoreComponent

open class App : Application() {

    private val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.factory().create(applicationContext)
    }

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(coreComponent)
    }

    override fun onCreate() {
        super.onCreate()
        DynamicColors.applyToActivitiesIfAvailable(this)
    }

    override fun onLowMemory() {
        super.onLowMemory()
        GlideApp.get(this).clearMemory()
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        GlideApp.get(this).trimMemory(level)
    }
}