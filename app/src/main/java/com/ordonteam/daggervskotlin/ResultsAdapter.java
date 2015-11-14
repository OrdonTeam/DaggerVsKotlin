package com.ordonteam.daggervskotlin;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import static com.ordonteam.daggervskotlin.Utils.inflate;
import static com.ordonteam.daggervskotlin.Utils.loadImage;

public class ResultsAdapter extends RecyclerView.Adapter {
    private SearchResults searchResults;

    public ResultsAdapter(SearchResults searchResults) {
        this.searchResults = searchResults;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ResultViewHolder(inflate(parent, R.layout.result_item));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ResultViewHolder viewHolder = (ResultViewHolder) holder;
        SearchResult searchResult = this.searchResults.items.get(position);
        onBind(viewHolder, searchResult);
    }

    private void onBind(ResultViewHolder viewHolder, SearchResult searchResult) {
        loadImage(viewHolder.avatarView, searchResult.avatar_url);
        viewHolder.loginView.setText(searchResult.login);
        viewHolder.scoreView.setText("Score: " + searchResult.score);
    }

    @Override
    public int getItemCount() {
        return searchResults.items.size();
    }

    class ResultViewHolder extends RecyclerView.ViewHolder {

        final ImageView avatarView;
        final TextView loginView;
        final TextView scoreView;

        public ResultViewHolder(View itemView) {
            super(itemView);
            avatarView = (ImageView) itemView.findViewById(R.id.avatar);
            loginView = (TextView) itemView.findViewById(R.id.login);
            scoreView = (TextView) itemView.findViewById(R.id.score);
        }
    }
}
