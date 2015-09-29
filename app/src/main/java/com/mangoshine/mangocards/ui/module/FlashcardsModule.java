package com.mangoshine.mangocards.ui.module;

import com.mangoshine.mangocards.ui.PerActivity;
import com.mangoshine.mangocards.ui.presenter.FlashcardsPresenter;
import com.mangoshine.mangocards.ui.view.FlashcardsView;
import dagger.Module;
import dagger.Provides;

@Module
public class FlashcardsModule {
  private FlashcardsView flashcardsView;

  public FlashcardsModule(FlashcardsView flashcardsView) {
    this.flashcardsView = flashcardsView;
  }

  @Provides
  @PerActivity
  FlashcardsPresenter provideFlashcardsPresenter() {
    return new FlashcardsPresenter(flashcardsView);
  }
}
