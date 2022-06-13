package com.example.dictionary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dictionary.Adapters.MeaningAdapter;
import com.example.dictionary.Adapters.PhoneticsAdapter;
import com.example.dictionary.Models.ApiResponse;

public class MainActivity extends AppCompatActivity {
    SearchView search_view;
    TextView textView_word;
    RecyclerView Recyclerview_phonetics,Recyclerview_meanings;
    ProgressDialog progressDialog;
    PhoneticsAdapter phoneticsAdapter;
    MeaningAdapter meaningAdapter;
    //Adapter phoneticsAdapter,meaningAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        search_view=findViewById(R.id.search_view);
        textView_word=findViewById(R.id.textview_word);
        Recyclerview_phonetics=findViewById(R.id.Recyclerview_phonetics);
      //  Recyclerview_phonetics.setAdapter(phoneticsAdapter);

        Recyclerview_meanings=findViewById(R.id.Recyclerview_meanings);
       // Recyclerview_meanings.setAdapter(meaningAdapter);
        progressDialog=new ProgressDialog(this);
        //loads this query by default  every time the application is run
        progressDialog.setTitle("Loading data...");
        progressDialog.show();
        RequestManager manager=new RequestManager(MainActivity.this);
        manager.getWordMeaning(listner,"hello");

        //handles the query submitted by the user
        search_view.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                progressDialog.setTitle("Fetching response for: "+ query);
                progressDialog.show();

                RequestManager manager=new RequestManager(MainActivity.this);
                manager.getWordMeaning(listner,query);


                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

    }
    private final OnfetchDataListner listner=new OnfetchDataListner() {
        @Override
        public void onFetchData(ApiResponse apiResponse, String message) {
            progressDialog.dismiss();
            if(apiResponse==null){
                Toast.makeText(MainActivity.this, "Data not found!!", Toast.LENGTH_SHORT).show();
                return;

            }
            showData(apiResponse);

        }

        @Override
        public void onError(String message) {
            progressDialog.dismiss();
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();


        }
    };

    private void showData(ApiResponse apiResponse) {
        textView_word.setText("Word:" + apiResponse.getWord());
        Recyclerview_phonetics.setHasFixedSize(true);

        Recyclerview_phonetics.setLayoutManager(new GridLayoutManager(this,1));
        phoneticsAdapter=new PhoneticsAdapter(this,apiResponse.getPhonetics());
        Recyclerview_phonetics.setAdapter(phoneticsAdapter);



         Recyclerview_meanings.setHasFixedSize(true);
         Recyclerview_meanings.setLayoutManager(new GridLayoutManager(this,1));
         meaningAdapter=new MeaningAdapter(this,apiResponse.getMeanings());
         Recyclerview_meanings.setAdapter(meaningAdapter);


    }
}