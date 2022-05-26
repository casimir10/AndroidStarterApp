package com.example.starterapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.navigation.fragment.NavHostFragment;

import com.example.starterapp.databinding.FragmentFirstBinding;
import com.example.starterapp.databinding.FragmentSecondBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;



    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //String status = FirstFragmentArgs.fromBundle(getArguments()).getMyArg();
        //String unlockText = "Welcome to the App! {unlocked}";
        TextView headerView = view.findViewById(R.id.textview_first);
        try{
            headerView.setText(getArguments().getString("bundlekey"));
        } catch (NullPointerException e) {
            headerView.setText(headerView.getText().toString());
        }

        //headerView.setText(status);

        binding.unlockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}