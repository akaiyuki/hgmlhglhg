package com.kmcbookingav.av.dev.core;

import android.app.Dialog;
import android.graphics.Color;
import android.view.Window;
import android.widget.Button;

import com.kmcbookingav.av.dev.R;
import com.kmcbookingav.av.dev.object.SharedPreferencesObject;

/**
 * Created by CodeSyaona on 11/07/2017.
 */

public class KDialog {

    public static void showProfileDialog(BaseActivity baseActivity){

        final Dialog dialog = new Dialog(baseActivity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_profile);

        Button btnProfile = dialog.findViewById(R.id.btnprofile);
        Button btnSettings = dialog.findViewById(R.id.btnsettings);
        Button btnLogout = dialog.findViewById(R.id.btnlogout);

        btnProfile.setBackgroundColor(Color.parseColor(KSharedPreferences.getSomeStringValue(AppController.getInstance(), SharedPreferencesObject.background_color)));
        btnSettings.setBackgroundColor(Color.parseColor(KSharedPreferences.getSomeStringValue(AppController.getInstance(), SharedPreferencesObject.background_color)));
        btnLogout.setBackgroundColor(Color.parseColor(KSharedPreferences.getSomeStringValue(AppController.getInstance(), SharedPreferencesObject.background_color)));
        btnProfile.setTextColor(Color.parseColor(KSharedPreferences.getSomeStringValue(AppController.getInstance(), SharedPreferencesObject.text_color)));
        btnSettings.setTextColor(Color.parseColor(KSharedPreferences.getSomeStringValue(AppController.getInstance(), SharedPreferencesObject.text_color)));
        btnLogout.setTextColor(Color.parseColor(KSharedPreferences.getSomeStringValue(AppController.getInstance(), SharedPreferencesObject.text_color)));


        dialog.show();

    }

}
