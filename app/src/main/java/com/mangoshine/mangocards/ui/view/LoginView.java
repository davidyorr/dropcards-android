package com.mangoshine.mangocards.ui.view;

public interface LoginView {
  void loginSuccessful();

  void showProgress();

  void hideProgress();

  void showAuthenticationError();

  void navigateToDashboard();
}
