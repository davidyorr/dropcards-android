package com.mangoshine.mangocards.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.mangoshine.mangocards.DropboxManager;
import com.mangoshine.mangocards.MangocardsApp;
import com.mangoshine.mangocards.R;
import com.mangoshine.mangocards.ui.module.LoginModule;
import com.mangoshine.mangocards.ui.presenter.LoginPresenter;
import com.mangoshine.mangocards.ui.view.LoginView;
import javax.inject.Inject;

public class LoginActivity extends Activity implements LoginView {

  @Inject LoginPresenter presenter;
  @Inject DropboxManager dropboxManager;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ((MangocardsApp) getApplication()).component().plus(new LoginModule(this)).inject(this);

    setContentView(R.layout.activity_login);
    ButterKnife.bind(this);

    presenter.checkAuthenticated();
  }

  @Override protected void onResume() {
    super.onResume();
    presenter.finishAuthentication();
  }

  @OnClick(R.id.login_button)
  public void onLoginClicked() {
    presenter.doLogin();
  }

  @Override public void loginSuccessful() {
    navigateToHome();
  }

  @Override public void showAuthenticationError() {

  }

  @Override public void navigateToHome() {
    Intent intent = new Intent(this, HomeActivity.class);
    startActivity(intent);
  }

}
