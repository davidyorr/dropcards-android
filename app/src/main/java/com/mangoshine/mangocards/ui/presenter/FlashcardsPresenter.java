package com.mangoshine.mangocards.ui.presenter;

import com.mangoshine.mangocards.DropboxManager;
import com.mangoshine.mangocards.SettingsManager;
import com.mangoshine.mangocards.data.Deck;
import com.mangoshine.mangocards.ui.view.FlashcardsView;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class FlashcardsPresenter {
  private FlashcardsView view;
  private DropboxManager dropboxManager;
  private SettingsManager settingsManager;
  Deck deck;

  private Subscriber<Deck> subscriber;

  public FlashcardsPresenter(FlashcardsView view,  DropboxManager dropboxManager, SettingsManager settingsManager) {
    this.view = view;
    this.dropboxManager = dropboxManager;
    this.settingsManager = settingsManager;
  }

  public void initDeck(String name) {
    subscriber = new Subscriber<Deck>() {
      @Override public void onCompleted() {
        onDeckFetched();
      }

      @Override public void onError(Throwable e) {
        e.printStackTrace();
      }

      @Override public void onNext(Deck deck) {
        FlashcardsPresenter.this.deck = deck;
      }
    };

    dropboxManager.getDeck(name)
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(subscriber);
  }

  public void onDeckFetched() {
    view.loadDeck(deck);
  }

  public void shuffleDeck() {
    deck.shuffle();
    view.loadDeck(deck);
  }

  public void flipCard(int position) {
    deck.getCard(position).flip();
    view.onCardFlipped();
  }
}
