package com.mangoshine.mangocards;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.Toast;
import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.android.AndroidAuthSession;
import com.dropbox.client2.session.AppKeyPair;

public class DropboxManager {
  private Context context;

  private final String APP_KEY = "g6dmwrx7xfoiyel";
  private final String APP_SECRET;

  private final String ACCOUNT_PREFS_NAME = "prefs";
  private final String ACCESS_KEY_NAME = "ACCESS_KEY";
  private final String ACCESS_SECRET_NAME = "ACCESS_SECRET";

  DropboxAPI<AndroidAuthSession> dropboxApi;

  public DropboxManager(Context context) {
    this.context = context;
    this.APP_SECRET = context.getString(R.string.app_secret);

    AndroidAuthSession session = buildSession();
    dropboxApi = new DropboxAPI<>(session);
  }

  public void startOAuth2Authentication() {
    dropboxApi.getSession().startOAuth2Authentication(context);
  }

  public void finishAuthentication() {
    AndroidAuthSession session = dropboxApi.getSession();
    if (session.authenticationSuccessful()) {
      try {
        session.finishAuthentication();
        storeAuth(session);
      } catch (IllegalStateException e) {
        Toast.makeText(context, "Couldn't authenticate with Dropbox:" + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
      }
    }
  }

  private void loadAuth(AndroidAuthSession session) {
    SharedPreferences prefs = context.getSharedPreferences(ACCOUNT_PREFS_NAME, 0);
    String key = prefs.getString(ACCESS_KEY_NAME, null);
    String secret = prefs.getString(ACCESS_SECRET_NAME, null);
    if (key == null || secret == null || key.length() == 0 || secret.length() == 0) return;

    session.setOAuth2AccessToken(secret);
  }

  private void storeAuth(AndroidAuthSession session) {
    String oauth2AccessToken = session.getOAuth2AccessToken();
    if (oauth2AccessToken != null) {
      SharedPreferences prefs = context.getSharedPreferences(ACCOUNT_PREFS_NAME, 0);
      Editor edit = prefs.edit();
      edit.putString(ACCESS_KEY_NAME, "oauth2:");
      edit.putString(ACCESS_SECRET_NAME, oauth2AccessToken);
      edit.commit();
      return;
    }
  }

  private void clearKeys() {
    SharedPreferences prefs = context.getSharedPreferences(ACCOUNT_PREFS_NAME, 0);
    Editor edit = prefs.edit();
    edit.clear();
    edit.commit();
  }

  private AndroidAuthSession buildSession() {
    AppKeyPair appKeyPair = new AppKeyPair(APP_KEY, APP_SECRET);

    AndroidAuthSession session = new AndroidAuthSession(appKeyPair);
    loadAuth(session);
    return session;
  }
}
