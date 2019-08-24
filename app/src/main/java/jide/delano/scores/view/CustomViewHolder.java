package jide.delano.scores.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import jide.delano.scores.R;

public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    CardView cardView;
    ImageView matchImage;
    TextView matchTitle, competitionName, matchDate;

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);

        cardView = itemView.findViewById(R.id.cv_match);
        matchImage = itemView.findViewById(R.id.iv_match_thumbnail);
        matchTitle = itemView.findViewById(R.id.tv_title);
        competitionName = itemView.findViewById(R.id.tv_competition_name);
        matchDate = itemView.findViewById(R.id.tv_match_date);

        //Set onclick listener for card view(make sure the main class is implementing View.onclicklistener)
        cardView.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {


    }
}
