package com.mangoshine.mangocards.ui.component;

import com.mangoshine.mangocards.ui.LoginActivity;
import com.mangoshine.mangocards.ui.PerActivity;
import com.mangoshine.mangocards.ui.module.LoginModule;
import dagger.Subcomponent;

@PerActivity
@Subcomponent(
    modules = LoginModule.class
)
public interface LoginComponent {
  void inject(LoginActivity activity);
}
