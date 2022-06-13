package com.example.dictionary.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionary.Models.Definitions;
import com.example.dictionary.R;
import com.example.dictionary.Viewholders.DefinitionViewholder;

import java.util.List;

public class DefinitionAdapter  extends RecyclerView.Adapter<DefinitionViewholder> {
    private Context context;
    private List<Definitions> definitionsList;

    public DefinitionAdapter(Context context, List<Definitions> definitionsList) {
        this.context = context;
        this.definitionsList = definitionsList;
    }

    @NonNull
    @Override
    public DefinitionViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DefinitionViewholder(LayoutInflater.from(context).inflate(R.layout.definitions_list_items,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull DefinitionViewholder holder, int position) {
        holder.textview_definition.setText("Definition:"+ definitionsList.get(position).getDefinition());
        holder.textview_example.setText("Example:" +definitionsList.get(position).getExample());

        //handling data in a list


        StringBuilder  synonym=new StringBuilder();
        StringBuilder antonym=new StringBuilder();
        //append binds the stringBuilder data

         synonym.append(definitionsList.get(position).getSynonyms());
         antonym.append(definitionsList.get(position).getAntonyms());

         holder.textview_synonyms.setText(synonym);
         holder.textview_antonyms.setText(antonym);

         holder.textview_synonyms.setSelected(true);
         holder.textview_antonyms.setSelected(true);








    }

    @Override
    public int getItemCount() {
        return
                definitionsList.size();
    }
}
