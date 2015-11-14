package com.ordonteam.daggervskotlin;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import static com.ordonteam.daggervskotlin.Utils.inflate;

public class EmptyAdapter extends RecyclerView.Adapter {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new EmptyAdapterViewHolder(inflate(parent, R.layout.empty_item));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class EmptyAdapterViewHolder extends RecyclerView.ViewHolder {

        public EmptyAdapterViewHolder(View itemView) {
            super(itemView);
        }
    }
}
