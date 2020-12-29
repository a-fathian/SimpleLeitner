package fathian.ali.lightnerforlearningandroid.di

import dagger.Component
import dagger.android.AndroidInjectionModule
import fathian.ali.lightnerforlearningandroid.App
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class
    ]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        fun build(): AppComponent
    }

    fun inject(app: App)
}
