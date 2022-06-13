package com.example.dictionary;

import android.content.Context;
import android.widget.Toast;

import com.example.dictionary.Api.CallDictionary;
import com.example.dictionary.Models.ApiResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RequestManager {
    Context context;
    Retrofit retrofit=new Retrofit.Builder()
            .baseUrl("https://api.dictionaryapi.dev/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public RequestManager(Context context) {
        this.context = context;
    }

    public void getWordMeaning(OnfetchDataListner listner,String word){
        CallDictionary callDictionary=retrofit.create(CallDictionary.class);
        Call<List<ApiResponse>> call= callDictionary.callMeanings(word);
        try {
            call.enqueue(new Callback<List<ApiResponse>>() {
                @Override
                public void onResponse(Call<List<ApiResponse>> call, Response<List<ApiResponse>> response) {
                    if(!response.isSuccessful()){
                        Toast.makeText(context, "Error!", Toast.LENGTH_LONG).show();
                        return;
                    }
                    listner.onFetchData(response.body().get(0),response.message());

                }

                @Override
                public void onFailure(Call<List<ApiResponse>> call, Throwable t) {
                    listner.onError("Request failed!!");

                }
            });
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(context, "An error occurred!!", Toast.LENGTH_SHORT).show();
        }

    }

}
