package com.example.starterapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.navigation.fragment.NavHostFragment;

import com.example.starterapp.databinding.FragmentSecondBinding;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    TextView showPasscode;


    private void appendME(View view,String key) {
        String countString = showPasscode.getText().toString();
        countString = countString.concat(key);
        showPasscode.setText(countString);
    }



    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {


        View fragmentSecondLayout = inflater.inflate(R.layout.fragment_second, container, false);
        showPasscode = fragmentSecondLayout.findViewById(R.id.passcode_view);
        return fragmentSecondLayout;

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.submit_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //String app_unlocked = "Welcome to the App!The app is Unlocked";
                Bundle bundle = new Bundle();
                if (showPasscode.getText().toString().equals("1234")) {
                    bundle.putString("bundlekey", "Welcome to The app It is Unlocked");
                    //int currentPass = Integer.parseInt(showPasscode.getText().toString());
                    //getParentFragmentManager().setFragmentResult("lockstatus", bundle);

                }
               else {
                    bundle.putString("bundlekey", "Welcome to The app it is still locked");
                    //getParentFragmentManager().setFragmentResult("lockstatus", bundle);

                }
                //Takes you back to welcome screen
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment,bundle);
            }
        });

        view.findViewById(R.id.button_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendME(view, "1");
            }
        });

        view.findViewById(R.id.button_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendME(view, "2");
            }
        });

        view.findViewById(R.id.button_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendME(view,"3");
            }
        });

        view.findViewById(R.id.button_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendME(view ,"4");
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}