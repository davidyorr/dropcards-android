package com.mangoshine.mangocards.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.mangoshine.mangocards.DropboxManager;
import com.mangoshine.mangocards.MangocardsApp;
import com.mangoshine.mangocards.R;
import com.mangoshine.mangocards.ui.module.HomeModule;
import com.mangoshine.mangocards.ui.presenter.HomePresenter;
import com.mangoshine.mangocards.ui.view.HomeView;
import javax.inject.Inject;

public class HomeActivity extends Activity implements HomeView {

  @Bind(R.id.toolbar) Toolbar toolbar;
  @Bind(R.id.main_drawer_layout) DrawerLayout drawerLayout;

  @Inject HomePresenter presenter;
  @Inject DropboxManager dropboxManager;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ((MangocardsApp) getApplication()).component().plus(new HomeModule(this, dropboxManager)).inject(this);

    setContentView(R.layout.activity_home);
    ButterKnife.bind(this);

    toolbar.setNavigationOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        drawerLayout.openDrawer(GravityCompat.START);
      }
    });
  }
}
