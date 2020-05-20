package com.example.riabonow.home;

import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.riabonow.R;
import com.example.riabonow.widgets.SlidingImageAdapter;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class DahBoardFragment extends Fragment implements View.OnClickListener {

    View view;
    CirclePageIndicator indicator;
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private static final Integer[] IMAGES= {R.drawable.ic_gold_line_down,R.drawable.ic_gold_line_up,R.drawable.ic_gold_line_down,R.drawable.ic_gold_line_up};
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();
    ImageView imgMenu;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
// Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        mPager = (ViewPager)view. findViewById(R.id.pager);
        indicator = (CirclePageIndicator)view.findViewById(R.id.indicator);
        imgMenu= (ImageView)view.findViewById(R.id.img_menu);
        init();
        imgMenu.setOnClickListener(this);

        return view;
    }

    private void init() {
        for(int i=0;i<IMAGES.length;i++)
            ImagesArray.add(IMAGES[i]);
        mPager.setAdapter(new SlidingImageAdapter(getActivity(),ImagesArray));

        indicator.setViewPager(mPager);

        final float density = getResources().getDisplayMetrics().density;

//Set circle indicator radius
        indicator.setRadius(5 * density);

        NUM_PAGES =IMAGES.length;

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);

        // Pager listener over indicator
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;

            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_menu:
                DashboardActivity.dLayout.openDrawer(Gravity.LEFT);
                break;
        }

    }
}
