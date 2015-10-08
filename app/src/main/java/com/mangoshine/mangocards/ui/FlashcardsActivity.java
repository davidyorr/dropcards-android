package com.mangoshine.mangocards.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.mangoshine.mangocards.DropboxManager;
import com.mangoshine.mangocards.MangocardsApp;
import com.mangoshine.mangocards.R;
import com.mangoshine.mangocards.data.Deck;
import com.mangoshine.mangocards.data.DeckPagerAdapter;
import com.mangoshine.mangocards.ui.module.FlashcardsModule;
import com.mangoshine.mangocards.ui.presenter.FlashcardsPresenter;
import com.mangoshine.mangocards.ui.view.FlashcardsView;
import javax.inject.Inject;

public class FlashcardsActivity extends Activity implements FlashcardsView {

  @Bind(R.id.flashcard_pager_adapter) ViewPager flashcardPagerAdapter;

  @Inject FlashcardsPresenter presenter;
  @Inject DropboxManager dropboxManager;
  DeckPagerAdapter deckPagerAdapter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ((MangocardsApp) getApplication()).component().plus(new FlashcardsModule(this)).inject(this);

    setContentView(R.layout.activity_flashcards);
    ButterKnife.bind(this);

    Intent intent = getIntent();
    String deckName = intent.getStringExtra(DropboxManager.DECK_NAME);
    presenter.initDeck(deckName);
  }

  @Override public void loadDeck(Deck deck) {
    deckPagerAdapter = new DeckPagerAdapter(this, deck, presenter);
    flashcardPagerAdapter.setAdapter(deckPagerAdapter);
  }
}
