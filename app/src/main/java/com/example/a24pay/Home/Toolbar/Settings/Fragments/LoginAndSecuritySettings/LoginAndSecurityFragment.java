package com.example.a24pay.Home.Toolbar.Settings.Fragments.LoginAndSecuritySettings;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.a24pay.Home.Toolbar.MyAccount.Adapter;
import com.example.a24pay.Home.Toolbar.Notification.ContactUsFragment;
import com.example.a24pay.Home.Toolbar.Settings.Fragments.AppInfoFragment;
import com.example.a24pay.Home.Toolbar.Settings.Fragments.FAQFragment;
import com.example.a24pay.Home.Toolbar.Settings.Fragments.LanguageFragment;
import com.example.a24pay.Home.Toolbar.Settings.Fragments.LegalSettings.LegalFragment;
import com.example.a24pay.Home.Toolbar.Settings.Fragments.NotificationSettings.NotificationsFragment;
import com.example.a24pay.Home.Toolbar.Settings.Fragments.PaymentFragment;
import com.example.a24pay.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LoginAndSecurityFragment extends Fragment implements Adapter.OnItemClickListener {
    private List<String> list;
    RecyclerView recyclerView;
    Adapter adapter;
    private ImageView closeImage;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login_and_security, container, false);
        recyclerView = view.findViewById(R.id.recyclerView1);
        closeImage = view.findViewById(R.id.closeImageView);
        list = new ArrayList<>();
        list.addAll(Arrays.asList(
                "Change 24payPIN",
                "Change phone number",
                "Delete my account"));
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter = new Adapter(getActivity(), list, this);
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onItemClick(int position) {
        Fragment fragmentToDisplay = null;
        Activity activity = null;

        switch (position) {
            case 0:
                activity = new Pay24PINActivity();
                break;
            case 1:
                fragmentToDisplay = new PaymentFragment();
                break;
            case 2:
                fragmentToDisplay = new NotificationsFragment();
                break;
        }
        //schimba activitatea catre un fragment de la fragment container(MAinActivity -> NotificationFragment)
        if (fragmentToDisplay != null) {
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragmentToDisplay) // presupunând că "container" este ID-ul FrameLayout sau al altui container în care dorești să afișezi fragmentul
                    .addToBackStack(null)
                    .commit();
        }
    }
}