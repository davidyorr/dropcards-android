package com.mangoshine.mangocards.ui.component;

import com.mangoshine.mangocards.ui.FlashcardsActivity;
import com.mangoshine.mangocards.ui.PerActivity;
import com.mangoshine.mangocards.ui.module.FlashcardsModule;
import dagger.Subcomponent;

@PerActivity
@Subcomponent(
    modules = FlashcardsModule.class
)
public interface FlashcardsComponent {
  void inject(FlashcardsActivity activity);
}
