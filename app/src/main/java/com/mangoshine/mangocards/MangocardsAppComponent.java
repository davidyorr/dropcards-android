package com.mangoshine.mangocards;

import com.mangoshine.mangocards.ui.component.LoginComponent;
import com.mangoshine.mangocards.ui.module.LoginModule;
import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = MangocardsModule.class)
public interface MangocardsAppComponent {
  LoginComponent plus(LoginModule loginModule);
}
