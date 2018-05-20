package com.kardusinfo.candra.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Fragment fragment1 = new BlankFragment();
    Fragment fragment2 = new BlankFragment2();
    Fragment fragment3 = new BlankFragment3();
    FragmentManager fragmanager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.menu1:
                        setMenuFragment(fragment1);
                        break;
                    case R.id.menu2:
                        setMenuFragment(fragment2);
                        break;
                    case R.id.menu3:
                        setMenuFragment(fragment3);
                        break;
                }

                return true;
            }
        });
    }

    void setMenuFragment(Fragment fragment) {

        fragmanager.beginTransaction()
                .replace(R.id.container_layout, fragment)
                .commit();
    }
}