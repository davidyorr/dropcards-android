package com.mangoshine.mangocards.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
  String name;
  String content;

  List<Card> cards = new ArrayList<>();

  public Deck(String name) {
    this.name = name;
  }

  public void addCard(Card card) {
    cards.add(card);
  }

  public String getName() {
    return name;
  }

  public Card getCard(int location) {
    return cards.get(location);
  }

  public int size() {
    return cards.size();
  }

  public void shuffle() {
    Collections.shuffle(cards);
  }

  public static Deck parseDeck(String name, String content) throws InvalidFileFormatException {
    Deck deck = new Deck(name);
    try {
      BufferedReader br = new BufferedReader(new StringReader(content));
      for (String line; (line = br.readLine()) != null;) {
        String[] ss = line.split("\t");
        String front = ss[0];
        String back = ss[1];
        deck.addCard(new Card(front, back));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return deck;
  }
}
