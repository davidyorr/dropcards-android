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
import com.mangoshine.mangocards.SettingsManager;
import com.mangoshine.mangocards.ui.presenter.FlashcardsPresenter;
import timber.log.Timber;

public class DeckPagerAdapter extends PagerAdapter {

  private static LayoutInflater inflater = null;
  private Deck deck;
  private FlashcardsPresenter presenter;
  private SettingsManager settingsManager;

  public DeckPagerAdapter(Context context, Deck deck, FlashcardsPresenter presenter, SettingsManager settingsManager) {
    inflater = LayoutInflater.from(context);
    this.deck = deck;
    this.presenter = presenter;
    this.settingsManager = settingsManager;
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
    final Card card = deck.getCard(position);
    final TextView flashcardFrontTv = (TextView)view.findViewById(R.id.flashcard_front_tv);
    final TextView flashcardBackTv = (TextView)view.findViewById(R.id.flashcard_back_tv);
    refreshFontSize(flashcardFrontTv, flashcardBackTv);
    flashcardFrontTv.setText(card.front());
    flashcardBackTv.setText(card.back());

    if (card.getCurrentSide() == Side.FRONT) {
      flashcardFrontTv.setVisibility(View.VISIBLE);
      flashcardBackTv.setVisibility(View.GONE);
    } else {
      flashcardFrontTv.setVisibility(View.GONE);
      flashcardBackTv.setVisibility(View.VISIBLE);
    }

    view.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        presenter.flipCard(position);
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

        dialog.findViewById(R.id.popup_increase_font_btn).setOnClickListener(new View.OnClickListener() {
          @Override public void onClick(View v) {
            presenter.increaseFontSize(card.getCurrentSide());
            refreshFontSize(flashcardFrontTv, flashcardBackTv);
          }
        });

        dialog.findViewById(R.id.popup_decrease_font_btn).setOnClickListener(new View.OnClickListener() {
          @Override public void onClick(View v) {
            presenter.decreseFontSize(card.getCurrentSide());
            refreshFontSize(flashcardFrontTv, flashcardBackTv);
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

  @Override
  public int getItemPosition(Object object) {
    return POSITION_NONE;
  }

  @Override public void startUpdate(ViewGroup container) {
    super.startUpdate(container);
    Timber.d("startUpdate()");
    for (int i = 0; i < container.getChildCount(); i++) {
      View v = container.getChildAt(i);
      refreshFontSize((TextView) v.findViewById(R.id.flashcard_front_tv), (TextView) v.findViewById(R.id.flashcard_back_tv));
    }
  }

  public void refreshFontSize(TextView flashcardFrontTv, TextView flashcardBackTv) {
    flashcardFrontTv.setTextSize(settingsManager.getFrontCardFontSize());
    flashcardBackTv.setTextSize(settingsManager.getBackCardFontSize());
  }
}
