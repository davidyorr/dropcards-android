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
  private ViewHolder.ClickListener clickListener;

  public DecksAdapter(List<Deck> decks, int rowLayout, ViewHolder.ClickListener clickListener) {
    this.decks = decks;
    this.rowLayout = rowLayout;
    this.clickListener = clickListener;
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
    return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(rowLayout, viewGroup, false), clickListener);
  }

  @Override public void onBindViewHolder(ViewHolder viewHolder, int i) {
    Deck deck = decks.get(i);
    viewHolder.textViewDeckName.setText(deck.getName());
  }

  @Override public int getItemCount() {
    return decks == null ? 0 : decks.size();
  }

  public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView textViewDeckName;
    public ClickListener clickListener;

    public ViewHolder(View itemView, ClickListener clickListener) {
      super(itemView);
      this.textViewDeckName = (TextView) itemView.findViewById(R.id.deck_name);
      this.clickListener = clickListener;
      itemView.setOnClickListener(this);
    }

    @Override public void onClick(View view) {
      clickListener.onClick(view, textViewDeckName);
    }

    public interface ClickListener {
      void onClick(View v, TextView textView);
    }
  }
}
