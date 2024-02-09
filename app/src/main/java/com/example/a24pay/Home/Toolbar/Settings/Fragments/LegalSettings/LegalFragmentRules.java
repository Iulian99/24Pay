package com.example.a24pay.Home.Toolbar.Settings.Fragments.LegalSettings;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.a24pay.R;


public class LegalFragmentRules extends Fragment {
    private WebView webView;
    private String webViewText;
    public LegalFragmentRules(String webViewText){
        this.webViewText = webViewText;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_legal_rules, container, false);
        webView = view.findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true); // dacă ai nevoie de suport pentru JavaScript
        webView.loadUrl(webViewText);
        return view;
    }
}