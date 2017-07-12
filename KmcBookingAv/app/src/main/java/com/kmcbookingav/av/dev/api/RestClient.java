package com.kmcbookingav.av.dev.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kmcbookingav.av.dev.core.KConfiguration;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by CodeSyaona on 11/07/2017.
 */

public class RestClient {

    private Retrofit retrofit;


    // Api Service Classes String
    public static String colorApiService = "ApiServiceColor.class";
    public static String userApiService = "ApiServiceUser.class";
    public static String bookApiService = "ApiServiceBooking.class";

    // Api Selected Service
    private ApiServiceUser apiServiceUser;


    public RestClient(String className)
    {

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSS'Z'")
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(KConfiguration.liveUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        getApiRestService(className);

    }

//    public static String getAVConfiguration(){
//        if (AVConfiguration.Staging){
//            return AVConfiguration.testBaseUrl;
//        } else {
//            return AVConfiguration.liveBaseUrl;
//        }
//    }

    public ApiServiceUser getApiServiceUser(){ return apiServiceUser; }


    private void getApiRestService(String apiServiceSelected){
        if (apiServiceSelected.equalsIgnoreCase(colorApiService)){
//            apiServiceColor = retrofit.create(ApiServiceColor.class);
        } else if (apiServiceSelected.equalsIgnoreCase(userApiService)){
            apiServiceUser = retrofit.create(ApiServiceUser.class);
        } else if (apiServiceSelected.equalsIgnoreCase(bookApiService)){
//            apiServiceBook = retrofit.create(ApiServiceBooking.class);
        }
    }


}
