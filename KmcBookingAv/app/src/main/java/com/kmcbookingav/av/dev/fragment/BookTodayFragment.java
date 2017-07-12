package com.kmcbookingav.av.dev.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.kmcbookingav.av.dev.R;
import com.kmcbookingav.av.dev.core.AppController;
import com.kmcbookingav.av.dev.core.KSharedPreferences;
import com.kmcbookingav.av.dev.object.SharedPreferencesObject;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class BookTodayFragment extends Fragment {

    @BindView(R.id.txttitle)
    TextView txtTitle;
    @BindView(R.id.edittime)
    EditText editTime;
    @BindView(R.id.editduration)
    EditText editDuration;
    @BindView(R.id.editlocation)
    EditText editLocation;
    @BindView(R.id.editcapacity)
    EditText editCapacity;


    public BookTodayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_book_today, container, false);
        ButterKnife.bind(this, view);

        initDisplay();

        return view;
    }


    public void initDisplay(){
        txtTitle.setTextColor(Color.parseColor(KSharedPreferences.getSomeStringValue(AppController.getInstance(), SharedPreferencesObject.text_color)));
        editTime.setHintTextColor(Color.parseColor(KSharedPreferences.getSomeStringValue(AppController.getInstance(), SharedPreferencesObject.text_color)));
        editTime.setTextColor(Color.parseColor(KSharedPreferences.getSomeStringValue(AppController.getInstance(), SharedPreferencesObject.text_color)));
        editDuration.setHintTextColor(Color.parseColor(KSharedPreferences.getSomeStringValue(AppController.getInstance(), SharedPreferencesObject.text_color)));
        editDuration.setTextColor(Color.parseColor(KSharedPreferences.getSomeStringValue(AppController.getInstance(), SharedPreferencesObject.text_color)));
        editLocation.setHintTextColor(Color.parseColor(KSharedPreferences.getSomeStringValue(AppController.getInstance(), SharedPreferencesObject.text_color)));
        editLocation.setTextColor(Color.parseColor(KSharedPreferences.getSomeStringValue(AppController.getInstance(), SharedPreferencesObject.text_color)));
        editCapacity.setHintTextColor(Color.parseColor(KSharedPreferences.getSomeStringValue(AppController.getInstance(), SharedPreferencesObject.text_color)));
        editCapacity.setTextColor(Color.parseColor(KSharedPreferences.getSomeStringValue(AppController.getInstance(), SharedPreferencesObject.text_color)));

    }


}
