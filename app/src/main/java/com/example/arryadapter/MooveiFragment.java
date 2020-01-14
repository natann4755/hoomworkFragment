package com.example.arryadapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MooveiFragment extends Fragment implements onMooveiClickLisiner {

    public OnMooveiFragmentClickLisiner myClickLisiner;
    private RecyclerView myRecyclerView;
    private RecyclerView.LayoutManager mylayoutManager;
    private RecyclerView.Adapter myAdapter;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof OnMooveiFragmentClickLisiner){
            myClickLisiner = (OnMooveiFragmentClickLisiner) context;
        }else {
            throw new RuntimeException(context.toString()+"must be implements OnMooveiFragmentClickLisiner");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        myClickLisiner=null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vveiw = inflater.inflate(R.layout.fragment_moovei,container,false);
        myRecyclerView = vveiw.findViewById(R.id.FM_rv);

        intimyRecyclerView();


        return vveiw;
    }

    private void intimyRecyclerView() {
        if (getContext() != null) {
            mylayoutManager = new LinearLayoutManager(getContext());
            myRecyclerView.setLayoutManager(mylayoutManager);
            myAdapter = new mooveiVeiwAdapter(getContext(),this , MainActivity.arryListMooveis());
            myRecyclerView.setAdapter(myAdapter);
        }
    }

    @Override
    public void OnMooveiClicked(int itemPoshisen) {
        if (myClickLisiner != null) {
            myClickLisiner.onMooveiCliced((dataMoovei) MainActivity.arryListMooveis().get(itemPoshisen));
        }
    }
}
