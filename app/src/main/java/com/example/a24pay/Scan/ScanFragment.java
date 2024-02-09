package com.example.a24pay.Scan;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;

import com.example.a24pay.Home.HomeFragment;
import com.example.a24pay.R;
import com.example.a24pay.Services.ServicesFragment;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

import java.util.Objects;

public class ScanFragment extends Fragment {
    private Button buttonScan;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_scan, container, false);



        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        scanCode();//Dacă vrei ca scanarea să înceapă de îndată ce fragmentul este complet

    }


//    if the user press backButton the fragment will go to the homefragment - to dont repeted onStart()
    @Override
    public void onPause() {
        super.onPause();
        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new HomeFragment()).commit();
    }

    public void scanCode() {
        ScanOptions options = new ScanOptions();
        options.setPrompt("Volum up to flash on");
        options.setBeepEnabled(true);
        options.setOrientationLocked(true);
        options.setCaptureActivity(CaptureAct.class);
        options.setBarcodeImageEnabled(true);
//        options.setTimeout(2000);set time
        barLauncher.launch(options);
    }
    // Register the launcher and result handler
    ActivityResultLauncher<ScanOptions> barLauncher = registerForActivityResult(new ScanContract(),result -> {
        if(result.getContents()!=null){
            Toast.makeText(getContext(), "Scanned", Toast.LENGTH_LONG).show();
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setTitle("Result");
            builder.setMessage(result.getContents());

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            }).show();
        }else{
            Toast.makeText(getActivity(), "Cancelled: " + result.getContents(), Toast.LENGTH_LONG).show();
        }
    });


}
