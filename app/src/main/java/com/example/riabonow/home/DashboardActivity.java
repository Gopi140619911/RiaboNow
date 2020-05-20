package com.example.riabonow.home;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.riabonow.R;
import com.google.android.material.navigation.NavigationView;

public class DashboardActivity extends AppCompatActivity {
   public static DrawerLayout dLayout;
    NavigationView navView;
    Fragment frag = null;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        dLayout = (DrawerLayout) findViewById(R.id.drawer_layout); // initiate a DrawerLayout
        navView = (NavigationView) findViewById(R.id.navigation); // initiate a Navigation View

        setNavigationDrawer();

    }

    private void setNavigationDrawer() {
        frag = new DahBoardFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame, frag); // replace a Fragment with Frame Layout
        transaction.commit(); // commit the changes

// implement setNavigationItemSelectedListener event on NavigationView
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                 // create a Fragment Object
                int itemId = menuItem.getItemId(); // get selected menu item's id
// check selected menu item's id and replace a Fragment Accordingly
                if (itemId == R.id.home) {
                    frag = new DahBoardFragment();
                } else if (itemId == R.id.profile) {
                    frag = new DahBoardFragment();
                } else if (itemId == R.id.cart) {
                    frag = new DahBoardFragment();
                }
                else if (itemId == R.id.referal) {
                    frag = new DahBoardFragment();
                }
                else if (itemId == R.id.score) {
                    frag = new DahBoardFragment();
                }
                else if (itemId == R.id.performance) {
                    frag = new DahBoardFragment();
                }
                else if (itemId == R.id.contact) {
                    frag = new DahBoardFragment();
                }
                else if (itemId == R.id.rateus) {
                    frag = new DahBoardFragment();
                }
                else if (itemId == R.id.terms) {
                    frag = new DahBoardFragment();
                } else if (itemId == R.id.discliminarpolicy) {
                    frag = new DahBoardFragment();
                } else if (itemId == R.id.privacypolicy) {
                    frag = new DahBoardFragment();
                }
                Toast.makeText(getApplicationContext(), menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                if (frag != null) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame, frag); // replace a Fragment with Frame Layout
                    transaction.commit(); // commit the changes
                    dLayout.closeDrawers(); // close the all open Drawer Views
                    return true;
                }
                return false;
            }
        });
    }
}

