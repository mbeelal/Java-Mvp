package com.awok.assignment.di.component;

import android.app.Application;

import com.awok.assignment.AwokApplication;
import com.awok.assignment.di.builder.ActivityBuilder;
import com.awok.assignment.di.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules={AndroidInjectionModule.class, AppModule.class, ActivityBuilder.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();

    }

    void inject(AwokApplication app);
}
