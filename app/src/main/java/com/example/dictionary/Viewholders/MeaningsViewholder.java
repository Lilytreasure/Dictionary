package com.example.dictionary.Viewholders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionary.R;

public class MeaningsViewholder  extends RecyclerView.ViewHolder {
    public TextView textview_partsOfSpeech;
    public RecyclerView recycler_definitions;

    public MeaningsViewholder(@NonNull View itemView) {
        super(itemView);
        textview_partsOfSpeech=itemView.findViewById(R.id.textview_partsOfSpeech);
        recycler_definitions=itemView.findViewById(R.id.recycler_definitions);
    }
}
