package com.example.a24pay;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

public class NavigationUtil {

    public static void navigateToFragment(FragmentActivity activity, Fragment fragment, int containerId) {
        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(
                R.anim.enter_right_to_left,
                R.anim.enter_left_to_right,
                R.anim.exit_left_to_right,
                R.anim.exit_right_to_left);
        transaction.replace(containerId, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}

