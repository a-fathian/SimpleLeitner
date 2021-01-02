package fathian.ali.simpleLeitner

import android.content.Context
import androidx.multidex.MultiDexApplication
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import fathian.ali.simpleLeitner.di.DaggerAppComponent
import timber.log.Timber
import javax.inject.Inject

open class App : MultiDexApplication(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        initDagger()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    open fun initDagger() {
        DaggerAppComponent.builder().build().inject(this)
    }

    companion object {
        lateinit var context: Context
    }
}