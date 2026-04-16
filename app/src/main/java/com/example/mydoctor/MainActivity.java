package com.example.mydoctor;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.example.mydoctor.ui.home.HomeFragment;
import com.example.mydoctor.ui.booking.BookingFragment;
import com.example.mydoctor.ui.profile.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNav = findViewById(R.id.bottom_navigation);
        boolean openProfile = getIntent().getBooleanExtra("openProfile", false);
        if(openProfile){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, new ProfileFragment()) // force reload
                    .commit();
            bottomNav.setSelectedItemId(R.id.profile);
        } else {
            loadFragment(new HomeFragment());
        }bottomNav.setOnItemSelectedListener(item -> {
            Fragment fragment = null;
            int id = item.getItemId();
            if (id == R.id.home) fragment = new HomeFragment();
            else if (id == R.id.booking) fragment = new BookingFragment();
            else if (id == R.id.profile) fragment = new ProfileFragment();
            if (fragment != null) {
                loadFragment(fragment);
                return true;
            }
            return false;
        });
    }
    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}
