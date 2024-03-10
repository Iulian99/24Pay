package com.example.a24pay.Home.Toolbar.Settings;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.a24pay.Home.Toolbar.MyAccount.Adapter;
import com.example.a24pay.Home.Toolbar.Notification.ContactUsFragment;
import com.example.a24pay.Home.Toolbar.Settings.Fragments.AppInfoFragment;
import com.example.a24pay.Home.Toolbar.Settings.Fragments.FAQFragment;
import com.example.a24pay.Home.Toolbar.Settings.Fragments.LanguageFragment;
import com.example.a24pay.Home.Toolbar.Settings.Fragments.LegalSettings.LegalFragment;
import com.example.a24pay.Home.Toolbar.Settings.Fragments.LoginAndSecuritySettings.LoginAndSecurityFragment;
import com.example.a24pay.Home.Toolbar.Settings.Fragments.NotificationSettings.NotificationsFragment;
import com.example.a24pay.Home.Toolbar.Settings.Fragments.PaymentFragment;
import com.example.a24pay.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SettingsFragment extends Fragment implements Adapter.OnItemClickListener {
    private List<String> settingsList;
    private RecyclerView recyclerView;
    private Adapter adapter;
    private ImageView closeImageView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        closeImageView = view.findViewById(R.id.closeImageView);

        settingsList = new ArrayList<>();
        settingsList.addAll(Arrays.asList(
                "Language",
                "Payment methods",
                "Notifications",
                "Biometric authentification",
                "Contact us",
                "FAQ",
                "Legal",
                "Login and security",
                "App info"
        ));
        recyclerView = view.findViewById(R.id.recyclerView1);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(gridLayoutManager);

        adapter = new Adapter(getActivity(), settingsList, this);
        recyclerView.setAdapter(adapter);

        closeImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Închide fragmentul curent și se întoarce la cel anterior
                getParentFragmentManager().popBackStack();
            }
        });
        return view;
    }

    @Override
    public void onItemClick(int position) {
        Fragment fragmentToDisplay = null;

        switch (position) {
            case 0:
                fragmentToDisplay = new LanguageFragment();
                break;
            case 1:
                fragmentToDisplay = new PaymentFragment();
                break;
            case 2:
                fragmentToDisplay = new NotificationsFragment();
                break;
            case 3:
//                fragmentToDisplay = new BiometricAuthentificationFragment(); ca sa nu ma duca la fragmentul BiometricAuthentificationFragment! Nu trebuie sa exsite acest fragment
                break;
            case 4:
                fragmentToDisplay = new ContactUsFragment();
                break;
            case 5:
                fragmentToDisplay = new FAQFragment();
                break;
            case 6:
                fragmentToDisplay = new LegalFragment();
                break;
            case 7:
                fragmentToDisplay = new LoginAndSecurityFragment();
                break;
            case 8:
                fragmentToDisplay = new AppInfoFragment();
                break;
        }
        // change activity from a fragment another (MAinActivity -> NotificationFragment)
        if (fragmentToDisplay != null) {
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragmentToDisplay) // presupunând că "container" este ID-ul FrameLayout sau al altui container în care dorești să afișezi fragmentul
                    .addToBackStack(null)
                    .commit();
        }
    }
}