package com.example.dictionary;

import com.example.dictionary.Models.ApiResponse;

public interface OnfetchDataListner {
    void onFetchData(ApiResponse apiResponse,String message);
    void onError(String message);




}
