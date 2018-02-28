package com.example.pritam.bottomnavigationview;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragments = null;
                switch (item.getItemId()){
                    case R.id.action_home:
                        fragments = FragmentOne.newInstance();
                        break;
                    case R.id.action_android:
                        fragments = FragmentTwo.newInstance();
                        break;
                    case R.id.action_favorite:
                        fragments = FragmentThree.newInstance();
                        break;
                }

                FragmentTransaction fm = getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.bottom_navigation, fragments);
                fm.commit();
                return true;
            }
        });

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.bottom_navigation, FragmentOne.newInstance());
        transaction.commit();
    }
}
