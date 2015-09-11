package com.mangoshine.mangocards.ui.component;

import com.mangoshine.mangocards.ui.HomeActivity;
import com.mangoshine.mangocards.ui.PerActivity;
import com.mangoshine.mangocards.ui.module.HomeModule;
import dagger.Subcomponent;

@PerActivity
@Subcomponent(
    modules = HomeModule.class
)
public interface HomeComponent {
  void inject(HomeActivity activity);
}
