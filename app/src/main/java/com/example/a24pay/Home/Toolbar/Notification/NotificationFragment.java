package com.example.a24pay.Home.Toolbar.Notification;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a24pay.Home.HomeFragment;
import com.example.a24pay.NavigationUtil;
import com.example.a24pay.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class NotificationFragment extends Fragment {

    private ImageView closeImageView;
    private TextView headerText;
    private ImageView expandIcon;
    private TextView expandedText;
    private TextView contactUsTextView;

    private RecyclerView recyclerView;
    private List<NotificationsList> list;
    private Adapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification, container, false);
        contactUsTextView = view.findViewById(R.id.contactUsTextView);
        contactUsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contactUsTextView.setOnClickListener(v -> NavigationUtil.navigateToFragment(requireActivity(),new ContactUsFragment(),R.id.fragment_container));

            }
        });

        list = new ArrayList<>();
        list.add(new NotificationsList("14 Sep 2023 18:58","Formular Feedback","Array1",""));
        list.add(new NotificationsList("14 Sep 2023 18:58","CFR tickets in 24pay","Array2",""));
        list.add(new NotificationsList("14 Sep 2023 18:58","New App Features","Array3",""));
        list.add(new NotificationsList("14 Sep 2023 18:58","News Bill Payments menu","Array1",""));

        recyclerView = view.findViewById(R.id.recyclerView);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),1);
        recyclerView.setLayoutManager(gridLayoutManager);

        adapter = new Adapter(getActivity(),list);
        recyclerView.setAdapter(adapter);

        closeImageView = view.findViewById(R.id.closeImageView);

        closeImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().popBackStack();
            }
        });
        return view;
    }
}