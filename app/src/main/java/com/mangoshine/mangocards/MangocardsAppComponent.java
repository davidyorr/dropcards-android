package com.mangoshine.mangocards;

import com.mangoshine.mangocards.ui.component.FlashcardsComponent;
import com.mangoshine.mangocards.ui.component.HomeComponent;
import com.mangoshine.mangocards.ui.component.LoginComponent;
import com.mangoshine.mangocards.ui.module.FlashcardsModule;
import com.mangoshine.mangocards.ui.module.HomeModule;
import com.mangoshine.mangocards.ui.module.LoginModule;
import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = MangocardsModule.class)
public interface MangocardsAppComponent {
  LoginComponent plus(LoginModule loginModule);
  HomeComponent plus(HomeModule homeModule);
  FlashcardsComponent plus(FlashcardsModule flashcardsModule);
}
