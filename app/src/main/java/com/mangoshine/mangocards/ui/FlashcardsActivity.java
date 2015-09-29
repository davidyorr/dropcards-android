package com.mangoshine.mangocards.ui;

import android.app.Activity;
import android.os.Bundle;
import com.mangoshine.mangocards.MangocardsApp;
import com.mangoshine.mangocards.R;
import com.mangoshine.mangocards.ui.module.FlashcardsModule;
import com.mangoshine.mangocards.ui.presenter.FlashcardsPresenter;
import com.mangoshine.mangocards.ui.view.FlashcardsView;
import javax.inject.Inject;

public class FlashcardsActivity extends Activity implements FlashcardsView {

  @Inject FlashcardsPresenter presenter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ((MangocardsApp) getApplication()).component().plus(new FlashcardsModule(this)).inject(this);

    setContentView(R.layout.activity_flashcards);
  }
}
