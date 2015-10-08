package com.mangoshine.mangocards.data;

import android.app.Dialog;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.mangoshine.mangocards.R;
import com.mangoshine.mangocards.ui.presenter.FlashcardsPresenter;

public class DeckPagerAdapter extends PagerAdapter {

  private static LayoutInflater inflater = null;
  private Deck deck;
  private FlashcardsPresenter presenter;

  public DeckPagerAdapter(Context context, Deck deck, FlashcardsPresenter presenter) {
    inflater = LayoutInflater.from(context);
    this.deck = deck;
    this.presenter = presenter;
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

    view.setOnLongClickListener(new View.OnLongClickListener() {
      @Override public boolean onLongClick(View v) {
        final Dialog dialog = new Dialog(v.getContext(), android.R.style.Theme_Translucent_NoTitleBar);
        dialog.setContentView(R.layout.flashcard_popup_settings);
        dialog.setCanceledOnTouchOutside(true);
        Window window = dialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        window.setLayout(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);

        dialog.findViewById(R.id.popup_shuffle_btn).setOnClickListener(new View.OnClickListener() {
          @Override public void onClick(View v) {
            presenter.shuffleDeck();
            dialog.hide();
          }
        });

        dialog.show();
        return true;
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
