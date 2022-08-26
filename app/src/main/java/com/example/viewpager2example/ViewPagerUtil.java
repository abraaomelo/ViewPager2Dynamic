package com.example.viewpager2example;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

public class ViewPagerUtil {

    private ImageView[]  ivArrayDotsPager;
    private static ViewPagerUtil instance = null;

    private  ViewPagerUtil(){
    }

    public static ViewPagerUtil getInstance(){
        if(instance == null) {
            instance = new ViewPagerUtil();
        }
        return instance;
    }

    void setupIndicator(Activity activity, ViewPager2 viewPager2, LinearLayout pagerDots, int size){
        ivArrayDotsPager = new ImageView[size];

        for (int i = 0; i < size; i++){
            ivArrayDotsPager[i] = new ImageView(activity);
            LinearLayout.LayoutParams params =
                    new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(25, 0, 25, 0);

            ivArrayDotsPager[i].setLayoutParams(params);
            ivArrayDotsPager[i].setImageResource(R.drawable.viewpager_indicator_unselected);
            ivArrayDotsPager[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    view.setAlpha(1);
                }
            });

            pagerDots.addView(ivArrayDotsPager[i]);
            pagerDots.bringToFront();
        }

        ivArrayDotsPager[0].setImageResource(R.drawable.viewpager_indicator_selected);

        ViewPager2.OnPageChangeCallback  onPageChangeCallback =
                new ViewPager2.OnPageChangeCallback(){
                    @Override public void onPageScrolled(int position, float positionOffset,
                                                         int positionOffsetPixels){
                        super.onPageScrolled(position, positionOffset,positionOffsetPixels);
                    }

                    @Override public void onPageSelected(int position)  {
                        for (int i = 0; i <  ivArrayDotsPager.length;  i++){
                            ivArrayDotsPager[i].setImageResource(R.drawable.viewpager_indicator_unselected);
                        }
                        ivArrayDotsPager[position].setImageResource(R.drawable.viewpager_indicator_selected);
                    }

                    @Override public void  onPageScrollStateChanged(int state){
                        super.onPageScrollStateChanged(state);
                    }
                };
        viewPager2.registerOnPageChangeCallback(onPageChangeCallback);
    }

    void onBackPressed(final ViewPager2 viewPager2, final FragmentManager fragmentManager){
        viewPager2.setFocusableInTouchMode(true);
        viewPager2.requestFocus();
        viewPager2.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if ((keyCode == KeyEvent.KEYCODE_BACK)) {
                    if (viewPager2.getCurrentItem() == 0){
                        fragmentManager.popBackStack();
                    }else{
                        viewPager2.setCurrentItem(0, true);
                        viewPager2.setFocusableInTouchMode(false);
                        viewPager2.clearFocus();
                    }
                    return true;
                }
                return false;
            }
        });

    }

}
