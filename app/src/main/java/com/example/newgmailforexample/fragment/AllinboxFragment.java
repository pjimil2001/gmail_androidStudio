package com.example.newgmailforexample.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newgmailforexample.R;
import com.example.newgmailforexample.adapter.DataAdapter;
import com.example.newgmailforexample.models.DataModel;

import java.util.ArrayList;
import java.util.List;

public class AllinboxFragment extends Fragment {


    RecyclerView recyclerView;
    List<DataModel> dataModels = new ArrayList<>();



    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AllinboxFragment() {
        }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_allinbox, container, false);

        recyclerView = v.findViewById(R.id.recyclerView);

        dataModels.add(new DataModel("John"));
        dataModels.add(new DataModel("Machale"));
        dataModels.add(new DataModel("John c2"));
        dataModels.add(new DataModel("John 2"));
        dataModels.add(new DataModel("John 3"));
        dataModels.add(new DataModel("John 4"));
        dataModels.add(new DataModel("John 5"));
        dataModels.add(new DataModel("John 5"));
        dataModels.add(new DataModel("John 6"));
        dataModels.add(new DataModel("John 77"));

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new DataAdapter(dataModels));

        return v;
    }

        public static AllinboxFragment newInstance(String param1, String param2) {
        AllinboxFragment fragment = new AllinboxFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


}