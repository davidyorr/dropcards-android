package com.mangoshine.mangocards.ui.module;

import com.mangoshine.mangocards.DropboxManager;
import com.mangoshine.mangocards.ui.PerActivity;
import com.mangoshine.mangocards.ui.presenter.HomePresenter;
import com.mangoshine.mangocards.ui.view.HomeView;
import dagger.Module;
import dagger.Provides;

@Module
public class HomeModule {
  private HomeView homeView;
  private DropboxManager dropboxManager;

  public HomeModule(HomeView homeView, DropboxManager dropboxManager) {
    this.homeView = homeView;
  }

  @Provides
  @PerActivity
  HomePresenter provideHomePresenter(DropboxManager dropboxManager) {
    return new HomePresenter(homeView, dropboxManager);
  }
}
