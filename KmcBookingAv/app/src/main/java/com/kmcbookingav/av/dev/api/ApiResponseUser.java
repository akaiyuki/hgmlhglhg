package com.kmcbookingav.av.dev.api;

import com.google.gson.annotations.SerializedName;
import com.kmcbookingav.av.dev.object.UserObject;

/**
 * Created by CodeSyaona on 11/07/2017.
 */

public class ApiResponseUser {

    @SerializedName("msg")
    private String message;
    @SerializedName("data")
    private UserObject data;
    @SerializedName("code")
    private int status;

    public UserObject getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

}
