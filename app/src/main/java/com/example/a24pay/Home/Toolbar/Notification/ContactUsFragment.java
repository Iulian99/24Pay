package com.example.a24pay.Home.Toolbar.Notification;

import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a24pay.Home.HomeFragment;
import com.example.a24pay.Home.Toolbar.Settings.SettingsFragment;
import com.example.a24pay.NavigationUtil;
import com.example.a24pay.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;


public class ContactUsFragment extends Fragment {

    String[] items = {"Suggestion","Complaint"};
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItems;
    private TextView textViewTitleContactUsFragment;
    private ImageButton imageButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact_us2, container, false);

//        TextView de langa buttonul de inapoi
        textViewTitleContactUsFragment = view.findViewById(R.id.toolbar_title);//setez textul pe care il afisez din custom_toolbar.xml
        textViewTitleContactUsFragment.setText(getString(R.string.title_fragment_contact));

//        Buttonul de inapoi
        imageButton = view.findViewById(R.id.back_button);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().popBackStack();
            }
        });

//        Subject Suggestion/Complaint
        autoCompleteTextView = view.findViewById(R.id.auto_complete_txt);
        adapterItems = new ArrayAdapter<String>(requireActivity(),R.layout.list_item_text_input_layout, items);
        autoCompleteTextView.setAdapter(adapterItems);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
//                Toast.makeText(getContext(),"Item: "+item,Toast.LENGTH_SHORT).show();
            }
        });
//        E-mail address, Phone brand, Phone model, System version
        addTextToEdit(view,R.id.textInputPhoneBrand,Build.BRAND);
        addTextToEdit(view,R.id.textInputPhoneModel,Build.MODEL);
        addTextToEdit(view,R.id.textInputSystemModel,Build.VERSION.RELEASE);

        return view;
    }

    public void addTextToEdit(View view,int idTextInput,String text){
        // l am facut ca sa nu se mai repete pentru 3 textInputEditText
        TextInputLayout textInputPhoneBrand = view.findViewById(idTextInput);
        TextInputEditText editTextPhoneBrand = (TextInputEditText) textInputPhoneBrand.getEditText();
        if(editTextPhoneBrand!=null) {
            editTextPhoneBrand.setText(text);
        }
    }
}