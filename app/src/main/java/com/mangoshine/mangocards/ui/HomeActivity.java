package com.mangoshine.mangocards.ui;

import android.app.Activity;
import android.os.Bundle;
import com.mangoshine.mangocards.DropboxManager;
import com.mangoshine.mangocards.MangocardsApp;
import com.mangoshine.mangocards.R;
import com.mangoshine.mangocards.ui.module.HomeModule;
import com.mangoshine.mangocards.ui.presenter.HomePresenter;
import com.mangoshine.mangocards.ui.view.HomeView;
import javax.inject.Inject;

public class HomeActivity extends Activity implements HomeView {

  @Inject HomePresenter presenter;
  @Inject DropboxManager dropboxManager;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ((MangocardsApp) getApplication()).component().plus(new HomeModule(this, dropboxManager)).inject(this);

    setContentView(R.layout.activity_home);
  }
}
