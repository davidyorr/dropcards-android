package com.mangoshine.mangocards;

import android.app.Application;
import timber.log.Timber;

public class MangocardsApp extends Application {
  private MangocardsAppComponent appComponent;

  @Override public void onCreate() {
    super.onCreate();

    if (BuildConfig.DEBUG) {
      Timber.plant(new Timber.DebugTree());
    }

    appComponent = DaggerMangocardsAppComponent.builder()
        .mangocardsModule(new MangocardsModule(this))
        .build();
  }

  public MangocardsAppComponent component() {
    return appComponent;
  }
}
