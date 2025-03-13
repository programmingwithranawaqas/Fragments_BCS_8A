package com.example.fragments_bcs_8a;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListFrag extends ListFragment {

    OnContactNameClicked pointerOfParentActivity;

    public interface OnContactNameClicked{
        public void onContactNameItemClicked(int position);
    }

    public ListFrag() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        pointerOfParentActivity = (OnContactNameClicked) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<String> data = new ArrayList<>();
        data.add("Waqas");
        data.add("Ali Raza");
        data.add("Muzammil Hussain");
        data.add("Kashif Zafar");
        data.add("Kashif Zafar");
        data.add("Kashif Zafar");
        data.add("Kashif Zafar");
        data.add("Kashif Zafar");
        data.add("Kashif Zafar");

        setListAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_dropdown_item_1line, data));

    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        pointerOfParentActivity.onContactNameItemClicked(position);
    }
}