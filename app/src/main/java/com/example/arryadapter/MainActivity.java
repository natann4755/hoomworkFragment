package com.example.arryadapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements onMooveiClickLisiner {



    private RecyclerView myRecyclerView;
    private RecyclerView.Adapter myAdepter;
    private RecyclerView.LayoutManager myLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         arryListMooveis();
        initrecyclerView();
        MooveiFragment fragmentmoovei =new MooveiFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.AM_FrameLayout,fragmentmoovei).commit();



    }

    private void initrecyclerView() {
        myRecyclerView = findViewById(R.id.MA_rv);
        myLayoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(myLayoutManager);
        myAdepter = new mooveiVeiwAdapter(this,this, arryListMooveis());
        myRecyclerView.setAdapter(myAdepter);
    }

    static ArrayList arryListMooveis() {
        ArrayList<dataMoovei> arr = new ArrayList<dataMoovei>();
        arr.add(new dataMoovei("cars", "1",R.drawable.cars));
        arr.add(new dataMoovei("code", "2",R.drawable.code_8));
        arr.add(new dataMoovei("forzon", "3",R.drawable.frozen_2));
        arr.add(new dataMoovei("interstellar", "4",R.drawable.interstellar));
        arr.add(new dataMoovei("jurassic_world", "5",R.drawable.jurassic_world));
        arr.add(new dataMoovei("rabbi_jacob", "6",R.drawable.rabbi_jacob));
        arr.add(new dataMoovei("rick_and_morty", "7",R.drawable.rick_and_morty));
        arr.add(new dataMoovei("spider_man", "8",R.drawable.spider_man));
        arr.add(new dataMoovei("the_lion_king", "9",R.drawable.the_lion_king));
        arr.add(new dataMoovei("the_simpsons", "10",R.drawable.the_simpsons));
        arr.add(new dataMoovei("toy_story_4", "11",R.drawable.toy_story_4));
        arr.add(new dataMoovei("young_sheldon", "12",R.drawable.young_sheldon));

        return arr;
    }

    @Override
    public void OnMooveiClicked(int itemPoshisen) {
        MooveiFragment2 f2 = new MooveiFragment2();
        getSupportFragmentManager().beginTransaction().replace(R.id.AM_FrameLayout,f2).commit();


    }
}
