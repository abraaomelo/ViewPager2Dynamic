package com.example.viewpager2example;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private LinearLayout pager_dots;
    private FragmentStateAdapter pagerAdapter;
    private static int NUM_PAGES=2;
    List<String> fragmentData = new ArrayList<>();
    private Button btn_main;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewpager);
        pager_dots = findViewById(R.id.pager_dots);
        btn_main = findViewById(R.id.btnmain);

        btn_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickbtnMain();
                Toast.makeText(view.getContext(), "main button working", Toast.LENGTH_SHORT).show();
                pagerAdapter = new ViewPagerAdapter(MainActivity.this, fragmentData, NUM_PAGES);

            }
        });


        pagerAdapter = new ViewPagerAdapter(this, fragmentData, NUM_PAGES);
        viewPager.setAdapter(pagerAdapter);
        ViewPagerUtil.getInstance().setupIndicator(this, viewPager, pager_dots, NUM_PAGES);
        ViewPagerUtil.getInstance().onBackPressed(viewPager, getSupportFragmentManager());

        fragmentData.add("SAPHIRA");
        fragmentData.add("RUBY");
        fragmentData.add("New");
        fragmentData.add("New2");
        fragmentData.add("nuevo");
    }

    @Override
    public void onBackPressed(){ setViewPagerBackPress(); }

    private void setViewPagerBackPress(){
        if (viewPager.getCurrentItem() == 0){
            super.onBackPressed();
        }else{
            viewPager.setCurrentItem(viewPager.getCurrentItem() -1);
        }
    }

    public void  clickbtnMain(){
        String newFrag;
        NUM_PAGES = NUM_PAGES+1;
        //pagerAdapter = new ViewPagerAdapter(this, fragmentData, NUM_PAGES);
        Intent intent = getIntent();
        finish();
        startActivity(intent);


    }
}