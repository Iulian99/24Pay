package com.example.a24pay.Transactions;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class TransactionsPagerAdapter extends FragmentStateAdapter {
    public TransactionsPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new PaymentHistoryFragment(); // Acesta va fi fragmentul pentru primul tab
            case 1:
                return new StatisticsFragment(); // Acesta va fi fragmentul pentru al doilea tab
            default:
                return new PaymentHistoryFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
