package com.kmcbookingav.av.dev.api;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by CodeSyaona on 11/07/2017.
 */

public interface ApiServiceUser {

    @POST("login")
    @FormUrlEncoded
    Call<ApiResponseUser> userLogin(@Field("username") String username, @Field("password") String password);


}
