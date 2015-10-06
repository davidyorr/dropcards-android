package com.mangoshine.mangocards.data;

public class Card {
  String front, back;

  Side currentSide = Side.FRONT;

  public Card(String front, String back) {
    this.front = front;
    this.back = back;
  }

  public String getContent() {
    return currentSide == Side.FRONT ? front : back;
  }

  public void flip() {
    currentSide = currentSide == Side.FRONT ? Side.BACK : Side.FRONT;
  }
}
