package com.mangoshine.mangocards.ui.presenter;

import android.view.View;
import android.widget.TextView;
import com.mangoshine.mangocards.DropboxManager;
import com.mangoshine.mangocards.data.Deck;
import com.mangoshine.mangocards.ui.DecksAdapter;
import com.mangoshine.mangocards.ui.view.HomeView;
import java.util.List;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class HomePresenter {
  private HomeView view;
  private DropboxManager dropboxManager;
  private List<Deck> decks;
  private DecksAdapter.ViewHolder.ClickListener deckClickListener = new DecksAdapter.ViewHolder.ClickListener() {
    @Override public void onClick(View v, TextView textView) {
      view.viewDeck(textView.getText().toString());
    }
  };

  private Subscriber<List<Deck>> subscriber;

  public HomePresenter(HomeView view, DropboxManager dropboxManager) {
    this.view = view;
    this.dropboxManager = dropboxManager;
  }

  public void populateCardView() {
    subscriber = new Subscriber<List<Deck>>() {
      @Override public void onCompleted() {
        onDeckNamesFetched();
      }

      @Override public void onError(Throwable e) {
        e.printStackTrace();
      }

      @Override public void onNext(List<Deck> decks) {
        HomePresenter.this.decks = decks;
      }
    };

    dropboxManager.getDecks()
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(subscriber);
  }

  public void onDeckNamesFetched() {
    view.showDecks(decks);
  }

  public DecksAdapter.ViewHolder.ClickListener getDeckClickListener() {
    return deckClickListener;
  }
}
