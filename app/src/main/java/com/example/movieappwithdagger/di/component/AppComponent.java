package com.example.movieappwithdagger.di.component;

import android.app.Application;

import com.example.movieappwithdagger.MyApplication;
import com.example.movieappwithdagger.di.module.AppModule;
import com.example.movieappwithdagger.di.module.ViewModelModule;
import com.example.movieappwithdagger.di.module.ViewModelFactoryModule;
import com.example.movieappwithdagger.di.builder.ActivityBuilderModule;
import com.example.movieappwithdagger.ui.movie.FragmentBuilder;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component( modules =
        {AndroidSupportInjectionModule.class,
                ActivityBuilderModule.class,
                FragmentBuilder.class,
                AppModule.class,
                ViewModelFactoryModule.class,
           //     ApiModule.class
                ViewModelModule.class,


        }

)
    public interface AppComponent extends AndroidInjector<MyApplication> {


    @Component.Builder
    interface Builder{

        @BindsInstance
        Builder application(Application application);

        AppComponent build();

    }

}
