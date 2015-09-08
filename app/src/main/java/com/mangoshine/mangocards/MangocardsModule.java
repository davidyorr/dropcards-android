package com.mangoshine.mangocards;

import dagger.Module;
import dagger.Provides;

@Module
public class MangocardsModule {
  private final MangocardsApp app;

  public MangocardsModule(MangocardsApp app) {
    this.app = app;
  }

  @Provides MangocardsApp provideMangocardsApp() {
    return app;
  }

  @Provides DropboxManager provideAppSecret() {
    return new DropboxManager(app);
  }
}
