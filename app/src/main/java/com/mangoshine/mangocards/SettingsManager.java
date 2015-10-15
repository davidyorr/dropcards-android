package com.mangoshine.mangocards;

import android.content.SharedPreferences;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 *
 */
@Singleton
public class SettingsManager {

  private SharedPreferences sharedPreferences;

  @Inject
  public SettingsManager(SharedPreferences sharedPreferences) {
    this.sharedPreferences = sharedPreferences;
  }
}
