package com.kmcbookingav.av.dev.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.kmcbookingav.av.dev.R;
import com.kmcbookingav.av.dev.core.AppController;
import com.kmcbookingav.av.dev.core.BaseActivity;
import com.kmcbookingav.av.dev.core.KEngine;
import com.kmcbookingav.av.dev.core.KSharedPreferences;
import com.kmcbookingav.av.dev.fragment.BookTodayFragment;
import com.kmcbookingav.av.dev.fragment.BookTomorrowFragment;
import com.kmcbookingav.av.dev.fragment.ScheduleNowFragment;
import com.kmcbookingav.av.dev.object.SharedPreferencesObject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    public static MainActivity INSTANCE = null;
    @BindView(R.id.bottom_navigation)
    AHBottomNavigation bottomNavigation;
    @BindView(R.id.app_bar)
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        INSTANCE = this;

        setFrameLayout(R.id.framelayout_main);


        KEngine.switchFragment(INSTANCE, new BookTodayFragment(), getFrameLayout());
        addBottomToolbar();
        initToolbar();



    }

    public void initToolbar(){
        toolbar.setBackgroundColor(Color.parseColor(KSharedPreferences.getSomeStringValue(AppController.getInstance(), SharedPreferencesObject.background_color)));

    }


    private void addBottomToolbar(){

        // Create items
        AHBottomNavigationItem item1 = new AHBottomNavigationItem("Today", R.drawable.ic_book, R.color.colorTextColor);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem("Tomorrow", R.drawable.ic_book, R.color.colorTextColor);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem("Schedule Now", R.drawable.ic_book, R.color.colorTextColor);

        // Add items
        bottomNavigation.addItem(item1);
        bottomNavigation.addItem(item2);
        bottomNavigation.addItem(item3);

        // Set background color
        bottomNavigation.setDefaultBackgroundColor(Color.parseColor(KSharedPreferences.getSomeStringValue(AppController.getInstance(),SharedPreferencesObject.background_color)));

        // Disable the translation inside the CoordinatorLayout
        bottomNavigation.setBehaviorTranslationEnabled(false);

        // Enable the translation of the FloatingActionButton
//        bottomNavigation.manageFloatingActionButtonBehavior(floatingActionButton);

        // Change colors
        bottomNavigation.setAccentColor(Color.parseColor(KSharedPreferences.getSomeStringValue(AppController.getInstance(),SharedPreferencesObject.text_color)));
        bottomNavigation.setInactiveColor(Color.parseColor(KSharedPreferences.getSomeStringValue(AppController.getInstance(), SharedPreferencesObject.layout_color)));


        // Display color under navigation bar (API 21+)
        // Don't forget these lines in your style-v21
        // <item name="android:windowTranslucentNavigation">true</item>
        // <item name="android:fitsSystemWindows">true</item>
        bottomNavigation.setTranslucentNavigationEnabled(true);

        // Manage titles
        bottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);

        // Use colored navigation with circle reveal effect
        bottomNavigation.setColored(false);

        // Set current item programmatically
        bottomNavigation.setCurrentItem(0);


        // Set listeners
        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                // Do something cool here...

                if (position == 0){
                    KEngine.switchFragment(INSTANCE, new BookTodayFragment(), getFrameLayout());
                } else if (position == 1){
                    KEngine.switchFragment(INSTANCE, new BookTomorrowFragment(), getFrameLayout());
                } else if (position == 2){
                    KEngine.switchFragment(INSTANCE, new ScheduleNowFragment(), getFrameLayout());
                }

                return true;
            }
        });
        bottomNavigation.setOnNavigationPositionListener(new AHBottomNavigation.OnNavigationPositionListener() {
            @Override public void onPositionChange(int y) {
                // Manage the new y position
            }
        });

    }

    public void changeHomeLayout(){
        bottomNavigation.setDefaultBackgroundColor(Color.parseColor(KSharedPreferences.getSomeStringValue(AppController.getInstance(),SharedPreferencesObject.background_color)));
        bottomNavigation.setAccentColor(Color.parseColor(KSharedPreferences.getSomeStringValue(AppController.getInstance(),SharedPreferencesObject.text_color)));
        bottomNavigation.setInactiveColor(Color.parseColor(KSharedPreferences.getSomeStringValue(AppController.getInstance(), SharedPreferencesObject.layout_color)));
    }


}
