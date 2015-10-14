package com.mangoshine.mangocards.ui.view;

import com.mangoshine.mangocards.data.Deck;
import java.util.List;

public interface HomeView {
  void showDecks(List<Deck> decks);

  void viewDeck(String name);

  void showLoading();

  void hideLoading();
}
