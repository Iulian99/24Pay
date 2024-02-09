package com.example.a24pay.Home.Toolbar.Settings.Fragments.NotificationSettings;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;


import com.example.a24pay.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NotificationsFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<NotificationList> list;
    private Adapter adapter;
    private SharedPreferences sharedPreferences;
    private TextView textViewTitleFragment;
    private ImageButton imageButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notifications, container, false);
        textViewTitleFragment = view.findViewById(R.id.toolbar_title);//setez textul pe care il afisez din custom_toolbar.xml
        textViewTitleFragment.setText(getString(R.string.title_fragment_notification));
        imageButton = view.findViewById(R.id.back_button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().popBackStack();
            }
        });

        sharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE);
        list = new ArrayList<>();
        list = getDefaultNotificationsList();
        for (NotificationList notification : list) {
            boolean savedSwitchState = sharedPreferences.getBoolean(notification.getTitle(), false);
            notification.setSwitchedOn(savedSwitchState);
        }

        recyclerView = view.findViewById(R.id.recyclerViewNotficationSettings);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),1);
        recyclerView.setLayoutManager(gridLayoutManager);

        adapter = new Adapter(getActivity(),list);
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("SharedPreferences", "Aplicatia a pornit onStart");

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("SharedPreferences", "Aplicatia functioneaza onResume");

    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("SharedPreferences", "Aplicatia s-a oprit onStop");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("SharedPreferences", "Aplicatia s-a este in pauza onPause");

        SharedPreferences sharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        for (int i = 0; i < list.size(); i++) {
            NotificationList notification = list.get(i);
            editor.putBoolean(notification.getTitle(), notification.isSwitchedOn());
            Log.d("SharedPreferences", "Salvare: " + notification.getTitle() + " - " + notification.isSwitchedOn());
        }
        editor.apply();
    }
    private List<NotificationList> getDefaultNotificationsList() {
        List<NotificationList> defaultList = new ArrayList<>();
        defaultList.add(new NotificationList("Transport alerts","We notify when your public transport ticket/subscription expires or how many journey you still have available from the total journeys purchesed",false));
        defaultList.add(new NotificationList("Invoice alerts","We remind you which invoices are due and when invoices to be paid are issued",false));
        defaultList.add(new NotificationList("Insurance alerts","We keep your informed about the valability of insurance",false));
        defaultList.add(new NotificationList("Electronic charging alerts","We remind you when you need to renew your electronic top-up",false));
        defaultList.add(new NotificationList("Paking alerts","We notify you when your parking space expires",false));
        // Adaugă restul notificărilor
        return defaultList;
    }
}