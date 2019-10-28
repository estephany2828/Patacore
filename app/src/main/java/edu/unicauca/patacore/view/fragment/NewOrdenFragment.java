package edu.unicauca.patacore.view.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import edu.unicauca.patacore.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewOrdenFragment extends Fragment {


    public NewOrdenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_orden, container, false);
    }

}
