package com.example.a24pay.Transactions;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.a24pay.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class TransactionsFragment extends Fragment {
    private ViewPager2 viewPager;
    private TabLayout tabLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_transactions, container, false); // înlocuiește 'layout_name' cu numele layout-ului tău

        viewPager = view.findViewById(R.id.view_pager);
        tabLayout = view.findViewById(R.id.tabs);

        // Setează adapterul pentru ViewPager2
        viewPager.setAdapter(new TransactionsPagerAdapter(this));

        // Sincronizează TabLayout cu ViewPager2 folosind TabLayoutMediator
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText(R.string.PaymentHistory);
                    break;
                case 1:
                    tab.setText("Statistics");
                    break;
            }
        }).attach();
//        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {}).attach();

        return view;
    }
}
