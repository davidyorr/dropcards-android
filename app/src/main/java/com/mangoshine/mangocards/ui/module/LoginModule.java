package com.mangoshine.mangocards.ui.module;

import com.mangoshine.mangocards.DropboxManager;
import com.mangoshine.mangocards.ui.PerActivity;
import com.mangoshine.mangocards.ui.presenter.LoginPresenter;
import com.mangoshine.mangocards.ui.view.LoginView;
import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {
  private LoginView loginView;

  public LoginModule(LoginView loginView) {
    this.loginView = loginView;
  }

  @Provides
  @PerActivity
  LoginPresenter provideLoginPresenter(DropboxManager dropboxManager) {
    return new LoginPresenter(loginView, dropboxManager);
  }
}
