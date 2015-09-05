package com.mangoshine.mangocards.ui;

import android.app.Activity;
import android.os.Bundle;
import butterknife.ButterKnife;
import com.mangoshine.mangocards.R;
import com.mangoshine.mangocards.ui.view.LoginView;

public class LoginActivity extends Activity implements LoginView {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_login);
    ButterKnife.bind(this);
  }

  @Override public void loginSuccessful() {

  }

  @Override public void showProgress() {

  }

  @Override public void hideProgress() {

  }

  @Override public void showAuthenticationError() {

  }

  @Override public void navigateToDashboard() {

  }

}
