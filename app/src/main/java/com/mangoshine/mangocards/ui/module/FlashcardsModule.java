package com.mangoshine.mangocards.ui.module;

import com.mangoshine.mangocards.DropboxManager;
import com.mangoshine.mangocards.SettingsManager;
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
  FlashcardsPresenter provideFlashcardsPresenter(DropboxManager dropboxManager, SettingsManager settingsManager) {
    return new FlashcardsPresenter(flashcardsView, dropboxManager, settingsManager);
  }
}
