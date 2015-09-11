package com.mangoshine.mangocards.ui.presenter;

import com.mangoshine.mangocards.DropboxManager;
import com.mangoshine.mangocards.ui.view.HomeView;

public class HomePresenter {
  private HomeView view;
  private DropboxManager dropboxManager;

  public HomePresenter(HomeView view, DropboxManager dropboxManager) {
    this.view = view;
    this.dropboxManager = dropboxManager;
  }
}
