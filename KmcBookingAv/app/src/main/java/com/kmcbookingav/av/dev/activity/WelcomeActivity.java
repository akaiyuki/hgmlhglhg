package com.kmcbookingav.av.dev.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kmcbookingav.av.dev.R;
import com.kmcbookingav.av.dev.core.BaseActivity;
import com.kmcbookingav.av.dev.core.KEngine;
import com.kmcbookingav.av.dev.fragment.LoginFragment;

import butterknife.ButterKnife;

public class WelcomeActivity extends BaseActivity {

    public static WelcomeActivity INSTANCE = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
        INSTANCE = this;

        setFrameLayout(R.id.framelayout_main);

        KEngine.switchFragment(INSTANCE, new LoginFragment(), getFrameLayout());

    }
}
