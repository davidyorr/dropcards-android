package com.mangoshine.mangocards.ui.presenter;

import com.mangoshine.mangocards.DropboxManager;
import com.mangoshine.mangocards.ui.view.LoginView;

public class LoginPresenter {
  private LoginView view;
  private DropboxManager dropboxManager;

  public LoginPresenter(LoginView view, DropboxManager dropboxManager) {
    this.view = view;
    this.dropboxManager = dropboxManager;
  }

  public void doLogin() {
    dropboxManager.startOAuth2Authentication();
  }
}
