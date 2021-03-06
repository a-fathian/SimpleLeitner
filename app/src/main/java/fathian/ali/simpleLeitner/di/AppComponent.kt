package fathian.ali.simpleLeitner.di

import dagger.Component
import dagger.android.AndroidInjectionModule
import fathian.ali.simpleLeitner.App
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityModuleBuilder::class,
        AppModule::class,
        ViewModelModule::class,
        DataModule::class
    ]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        fun build(): AppComponent
    }

    fun inject(app: App)
}
