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

  private final String FRONT_CARD_FONT_SIZE = "front_card_font_size";
  private final String BACK_CARD_FONT_SIZE = "back_card_font_size";

  @Inject
  public SettingsManager(SharedPreferences sharedPreferences) {
    this.sharedPreferences = sharedPreferences;
  }

  public void setFrontCardFontSize(int size) {
    sharedPreferences.edit().putInt(FRONT_CARD_FONT_SIZE, size).apply();
  }

  public void setBackCardFontSize(int size) {
    sharedPreferences.edit().putInt(BACK_CARD_FONT_SIZE, size).apply();
  }

  public int getFrontCardFontSize() {
    return sharedPreferences.getInt(FRONT_CARD_FONT_SIZE, 32);
  }

  public int getBackCardFontSize() {
    return sharedPreferences.getInt(BACK_CARD_FONT_SIZE, 32);
  }
}
