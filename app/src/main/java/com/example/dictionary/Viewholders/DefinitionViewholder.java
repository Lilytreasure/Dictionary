package com.example.dictionary.Viewholders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionary.R;

public class DefinitionViewholder  extends RecyclerView.ViewHolder {

    public TextView  textview_definition,textview_example,textview_synonyms,textview_antonyms;

    public DefinitionViewholder(@NonNull View itemView) {
        super(itemView);
        textview_definition=itemView.findViewById(R.id.textview_definition);
        textview_example=itemView.findViewById(R.id.textview_example);
        textview_synonyms=itemView.findViewById(R.id.textview_synonyms);
        textview_antonyms=itemView.findViewById(R.id.textview_antonyms);


    }
}
