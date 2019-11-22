package com.example.kampungbatikjetis;

import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.kampungbatikjetis.Model.ProsesPembuatanModel;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    public HomeFragment homeFragment = new HomeFragment();
    public SejarahFragment sejarahFragment = new SejarahFragment();
    public LayananFragment layananFragment = new LayananFragment();
    public ProductFragment productFragment = new ProductFragment();
    public KontakFragment kontakFragment = new KontakFragment();

    public InfoFragment infoFragment = new InfoFragment();
    public ProsesPembuatanFragment prosesPembuatanFragment = new ProsesPembuatanFragment();
    public EventFragment eventFragment = new EventFragment();
    public PenghargaanFragment penghargaanFragment = new PenghargaanFragment();


    private ActionBarDrawerToggle drawerToggle;
    private DrawerLayout drawerMain;
    private NavigationView navigationViewMain;

    FragmentTransaction ft;


    // Utils
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);


        drawerMain = findViewById(R.id.drawer_main);
        drawerToggle = new ActionBarDrawerToggle(this, drawerMain, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerMain.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);

        setFragment(homeFragment);

        navigationViewMain = findViewById(R.id.nav_view_kasir);
        navigationViewMain.getMenu().findItem(R.id.home).setChecked(true);
        navigationViewMain.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        setMainFragment(homeFragment);
                        break;
                    case R.id.sejarah:
                        setMainFragment(sejarahFragment);
                        break;
                    case R.id.layanan:
                        setMainFragment(layananFragment);
                        break;
                    case R.id.produk:
                        setMainFragment(productFragment);
                        break;
                    case R.id.info:
                        setMainFragment(infoFragment);
                        break;
                    case R.id.kontak:
                        setMainFragment(kontakFragment);
                        break;
                }
                menuItem.setChecked(true);
                drawerMain.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        drawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            Log.d("testingtesting", "ya ");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (drawerMain.isDrawerOpen(GravityCompat.START)) {
            drawerMain.closeDrawer(GravityCompat.START);
        }

        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
        } else if (!doubleBackToExitPressedOnce) {
            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "Tekan sekali lagi untuk keluar", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 2000);
        } else {
            finish();
//            return;
        }
    }

    private boolean checkCurrentFragment() {
        Fragment currentFragment = getSupportFragmentManager().findFragmentByTag("MAIN_FRAGMENT");
        return currentFragment != null && currentFragment.isVisible();
    }

    public void setMainFragment(Fragment fragment) {
        ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main_frame, fragment, "MAIN_FRAGMENT");
        Log.d("FragmentAdded", "FragmentMain");
        doubleBackToExitPressedOnce = false;
//        ft.addToBackStack(null);
        ft.commit();
    }

    public void setFragment(Fragment fragment) {
        ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main_frame, fragment, "MAIN_FRAGMENT");
        Log.d("FragmentAdded", "Fragment");
        ft.addToBackStack(null);
        ft.commit();
    }

    public void setSecondFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main_frame, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }
}
