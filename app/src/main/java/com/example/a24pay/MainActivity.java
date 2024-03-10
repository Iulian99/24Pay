package com.example.a24pay;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.a24pay.Home.HomeFragment;
import com.example.a24pay.Scan.ScanFragment;
import com.example.a24pay.Services.ServicesFragment;
import com.example.a24pay.Transactions.TransactionsFragment;
import com.example.a24pay.Wallet.WalletFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CAMERA_PERMISSION = 100;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnItemSelectedListener(navListener);


//        itemBackground(bottomNav);
        // Set the initial fragment (optional):
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new ServicesFragment()).commit();
        }
    }
    private void itemBackground(BottomNavigationView bottomNavigation){
// Găsește referința BottomNavigationView și item-ul dorit
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        MenuItem scanItem = bottomNavigationView.getMenu().findItem(R.id.scan_fragment);
// Setează culoarea pentru icon
        scanItem.getIcon().setColorFilter(Color.parseColor("#FFFF00"), PorterDuff.Mode.SRC_IN);
// Setează culoarea pentru text
        SpannableString spannable = new SpannableString(scanItem.getTitle());
        spannable.setSpan(new ForegroundColorSpan(Color.parseColor("#FFFF00")), 0, spannable.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        scanItem.setTitle(spannable);
    }

    private final NavigationBarView.OnItemSelectedListener navListener =
            new NavigationBarView.OnItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(MenuItem item) {
                    Fragment selectedFragment = null;
                    int itemId = item.getItemId();
                    if (itemId == R.id.home_fragment) {
                        selectedFragment = new HomeFragment();
                    } else if (itemId == R.id.services_fragment) {
                        selectedFragment = new ServicesFragment();
                    } else if (itemId == R.id.scan_fragment) {
                        selectedFragment = new ScanFragment();
                    } else if (itemId == R.id.transactions_fragment) {
                        selectedFragment = new TransactionsFragment();
                    } else if (itemId == R.id.wallet_fragment) {
                        selectedFragment = new WalletFragment();
                    }
                    if (selectedFragment != null) {
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragment_container, selectedFragment).commit();
                    }
                    return true;
                }
            };

//    Camera
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        if (requestCode == REQUEST_CAMERA_PERMISSION) {
//            if (grantResults.length == 0 || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
//                Toast.makeText(this, "Permisiunea camerei este necesară", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }
}
