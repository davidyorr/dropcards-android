package com.mangoshine.mangocards.data;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.mangoshine.mangocards.R;

public class DeckPagerAdapter extends PagerAdapter {

  private static LayoutInflater inflater = null;
  private Deck deck;

  public DeckPagerAdapter(Context context, Deck deck) {
    inflater = LayoutInflater.from(context);
    this.deck = deck;
  }

  @Override
  public boolean isViewFromObject(View view, Object object) {
    return view == object;
  }

  @Override
  public int getCount() {
    return deck.size();
  }

  @Override
  public Object instantiateItem(ViewGroup collection, final int position) {
    View view = inflater.inflate(R.layout.flashcard, null);
    final TextView flashcardTv = (TextView)view.findViewById(R.id.flashcard_tv);
    flashcardTv.setText(deck.getCard(position).getContent());

    view.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        Card card = deck.getCard(position);
        card.flip();
        flashcardTv.setText(card.getContent());
      }
    });

    collection.addView(view);
    return view;
  }

  @Override
  public void destroyItem(ViewGroup collection, int position, Object view) {
    collection.removeView((LinearLayout) view);
  }
}
