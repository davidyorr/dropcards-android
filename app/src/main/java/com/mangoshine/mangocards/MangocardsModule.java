package com.mangoshine.mangocards;

import android.content.Context;
import android.content.SharedPreferences;
import dagger.Module;
import dagger.Provides;

@Module
public class MangocardsModule {
  private final MangocardsApp app;

  private static final String PREFS = "mangocards_prefs";

  public MangocardsModule(MangocardsApp app) {
    this.app = app;
  }

  @Provides MangocardsApp provideMangocardsApp() {
    return app;
  }

  @Provides DropboxManager provideDropboxManager() {
    return new DropboxManager(app);
  }

  @Provides SharedPreferences provideSharedPreferences() {
    return app.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
  }
}
