package com.mangoshine.mangocards;

import com.mangoshine.mangocards.ui.LoginActivity;
import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = MangocardsModule.class)
public interface MangocardsAppComponent {
  void inject(LoginActivity loginActivity);
}
