package com.kmcbookingav.av.dev.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.kmcbookingav.av.dev.R;
import com.kmcbookingav.av.dev.activity.MainActivity;
import com.kmcbookingav.av.dev.api.ApiResponseUser;
import com.kmcbookingav.av.dev.api.RestClient;
import com.kmcbookingav.av.dev.core.AppController;
import com.kmcbookingav.av.dev.core.KEngine;
import com.kmcbookingav.av.dev.core.KSharedPreferences;
import com.kmcbookingav.av.dev.object.SharedPreferencesObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    @BindView(R.id.editusername)
    EditText editUsername;
    @BindView(R.id.editpassword)
    EditText editPassword;
    @BindView(R.id.btnlogin)
    Button btnLogin;


    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this,view);

        return view;
    }

    @OnClick(R.id.btnlogin)
    public void onClickLogin(){

        if (editUsername.getText().length() != 0 && editPassword.getText().length() != 0){
            requestApiUserLogin(editUsername.getText().toString(), editPassword.getText().toString());
        }

    }

    private void requestApiUserLogin(String username, String password){

        RestClient restClient = new RestClient(RestClient.userApiService);
        Call<ApiResponseUser> call = restClient.getApiServiceUser().userLogin(username, password);
        call.enqueue(new Callback<ApiResponseUser>() {
            @Override
            public void onResponse(Call<ApiResponseUser> call, Response<ApiResponseUser> response) {

                if (response.isSuccessful()){

                    KSharedPreferences.setSomeStringValue(AppController.getInstance(), SharedPreferencesObject.background_color,response.body().getData().getBackgroundColor());
                    KSharedPreferences.setSomeStringValue(AppController.getInstance(), SharedPreferencesObject.text_color,response.body().getData().getTextColor());
                    KSharedPreferences.setSomeStringValue(AppController.getInstance(), SharedPreferencesObject.layout_color, response.body().getData().getLayoutColor());
                    KSharedPreferences.setSomeStringValue(AppController.getInstance(), SharedPreferencesObject.layout_style, response.body().getData().getLayout());


                    startActivity(new Intent(getActivity(), MainActivity.class));
                    getActivity().finish();

                }

            }

            @Override
            public void onFailure(Call<ApiResponseUser> call, Throwable t) {

            }
        });

    }

}
