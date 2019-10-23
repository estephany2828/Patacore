package edu.unicauca.patacore.view.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.unicauca.patacore.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListarOrdenFragment extends Fragment {


    public ListarOrdenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_listar_orden, container, false);
    }

}
