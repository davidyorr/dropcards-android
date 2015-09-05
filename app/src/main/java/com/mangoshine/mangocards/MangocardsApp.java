package com.mangoshine.mangocards;

import android.app.Application;

public class MangocardsApp extends Application {
  private MangocardsAppComponent appComponent;

  @Override public void onCreate() {
    super.onCreate();

    appComponent = DaggerMangocardsAppComponent.builder()
        .mangocardsModule(new MangocardsModule(this))
        .build();
  }

  public MangocardsAppComponent component() {
    return appComponent;
  }
}
