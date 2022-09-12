package com.example.viewpager2example;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
    private static final int NUM_PAGES=2;
    //private String [] fragmentData = {"Med1", "Med2"};
    List<String> fragmentData = new ArrayList<String>();
    private Button btn_frag;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       // btn_frag.setText("Teste Set text butn");

//        btn_frag.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "Clicked Button", Toast.LENGTH_SHORT).show();
//            }
//        });

        fragmentData.add("SAPHIRA");
        fragmentData.add("RUBY");
        fragmentData.add("New");
        fragmentData.add("New2");

        

        viewPager = findViewById(R.id.viewpager);
        pager_dots = findViewById(R.id.pager_dots);

        pagerAdapter = new ViewPagerAdapter(this, fragmentData, NUM_PAGES);
        viewPager.setAdapter(pagerAdapter);
        ViewPagerUtil.getInstance().setupIndicator(this, viewPager, pager_dots, NUM_PAGES);
        ViewPagerUtil.getInstance().onBackPressed(viewPager, getSupportFragmentManager());
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
}