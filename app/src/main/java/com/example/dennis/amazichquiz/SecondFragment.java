package com.example.dennis.amazichquiz;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class SecondFragment extends Fragment {

    public static SecondFragment newInstance( int sectionNumber) {
        SecondFragment fragment = new SecondFragment();
        return fragment;
    }

    public SecondFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.second_fragment, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.swagView);
        textView.setText("cunt");
        return rootView;
    }
    }

