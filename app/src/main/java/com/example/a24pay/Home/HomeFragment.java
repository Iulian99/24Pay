package com.example.a24pay.Home;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.example.a24pay.Home.Toolbar.Notification.NotificationFragment;
import com.example.a24pay.Home.Toolbar.MyAccount.ProfileFragment;
import com.example.a24pay.Home.Toolbar.Settings.SettingsFragment;
import com.example.a24pay.NavigationUtil;
import com.example.a24pay.R;
import com.example.a24pay.Services.ImageTitleList;
import com.example.a24pay.Services.ServicesAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import me.relex.circleindicator.CircleIndicator3;


public class HomeFragment extends Fragment {
//    Horizontal scroll
    private ViewPager2 viewPager2;
    private List<ListItem> listItems = Arrays.asList(
            new ListItem(R.drawable.icon_up, "Forget about parking", "Add vehicle"),
            new ListItem(R.drawable.icon_up, "Pay bills and all utilities", "Set your faborite providers"),
            new ListItem(R.drawable.icon_up, "Go on vacation with your loved ones", "Add relatives"));
    private ImageAdapter imageAdapter;
//    HorizontalScrollView
    RecyclerView recyclerView;
    private ServicesAdapter adapter;

    private List<Integer> images;
    private List<String> imageTitles;
    private HashMap<String, List<ImageTitleList>> hashMap = new HashMap<>();
    List<ImageTitleList> dataList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ImageButton notification_btn = view.findViewById(R.id.notification_image_btn);
        ImageButton setting_btn = view.findViewById(R.id.settings_image_btn);
        ImageButton profile_btn = view.findViewById(R.id.profile_image_btn);
        notification_btn.setOnClickListener(v -> NavigationUtil.navigateToFragment(requireActivity(),new NotificationFragment(),R.id.fragment_container));
        setting_btn.setOnClickListener(v -> NavigationUtil.navigateToFragment(requireActivity(),new SettingsFragment(),R.id.fragment_container));
        profile_btn.setOnClickListener(v -> NavigationUtil.navigateToFragment(requireActivity(),new ProfileFragment(),R.id.fragment_container));

        setupRecyclerView(view);
        setupViewPager2(view);



        return view;
    }

    private void setupViewPager2(View view){
        viewPager2 = view.findViewById(R.id.viewPager2);

        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);

        int marginPx = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics());
        int paddingPx = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 48, getResources().getDisplayMetrics()); // Ajustează această valoare

        viewPager2.setPageTransformer(new MarginPageTransformer(marginPx));
        viewPager2.setPadding(paddingPx, 0, paddingPx, 0);



        imageAdapter = new ImageAdapter(listItems);
        viewPager2.setAdapter(imageAdapter);

        CircleIndicator3 indicator = view.findViewById(R.id.circleIndicator);
        indicator.setViewPager(viewPager2);
        indicator.createIndicators(listItems.size(), 0);
    }
    private void setupRecyclerView(View view) {
        recyclerView = view.findViewById(R.id.recyclerViewHome);
        dataList = new ArrayList<>();
        dataList = createList();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 6);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch(adapter.getItemViewType(position)){
                    case ImageTitleList.TEXT_TYPE:
                        return 6;
                    case ImageTitleList.IMAGE_TYPE:
                        return 1;
                    default:
                        return 2;
                }
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);

        adapter = new ServicesAdapter(dataList);
        recyclerView.setAdapter(adapter);
    }

    public List<ImageTitleList> createList(){
        dataList.add(new ImageTitleList(ImageTitleList.TEXT_TYPE, "Services", 0));
        dataList.add(new ImageTitleList(ImageTitleList.IMAGE_TYPE, "", R.drawable.bus,"Public transport"));
        dataList.add(new ImageTitleList(ImageTitleList.IMAGE_TYPE, "", R.drawable.bus,"Train CFR"));
        dataList.add(new ImageTitleList(ImageTitleList.IMAGE_TYPE, "", R.drawable.bus,"Mobile Top Up"));
        dataList.add(new ImageTitleList(ImageTitleList.IMAGE_TYPE, "", R.drawable.bus,"Bill Payment"));
        dataList.add(new ImageTitleList(ImageTitleList.IMAGE_TYPE, "", R.drawable.bus,"Parking"));
        dataList.add(new ImageTitleList(ImageTitleList.IMAGE_TYPE, "", R.drawable.bus,"Plane tickets"));
        dataList.add(new ImageTitleList(ImageTitleList.IMAGE_TYPE, "", R.drawable.bus,"eMoney"));
        dataList.add(new ImageTitleList(ImageTitleList.IMAGE_TYPE, "", R.drawable.bus,"Gaming"));
        dataList.add(new ImageTitleList(ImageTitleList.IMAGE_TYPE, "", R.drawable.bus,"RCA& auto taxes"));
        return dataList;
    }

}
