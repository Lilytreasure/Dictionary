package com.example.dictionary.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionary.Models.Meanings;
import com.example.dictionary.R;
import com.example.dictionary.Viewholders.MeaningsViewholder;

import java.util.List;

public class MeaningAdapter  extends RecyclerView.Adapter<MeaningsViewholder> {
    private Context context;
    private List<Meanings> meaningsList;
    private DefinitionAdapter definitionAdapter;


    public MeaningAdapter(Context context, List<Meanings> meaningsList) {
        this.context = context;
        this.meaningsList = meaningsList;
    }

    @NonNull
    @Override
    public MeaningsViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MeaningsViewholder(LayoutInflater.from(context).inflate(R.layout.meanings_layout_items,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull MeaningsViewholder holder, int position) {
        holder.textview_partsOfSpeech.setText("parts of speech:"+ meaningsList.get(position).getPartOfSpeech());
        holder.recycler_definitions.setHasFixedSize(true);
       holder.recycler_definitions.setLayoutManager(new GridLayoutManager(context,1));
//
       DefinitionAdapter definitionAdapter=new DefinitionAdapter(context, meaningsList.get(position).getDefinitions());
        holder.recycler_definitions.setAdapter(definitionAdapter);
//



    }

    @Override
    public int getItemCount() {
        //previous return
        return meaningsList.size();
        //return meaningsList.size();
    }
}
