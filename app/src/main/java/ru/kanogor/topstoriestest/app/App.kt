package ru.kanogor.topstoriestest.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import ru.kanogor.topstoriestest.di.appModule
import ru.kanogor.topstoriestest.di.dataModule
import ru.kanogor.topstoriestest.di.domainModule

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            androidLogger(Level.DEBUG)
            modules(listOf(appModule, domainModule, dataModule))
        }

    }

}