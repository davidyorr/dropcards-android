package com.mangoshine.mangocards.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mangoshine.mangocards.R;
import com.mangoshine.mangocards.data.Deck;
import java.util.List;

public class DecksAdapter extends RecyclerView.Adapter<DecksAdapter.ViewHolder> {

  private List<Deck> decks;
  private int rowLayout;

  public DecksAdapter(List<Deck> decks, int rowLayout) {
    this.decks = decks;
    this.rowLayout = rowLayout;
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
    return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(rowLayout, viewGroup, false));
  }

  @Override public void onBindViewHolder(ViewHolder viewHolder, int i) {
    Deck deck = decks.get(i);
    viewHolder.deckName.setText(deck.getName());
  }

  @Override public int getItemCount() {
    return decks == null ? 0 : decks.size();
  }

  public static class ViewHolder extends RecyclerView.ViewHolder {
    public TextView deckName;

    public ViewHolder(View itemView) {
      super(itemView);
      deckName = (TextView) itemView.findViewById(R.id.deck_name);
    }
  }
}
