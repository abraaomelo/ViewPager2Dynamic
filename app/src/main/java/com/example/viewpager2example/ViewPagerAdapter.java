
//This adapter creates the fragments for the viewpager and keeps their count

package com.example.viewpager2example;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

class ViewPagerAdapter extends FragmentStateAdapter{
    private List<String> fragmentData;
    private int numPages;

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity, List<String> fragmentData,
                            int numPages){
        super(fragmentActivity);

        this.fragmentData = fragmentData;
        this.numPages = numPages;

    }

    @NonNull @Override public Fragment createFragment(int position){
        Bundle bundle = new Bundle();
        bundle.putString("key", fragmentData.get(position));
        bundle.putString("med_id", String.valueOf(position));
        ViewpagerFragment fragment = new ViewpagerFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override public int getItemCount(){
        return numPages;
    }


}
